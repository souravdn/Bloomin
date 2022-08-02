package com.example.simplecalc;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class EditProfileActivity extends AppCompatActivity implements LocationListener {

    int storage_permission_code = 1;
    ImageView profile;
    ImageButton pencil;
    String[] gender = {"Male", "Female", "Other"};
    AutoCompleteTextView autoCompleteTextView;
    TextInputEditText bday, user_location, edit_name, edit_email, edit_ph, edit_pass, edit_confirm;
    DatePickerDialog.OnDateSetListener onDateSetListener;
    LocationManager locationManager;
    AppCompatButton save_details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        profile = findViewById(R.id.profile_image);
        pencil = findViewById(R.id.pencil_btn);
        autoCompleteTextView = findViewById(R.id.edit_gender);
        bday = findViewById(R.id.edit_bday);
        bday.setShowSoftInputOnFocus(false);
        bday.setCursorVisible(false);
        user_location = findViewById(R.id.edit_location);
        user_location.setShowSoftInputOnFocus(false);
        user_location.setCursorVisible(false);
        edit_name = findViewById(R.id.edit_name);
        edit_email = findViewById(R.id.edit_email);
        edit_ph = findViewById(R.id.edit_phone);
        edit_pass = findViewById(R.id.edit_password);
        edit_confirm = findViewById(R.id.edit_cpassword);
        save_details = findViewById(R.id.save_details);

        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.gender_list, gender);
        autoCompleteTextView.setAdapter(adapter);

        pencil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ContextCompat.checkSelfPermission(EditProfileActivity.this,
                        Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                    ImagePicker.Companion.with(EditProfileActivity.this)
                            .crop()
                            .cropSquare()
                            .compress(1024)
                            .maxResultSize(1080, 1080)
                            .start();
                }
                else {
                    requestStoragePermission();
                }
            }
        });

        user_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(EditProfileActivity.this, "Wait for Few Seconds", Toast.LENGTH_SHORT).show();
                if(ContextCompat.checkSelfPermission(EditProfileActivity.this,
                        Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(EditProfileActivity.this, new String[]{
                            Manifest.permission.ACCESS_FINE_LOCATION
                    }, 100);
                }
                else{
                    getLocation();
                }
            }
        });

        bday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        EditProfileActivity.this, android.R.style.Theme_Holo_Light_Dialog,
                        onDateSetListener, year, month, day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
                datePickerDialog.show();
            }
        });


        onDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                month = month + 1;
                String date = dayOfMonth + "/" + month + "/" + year;
                bday.setText(date);
            }
        };

        // Click on SAVE DETAILS Button
        save_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(Objects.requireNonNull(edit_name.getText()).toString())){
                    edit_name.setError("Name is required.");
                    edit_name.requestFocus();
                    return;
                }
                if(TextUtils.isEmpty(Objects.requireNonNull(edit_email.getText()).toString())){
                    edit_email.setError("Email is required.");
                    edit_email.requestFocus();
                    return;
                } else if(!Patterns.EMAIL_ADDRESS.matcher(edit_email.getText().toString()).matches()){
                    edit_email.setError("Enter Valid Email Address.");
                    edit_email.requestFocus();
                    return;
                }
                if(TextUtils.isEmpty(Objects.requireNonNull(edit_ph.getText()).toString())){
                    edit_ph.setError("Phone Number is required.");
                    edit_ph.requestFocus();
                    return;
                } else if(!android.util.Patterns.PHONE.matcher(edit_ph.getText().toString()).matches()){
                    edit_ph.setError("Enter Valid Phone Number.");
                    edit_ph.requestFocus();
                    return;
                }
                if(!Objects.requireNonNull(edit_pass.getText()).toString().equals(Objects.requireNonNull(edit_confirm.getText()).toString())){
                    Toast.makeText(EditProfileActivity.this, "Passwords Doesn't Match", Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(getApplicationContext(), "Profile Updated", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Uri uri = data.getData();
        profile.setImageURI(uri);
    }

    private void requestStoragePermission() {
        if(ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)){
            new AlertDialog.Builder(this)
                    .setTitle("Permission Needed")
                    .setMessage("Permission is Needed to set Profile Picture.")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            ActivityCompat.requestPermissions(EditProfileActivity.this,
                                    new String[] {Manifest.permission.READ_EXTERNAL_STORAGE},
                                    storage_permission_code);

                        }
                    })
                    .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    })
                    .create().show();
        }
        else{
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, storage_permission_code);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == storage_permission_code) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                ImagePicker.Companion.with(EditProfileActivity.this)
                        .crop()
                        .cropSquare()
                        .compress(1024)
                        .maxResultSize(1080, 1080)
                        .start();
            }
            else{
                Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @SuppressLint("MissingPermission")
    private void getLocation() {
        try {
            locationManager = (LocationManager) getApplicationContext().getSystemService(LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1, 1, EditProfileActivity.this);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
        try{
            Geocoder geocoder = new Geocoder(EditProfileActivity.this, Locale.getDefault());
            List<Address> addressList = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
            String address = addressList.get(0).getAddressLine(0);
            user_location.setText(address);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}