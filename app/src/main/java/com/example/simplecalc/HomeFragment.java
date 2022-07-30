package com.example.simplecalc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class HomeFragment extends Fragment {

    Activity main;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        main = getActivity();
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    public void onStart(){
        super.onStart();
        ImageButton imgP = (ImageButton) main.findViewById(R.id.profile);
        imgP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(main, ProfilePage.class);
                startActivity(intent);
            }
        });
    }

}