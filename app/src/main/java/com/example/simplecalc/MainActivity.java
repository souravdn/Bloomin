package com.example.simplecalc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
         BottomNavigationView bottomNavigationView;
         HomeFragment homeFragment=new HomeFragment();
         ReminderFragment reminderFragment=new ReminderFragment();
         ShopFragment shopFragment=new ShopFragment();
         ExploreFragment exploreFragment=new ExploreFragment();

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