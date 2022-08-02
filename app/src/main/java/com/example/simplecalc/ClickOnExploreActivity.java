package com.example.simplecalc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ClickOnExploreActivity extends AppCompatActivity {

    RecyclerView explore_onclick_recyclerview;
    List<String> plant_titles;
    List<Integer> plant_images;
    List<String> plant_sci;
    ExploreOnClickAdapter exploreOnClickAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click_on_explore);

        explore_onclick_recyclerview = findViewById(R.id.explore_onclick_recyclerview);
        plant_titles = new ArrayList<>();
        plant_images = new ArrayList<>();
        plant_sci = new ArrayList<>();
        exploreOnClickAdapter = new ExploreOnClickAdapter(this, plant_titles, plant_sci, plant_images);

        plant_images.add(R.drawable.rose);
        plant_images.add(R.drawable.bougainvillea);
        plant_images.add(R.drawable.jasmine);
        plant_images.add(R.drawable.bigleaf_hydrangea);
        plant_images.add(R.drawable.ming_alalia);
        plant_images.add(R.drawable.ixora);
        plant_images.add(R.drawable.cape_honeysuckle);
        plant_images.add(R.drawable.duranta);
        plant_images.add(R.drawable.gardenia);
        plant_images.add(R.drawable.song_of_india);

        plant_titles.add("Rose");
        plant_titles.add("Bougainvillea");
        plant_titles.add("Jasmine");
        plant_titles.add("Bigleaf Hydrangea");
        plant_titles.add("Ming Aralia");
        plant_titles.add("Ixora");
        plant_titles.add("Cape Honeysuckle");
        plant_titles.add("Duranta");
        plant_titles.add("Gardenia");
        plant_titles.add("Song of India");

        plant_sci.add("Rosa");
        plant_sci.add("Bougainvillea");
        plant_sci.add("Jasminum polyanthum");
        plant_sci.add("Hydrangea Macrophylla");
        plant_sci.add("Polyscias fruticosa");
        plant_sci.add("Ixora coccinea");
        plant_sci.add("Tecoma capensis");
        plant_sci.add("Duranta erecta");
        plant_sci.add("Gardenia jasminoides");
        plant_sci.add("Dracaena reflexa");

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false);
        explore_onclick_recyclerview.setLayoutManager(gridLayoutManager);
        explore_onclick_recyclerview.setHasFixedSize(true);
        explore_onclick_recyclerview.setAdapter(exploreOnClickAdapter);
    }
}