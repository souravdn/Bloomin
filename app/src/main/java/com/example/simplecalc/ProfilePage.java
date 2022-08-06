package com.example.simplecalc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Hashtable;
import java.util.List;
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfilePage extends AppCompatActivity implements LocationListener {

    AppCompatButton edit_btn, logoutBtn;
    LocationManager locationManager;
    TextView city_name;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);
        edit_btn = findViewById(R.id.edit);
        logoutBtn = findViewById(R.id.logout);
        city_name = findViewById(R.id.city_name);
        mAuth=FirebaseAuth.getInstance();

        TextView name = findViewById(R.id.user_name);
        TextView gender = findViewById(R.id.user_gender);
        TextView dob = findViewById(R.id.user_birthday);
        TextView email = findViewById(R.id.user_email);
        TextView phone = findViewById(R.id.user_phone);
        TextView address = findViewById(R.id.user_address);
        CircleImageView profileImg = findViewById(R.id.profile_image);

        UserDB userDb = new UserDB(getApplicationContext());
        Hashtable<String, String> user = userDb.getUser();

        name.setText(user.get("name"));
        gender.setText(user.get("gender"));
        dob.setText(user.get("birthday"));
        email.setText(user.get("email"));
        phone.setText(user.get("phoneNo"));
        address.setText(user.get("address"));
        Integer img = getResources().getIdentifier(user.get("profilePic"), "drawable", getPackageName());
//        profileImg.setImageResource(img);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION
            }, 100);
        } else {
            getLocation();
        }

        edit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), EditProfileActivity.class);
                startActivity(intent);
            }
        });

        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                UserDB userDb = new UserDB(getApplicationContext());
                userDb.signOut();
                startActivity(new Intent(ProfilePage.this,signin.class));
            }
        });
    }

    @SuppressLint("MissingPermission")
    private void getLocation() {
        try {
            locationManager = (LocationManager) getApplicationContext().getSystemService(LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1, 1, ProfilePage.this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onLocationChanged(@NonNull Location location) {
        try {
            Geocoder geocoder = new Geocoder(ProfilePage.this, Locale.getDefault());
            List<Address> addressList = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
            String city = addressList.get(0).getLocality();
            String country = addressList.get(0).getCountryName();
            city_name.setText(city + ", " + country);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}