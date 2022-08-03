package com.example.simplecalc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class CactiActivity extends AppCompatActivity {

    RecyclerView explore_onclick_recyclerview;
    List<String> plant_titles;
    List<Integer> plant_images;
    List<String> plant_sci;
    ExploreOnClickAdapter exploreOnClickAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cacti);

        explore_onclick_recyclerview = findViewById(R.id.cacti_onclick_recyclerview);
        plant_titles = new ArrayList<>();
        plant_images = new ArrayList<>();
        plant_sci = new ArrayList<>();
        exploreOnClickAdapter = new ExploreOnClickAdapter(this, plant_titles, plant_sci, plant_images);

        plant_images.add(R.drawable.succulents_snake_plant);
        plant_images.add(R.drawable.succulents_jade_plant);
        plant_images.add(R.drawable.succulents_desert_rose);
        plant_images.add(R.drawable.succulents_burros_tail);
        plant_images.add(R.drawable.succulents_prickly_pear);
        plant_images.add(R.drawable.succulents_jade_planthouse_leek);
        plant_images.add(R.drawable.succulents_jade_plantmoon_cactus);
        plant_images.add(R.drawable.aloevera);
        plant_images.add(R.drawable.succulents_christmas_cactus);


        plant_titles.add("Snake Plant");
        plant_titles.add("Jade Plant");
        plant_titles.add("Desert Rose");
        plant_titles.add("Burro’s Tail");
        plant_titles.add("Pricky Pear Cactus");
        plant_titles.add("House Leek");
        plant_titles.add("Moon Cactus");
        plant_titles.add("Aloe Vera");
        plant_titles.add("Christmas Cactus");

        plant_sci.add("Dracaena trifasciata");
        plant_sci.add("Adenium obesum");
        plant_sci.add("Sedum morganianum");
        plant_sci.add("Opuntia");
        plant_sci.add("Sempervivum tectorum");
        plant_sci.add("Gymnocalycium mihanovichii");
        plant_sci.add("Clivia miniata");
        plant_sci.add("Aloe barbadensis miller");
        plant_sci.add("Gymnocalycium mihanovichii");

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false);
        explore_onclick_recyclerview.setLayoutManager(gridLayoutManager);
        explore_onclick_recyclerview.setHasFixedSize(true);
        explore_onclick_recyclerview.setAdapter(exploreOnClickAdapter);
    }
}