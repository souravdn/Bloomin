package com.example.simplecalc;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class ShopFragment extends Fragment {

    RecyclerView shop_recyclerview;
    List<String> shop_titles;
    List<Integer> shop_images;
    ShopAdapter shopAdapter;

    Activity main;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        main = getActivity();
        return inflater.inflate(R.layout.fragment_shop, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        shop_recyclerview = main.findViewById(R.id.shop_recyclerview);
        shop_titles = new ArrayList<>();
        shop_images = new ArrayList<>();
        shopAdapter = new ShopAdapter(main, shop_titles, shop_images);

        shop_images.add(R.drawable.liveplant);
        shop_images.add(R.drawable.seeds);
        shop_images.add(R.drawable.planter);
        shop_images.add(R.drawable.soil);
        shop_images.add(R.drawable.watering);
        shop_images.add(R.drawable.gardentools);
        shop_titles.add("Live Plants");
        shop_titles.add("Seeds");
        shop_titles.add("Planter");
        shop_titles.add("Soil & Fertilizers");
        shop_titles.add("Water Equipments");
        shop_titles.add("Tools & Accessories");

        GridLayoutManager gridLayoutManager = new GridLayoutManager(main, 2, GridLayoutManager.VERTICAL, false);
        shop_recyclerview.setLayoutManager(gridLayoutManager);
        shop_recyclerview.setHasFixedSize(true);
        shop_recyclerview.setAdapter(shopAdapter);
    }
}