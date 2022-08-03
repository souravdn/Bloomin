package com.example.simplecalc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class FloweringActivity extends AppCompatActivity {

    RecyclerView explore_onclick_recyclerview;
    List<String> plant_titles;
    List<Integer> plant_images;
    List<String> plant_sci;
    ExploreOnClickAdapter exploreOnClickAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flowering);

        explore_onclick_recyclerview = findViewById(R.id.flowering_onclick_recyclerview);
        plant_titles = new ArrayList<>();
        plant_images = new ArrayList<>();
        plant_sci = new ArrayList<>();
        exploreOnClickAdapter = new ExploreOnClickAdapter(this, plant_titles, plant_sci, plant_images);

        plant_images.add(R.drawable.flowering_moth_orchid);
        plant_images.add(R.drawable.anthurium);
        plant_images.add(R.drawable.african_violet);
        plant_images.add(R.drawable.flowering_gloxinia);
        plant_images.add(R.drawable.flowering_peace_lily);
        plant_images.add(R.drawable.flowering_begonia_rieger);
        plant_images.add(R.drawable.flowering_kaffir_lily);
        plant_images.add(R.drawable.flowering_bromeliad);
        plant_images.add(R.drawable.flowering_amaryllis);
        plant_images.add(R.drawable.flowering_poinsettia);


        plant_titles.add("Moth Orchid");
        plant_titles.add("Anthurium");
        plant_titles.add("African Violets");
        plant_titles.add("Gloxinia");
        plant_titles.add("Peace Lily");
        plant_titles.add("Rieger Begonia");
        plant_titles.add("Kaffir Lily");
        plant_titles.add("Bromeliads");
        plant_titles.add("Amaryllis");
        plant_titles.add("Poinsettia");

        plant_sci.add("Phalaenopsis");
        plant_sci.add("Anthurium");
        plant_sci.add("Saintpaulia");
        plant_sci.add("Sinningia");
        plant_sci.add("Spathiphyllum");
        plant_sci.add("Begonia x hiemalis");
        plant_sci.add("Clivia miniata");
        plant_sci.add("Bromelia");
        plant_sci.add("Perennial bulb");
        plant_sci.add("Euphorbia pulcherrima");

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false);
        explore_onclick_recyclerview.setLayoutManager(gridLayoutManager);
        explore_onclick_recyclerview.setHasFixedSize(true);
        explore_onclick_recyclerview.setAdapter(exploreOnClickAdapter);
    }
}