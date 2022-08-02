package com.example.simplecalc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class AddPlantsActivity extends AppCompatActivity {

    CardView indoor_btn, outdoor_btn;
    AppCompatButton cancel_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_plants);

        indoor_btn = findViewById(R.id.indoor_card);
        outdoor_btn = findViewById(R.id.outdoor_card);
        cancel_btn = findViewById(R.id.cancel_add_plant);

        indoor_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent indoorIntent = new Intent(getApplicationContext(), indoor.class);
                startActivity(indoorIntent);
            }
        });

        outdoor_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent outdoorIntent = new Intent(getApplicationContext(), outdoor.class);
                startActivity(outdoorIntent);
            }
        });

        cancel_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cancelIntent = new Intent(getApplicationContext(), PlantDetailsActivity.class);
                startActivity(cancelIntent);
            }
        });

    }
}