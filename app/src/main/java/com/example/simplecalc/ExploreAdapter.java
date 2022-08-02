package com.example.simplecalc;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ExploreAdapter extends RecyclerView.Adapter<ExploreAdapter.ExploreViewHolder> {

    Context context;
    List<String> explore_titles;
    List<Integer> explore_images;

    public ExploreAdapter(Context context, List<String> explore_titles, List<Integer> explore_images){
        this.context = context;
        this.explore_titles = explore_titles;
        this.explore_images = explore_images;
    }

    @NonNull
    @Override
    public ExploreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.explore_grid_items, parent, false);
        return new ExploreViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ExploreViewHolder holder, int position) {
        holder.explore_image.setImageResource(explore_images.get(position));
        holder.explore_text.setText(explore_titles.get(position));
        holder.explore_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ClickOnExploreActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return explore_titles.size();
    }

    public static class ExploreViewHolder extends RecyclerView.ViewHolder{

        ImageView explore_image;
        TextView explore_text;

        public ExploreViewHolder(@NonNull View itemView){
            super(itemView);

            explore_image = itemView.findViewById(R.id.explore_image);
            explore_text = itemView.findViewById(R.id.explore_text);
        }
    }
}
