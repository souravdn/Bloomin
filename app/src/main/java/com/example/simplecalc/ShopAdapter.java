package com.example.simplecalc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ShopViewHolder> {

    Context context;
    List<String> shop_titles;
    List<Integer> shop_images;

    public ShopAdapter(Context context, List<String> shop_titles, List<Integer> shop_images){
        this.context = context;
        this.shop_titles = shop_titles;
        this.shop_images = shop_images;
    }

    @NonNull
    @Override
    public ShopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.explore_grid_items, parent, false);
        return new ShopViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ShopViewHolder holder, int position) {
        holder.shop_image.setImageResource(shop_images.get(position));
        holder.shop_text.setText(shop_titles.get(position));
    }

    @Override
    public int getItemCount() {
        return shop_titles.size();
    }

    public static class ShopViewHolder extends RecyclerView.ViewHolder{

        ImageView shop_image;
        TextView shop_text;

        public ShopViewHolder(@NonNull View itemView){
            super(itemView);

            shop_image = itemView.findViewById(R.id.explore_image);
            shop_text = itemView.findViewById(R.id.explore_text);
        }
    }
}
