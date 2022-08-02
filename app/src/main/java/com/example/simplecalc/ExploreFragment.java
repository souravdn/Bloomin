package com.example.simplecalc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ExploreFragment extends Fragment {

    RecyclerView explore_recyclerview;
    List<String> explore_titles;
    List<Integer> explore_images;
    ExploreAdapter exploreAdapter;
    TextView ss;


    Activity main;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        main = getActivity();
        return inflater.inflate(R.layout.fragment_explore, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        explore_recyclerview = main.findViewById(R.id.explore_recyclerview);
        explore_titles = new ArrayList<>();
        explore_images = new ArrayList<>();
        exploreAdapter = new ExploreAdapter(main, explore_titles, explore_images);
        ss = main.findViewById(R.id.explore_title);

        explore_images.add(R.drawable.flowering);
        explore_images.add(R.drawable.foliage_plants);
        explore_images.add(R.drawable.succulents);
        explore_images.add(R.drawable.shrubs);
        explore_images.add(R.drawable.herbs);
        explore_images.add(R.drawable.trees);
        explore_titles.add("Flowering Plants");
        explore_titles.add("Foliage Plants");
        explore_titles.add("Succulents & Cacti");
        explore_titles.add("Shrubs");
        explore_titles.add("Herbs ");
        explore_titles.add("Trees");

        GridLayoutManager gridLayoutManager = new GridLayoutManager(main, 2, GridLayoutManager.VERTICAL, false);
        explore_recyclerview.setLayoutManager(gridLayoutManager);
        explore_recyclerview.setHasFixedSize(true);
        explore_recyclerview.setAdapter(exploreAdapter);

    }
}