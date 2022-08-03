package com.example.simplecalc;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
    }

    @Override
    public int getItemCount() {
        return explore_titles.size();
    }

    public class ExploreViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView explore_image;
        TextView explore_text;

        public ExploreViewHolder(@NonNull View itemView){
            super(itemView);
            itemView.setOnClickListener(this);

            explore_image = itemView.findViewById(R.id.explore_image);
            explore_text = itemView.findViewById(R.id.explore_text);

            explore_image.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = this.getAdapterPosition();
            switch (position){
                case 0:
                    Intent floweringIntent = new Intent(context, FloweringActivity.class);
                    context.startActivity(floweringIntent);
                    break;
                case 1:
                    Intent foliageIntent = new Intent(context, FoliagePlantsActivity.class);
                    context.startActivity(foliageIntent);
                    break;
                case 2:
                    Intent cactiIntent = new Intent(context, CactiActivity.class);
                    context.startActivity(cactiIntent);
                    break;
                case 3:
                    Intent exploreIntent = new Intent(context, ClickOnExploreActivity.class);
                    context.startActivity(exploreIntent);
                    break;
                case 4:
                    Intent herbIntent = new Intent(context, HerbsActivity.class);
                    context.startActivity(herbIntent);
                    break;
                case 5:
                    Intent treeIntent = new Intent(context, TreesActivity.class);
                    context.startActivity(treeIntent);
                    break;
            }

        }
    }
}
