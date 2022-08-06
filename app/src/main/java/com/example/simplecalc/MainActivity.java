package com.example.simplecalc;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.List;
import java.util.Locale;
public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    HomeFragment homeFragment=new HomeFragment();
    ReminderFragment reminderFragment=new ReminderFragment(this);
    ShopFragment shopFragment=new ShopFragment();
    ExploreFragment exploreFragment=new ExploreFragment();
    int counter = 0;

    @Override
    public void onBackPressed() {
        counter++;
        if(counter == 1){
            Toast.makeText(this, "Press Again to Exit", Toast.LENGTH_SHORT).show();
        }
        if(counter == 2) {
            super.onBackPressed();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        bottomNavigationView=findViewById(R.id.bottom_nav);

        getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();
                        return true;
                    case R.id.explore:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,exploreFragment).commit();
                        return true;
                    case R.id.reminder:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,reminderFragment).commit();
                        return true;
                    case R.id.shop:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,shopFragment).commit();
                        return true;
                }
                return false;
            }
        });
    }
}