package com.example.simplecalc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class HerbsActivity extends AppCompatActivity {

    RecyclerView explore_onclick_recyclerview;
    List<String> plant_titles;
    List<Integer> plant_images;
    List<String> plant_sci;
    ExploreOnClickAdapter exploreOnClickAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_herbs);

        explore_onclick_recyclerview = findViewById(R.id.herbs_onclick_recyclerview);
        plant_titles = new ArrayList<>();
        plant_images = new ArrayList<>();
        plant_sci = new ArrayList<>();
        exploreOnClickAdapter = new ExploreOnClickAdapter(this, plant_titles, plant_sci, plant_images);

        plant_images.add(R.drawable.herbs_parsley);
        plant_images.add(R.drawable.herbs_lemongrass);
        plant_images.add(R.drawable.herbs_basil);
        plant_images.add(R.drawable.herbs_mint);
        plant_images.add(R.drawable.herbs_oregano);
        plant_images.add(R.drawable.cilantro);
        plant_images.add(R.drawable.herbs_thyme);
        plant_images.add(R.drawable.herbs_sage);
        plant_images.add(R.drawable.herbs_rosemary);
        plant_images.add(R.drawable.herbs_peppermint);


        plant_titles.add("Parsley");
        plant_titles.add("Lemongrass");
        plant_titles.add("Basil");
        plant_titles.add("Mint");
        plant_titles.add("Oregano");
        plant_titles.add("Cilantro");
        plant_titles.add("Thyme");
        plant_titles.add("Sage");
        plant_titles.add("Rosemary");
        plant_titles.add("Peppermint");

        plant_sci.add("Petroselinum crispum");
        plant_sci.add("Cymbopogon citratus");
        plant_sci.add("Ocimum basilicum");
        plant_sci.add("Mentha");
        plant_sci.add("Origanum vulgare");
        plant_sci.add("Coriandrum sativums");
        plant_sci.add("Thymus vulgaris");
        plant_sci.add("Salvia officinalis");
        plant_sci.add("Rosmarinus officinalis");
        plant_sci.add("Mentha piperita");

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false);
        explore_onclick_recyclerview.setLayoutManager(gridLayoutManager);
        explore_onclick_recyclerview.setHasFixedSize(true);
        explore_onclick_recyclerview.setAdapter(exploreOnClickAdapter);
    }
}