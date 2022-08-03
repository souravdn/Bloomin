package com.example.simplecalc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class PlantDetailsActivity extends AppCompatActivity {

    AppCompatButton add_plant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_details);

        int img=getIntent().getIntExtra("Image",0);
        String name=getIntent().getStringExtra("Name");
        String sci_name = getIntent().getStringExtra("Sci_name");
        String description = getIntent().getStringExtra("Description");
        String plant_type = getIntent().getStringExtra("Type");

        ImageView imageView=findViewById(R.id.plant_cover_img);
        TextView title = findViewById(R.id.plant_details_title);
        TextView botanical = findViewById(R.id.attr1);
        TextView desc = findViewById(R.id.plant_details_description);
        TextView type = findViewById(R.id.attr2);


        imageView.setImageResource(img);
        title.setText(name);
        botanical.setText(sci_name);
        desc.setText(description);
        type.setText(plant_type);

        add_plant = findViewById(R.id.add_plant);

        add_plant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AddPlantsActivity.class);
                startActivity(intent);
            }
        });

    }
}