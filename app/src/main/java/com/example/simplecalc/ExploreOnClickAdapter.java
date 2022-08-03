package com.example.simplecalc;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ExploreOnClickAdapter extends RecyclerView.Adapter<ExploreOnClickAdapter.ExploreOnClickViewHolder> {

    private Context context;
    private List<String> plant_titles;
    private List<String> plant_sci_names;
    private List<Integer> plant_images;

    public ExploreOnClickAdapter(Context context, List<String> plant_titles, List<String> plant_sci_names, List<Integer> plant_images) {
        this.context = context;
        this.plant_titles = plant_titles;
        this.plant_images = plant_images;
        this.plant_sci_names = plant_sci_names;
    }

    @NonNull
    @Override
    public ExploreOnClickViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.explore_onclick_griditem, parent, false);
        return new ExploreOnClickViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ExploreOnClickViewHolder holder, int position) {
        holder.plant_circle_image.setImageResource(plant_images.get(position));
        holder.plant_title_tv.setText(plant_titles.get(position));
        holder.plant_sci_tv.setText(plant_sci_names.get(position));
    }

    @Override
    public int getItemCount() {
        return plant_titles.size();
    }

    public class ExploreOnClickViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        CircleImageView plant_circle_image;
        TextView plant_title_tv, plant_sci_tv;

        public ExploreOnClickViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            plant_circle_image = itemView.findViewById(R.id.plant_image);
            plant_title_tv = itemView.findViewById(R.id.plant_title);
            plant_sci_tv = itemView.findViewById(R.id.plant_sci_name);
            plant_circle_image.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = this.getAdapterPosition();
            if (position == 0) {
                Intent exploreIntent = new Intent(context, PlantDetailsActivity.class);
                context.startActivity(exploreIntent);
            }
        }
    }
}