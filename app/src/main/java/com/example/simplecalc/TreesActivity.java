package com.example.simplecalc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class TreesActivity extends AppCompatActivity {

    RecyclerView explore_onclick_recyclerview;
    List<String> plant_titles;
    List<Integer> plant_images;
    List<String> plant_sci;
    ExploreOnClickAdapter exploreOnClickAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trees);

        explore_onclick_recyclerview = findViewById(R.id.trees_onclick_recyclerview);
        plant_titles = new ArrayList<>();
        plant_images = new ArrayList<>();
        plant_sci = new ArrayList<>();
        exploreOnClickAdapter = new ExploreOnClickAdapter(this, plant_titles, plant_sci, plant_images);

        plant_images.add(R.drawable.tree_fiddleleaf_fig);
        plant_images.add(R.drawable.tree_areca_palm);
        plant_images.add(R.drawable.tree_dragon_tree);
        plant_images.add(R.drawable.tree_weeping_fig);
        plant_images.add(R.drawable.tree_norfolkisland_palm);
        plant_images.add(R.drawable.tree_rubber_tree);
        plant_images.add(R.drawable.tree_ponytail_palm);
        plant_images.add(R.drawable.tree_money_tree);
        plant_images.add(R.drawable.tree_bay_laurel);
        plant_images.add(R.drawable.tree_corn_plant);


        plant_titles.add("Fiddleleaf Fig");
        plant_titles.add("Areca Palm");
        plant_titles.add("Dragon Tree");
        plant_titles.add("Weeping Fig");
        plant_titles.add("Norfolk Island Pine");
        plant_titles.add("Rubber Tree");
        plant_titles.add("Ponytail Palm");
        plant_titles.add("Money Tree");
        plant_titles.add("Bay Laurel");
        plant_titles.add("Corn Plant");

        plant_sci.add("Ficus lyrata");
        plant_sci.add("Dypsis lutescens");
        plant_sci.add("Dracaena marginata");
        plant_sci.add("Ficus benjamina");
        plant_sci.add("Araucaria heterophylla");
        plant_sci.add("Ficus elastica");
        plant_sci.add("Beaucarnea recurvata");
        plant_sci.add("Pachira aquatica");
        plant_sci.add("Laurus nobilis");
        plant_sci.add("Dracaena fragrans");

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false);
        explore_onclick_recyclerview.setLayoutManager(gridLayoutManager);
        explore_onclick_recyclerview.setHasFixedSize(true);
        explore_onclick_recyclerview.setAdapter(exploreOnClickAdapter);
    }
}