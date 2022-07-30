package com.example.simplecalc;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import java.time.*;


public class HomeFragment extends Fragment {

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





    }

}