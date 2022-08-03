package com.example.simplecalc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class FoliagePlantsActivity extends AppCompatActivity {

    RecyclerView explore_onclick_recyclerview;
    List<String> plant_titles;
    List<Integer> plant_images;
    List<String> plant_sci;
    ExploreOnClickAdapter exploreOnClickAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foliage_plants);

        explore_onclick_recyclerview = findViewById(R.id.foliage_onclick_recyclerview);
        plant_titles = new ArrayList<>();
        plant_images = new ArrayList<>();
        plant_sci = new ArrayList<>();
        exploreOnClickAdapter = new ExploreOnClickAdapter(this, plant_titles, plant_sci, plant_images);

        plant_images.add(R.drawable.monstera);
        plant_images.add(R.drawable.foliage_golden_pothos);
        plant_images.add(R.drawable.foliage_foliage_spider_plant);
        plant_images.add(R.drawable.foliage_swisscheese_plant);
        plant_images.add(R.drawable.foliage_lucky_bamboo);
        plant_images.add(R.drawable.foliage_philodendron);
        plant_images.add(R.drawable.foliage_zz_plant);
        plant_images.add(R.drawable.foliage_croton);


        plant_titles.add("Monstera Deliciosa");
        plant_titles.add("Golden Pothos");
        plant_titles.add("Spider Plant");
        plant_titles.add("Swiss Cheese Plant");
        plant_titles.add("Lucky Bamboo");
        plant_titles.add("Philodendron");
        plant_titles.add("ZZ Plant");
        plant_titles.add("Croton");

        plant_sci.add("Monstera deliciosa");
        plant_sci.add("Epipremnum aureum");
        plant_sci.add("Chlorophytum comosum");
        plant_sci.add("Monstera adansonii");
        plant_sci.add("Dracaena sanderiana");
        plant_sci.add("Philodendron");
        plant_sci.add("Zamioculcas zamiifolia");
        plant_sci.add("Maranta leuconeura");
        plant_sci.add("Codiaeum variegatum");

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false);
        explore_onclick_recyclerview.setLayoutManager(gridLayoutManager);
        explore_onclick_recyclerview.setHasFixedSize(true);
        explore_onclick_recyclerview.setAdapter(exploreOnClickAdapter);

    }
}