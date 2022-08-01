package com.example.simplecalc;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.time.*;
import java.util.List;
import java.util.Locale;
import java.util.Objects;


public class HomeFragment extends Fragment implements LocationListener {

    TextView user_location_tv, user_city_state;
    LocationManager locationManager;
    ImageView location_icon;

    Activity main;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        main = getActivity();
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void onStart(){
        super.onStart();
        ImageButton imgP = (ImageButton) main.findViewById(R.id.profile);
        CardView card1=main.findViewById(R.id.indoor);
        CardView card2=main.findViewById(R.id.outdoor);
        LinearLayout linearLayout = main.findViewById(R.id.myplants);
        user_location_tv = main.findViewById(R.id.user_location_home);
        location_icon = main.findViewById(R.id.location_icon);
        user_city_state = main.findViewById(R.id.user_city_state);

        location_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ContextCompat.checkSelfPermission(main, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(main, "Allow Bloomin` to Access Your Location", Toast.LENGTH_SHORT).show();
                    ActivityCompat.requestPermissions(main, new String[]{
                            Manifest.permission.ACCESS_FINE_LOCATION
                    }, 100);
                }
                else{
                    Toast.makeText(main, "Fetching Location", Toast.LENGTH_SHORT).show();
                    getLocation();
                }
            }
        });

        imgP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(main, ProfilePage.class);
                startActivity(intent);
            }
        });

        card1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(main,indoor.class);
                startActivity(intent);
            }
        });
        card2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(main,outdoor.class);
                startActivity(intent);
            }
        });

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(main,myplants.class);
                startActivity(intent);
            }
        });

        if(ContextCompat.checkSelfPermission(main, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(main, new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION
            }, 100);
        }
        else{
            getLocation();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @SuppressLint("MissingPermission")
    private void getLocation() {
        try {
            locationManager = (LocationManager) main.getApplicationContext().getSystemService(Context.LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1, 1, this);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onLocationChanged(@NonNull Location location) {
        try{
            Geocoder geocoder = new Geocoder(main, Locale.getDefault());
            List<Address> addressList = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
            String local = addressList.get(0).getSubLocality();
            String area = addressList.get(0).getSubAdminArea();
            String city = addressList.get(0).getLocality();
            String state = addressList.get(0).getAdminArea();
            String pin = addressList.get(0).getPostalCode();
            if(!Objects.equals(local, ""))
                user_location_tv.setText(local);
            else if(!Objects.equals(area, ""))
                user_location_tv.setText(area);
            else
                user_location_tv.setText(city);
            user_city_state.setText(city + "," + state + " " + pin);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}