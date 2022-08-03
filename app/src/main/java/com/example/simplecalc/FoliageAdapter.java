package com.example.simplecalc;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class FoliageAdapter extends RecyclerView.Adapter<FoliageAdapter.FoilageOnClickViewHolder> {

    private Context context;
    private List<String> plant_titles;
    private List<String> plant_sci_names;
    private List<Integer> plant_images;
    List<String> plant_desc;
    List<String> plant_type;

    public FoliageAdapter(Context context, List<String> plant_titles, List<String> plant_sci_names, List<Integer> plant_images, List<String> plant_desc,List<String> plant_type) {
        this.context = context;
        this.plant_titles = plant_titles;
        this.plant_images = plant_images;
        this.plant_sci_names = plant_sci_names;
        this.plant_desc = plant_desc;
        this.plant_type = plant_type;
    }

    @NonNull
    @Override
    public FoliageAdapter.FoilageOnClickViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.explore_onclick_griditem, parent, false);
        return new FoliageAdapter.FoilageOnClickViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FoliageAdapter.FoilageOnClickViewHolder holder, int position) {
        holder.plant_circle_image.setImageResource(plant_images.get(position));
        holder.plant_title_tv.setText(plant_titles.get(position));
        holder.plant_sci_tv.setText(plant_sci_names.get(position));
    }

    @Override
    public int getItemCount() {
        return plant_titles.size();
    }

    public class FoilageOnClickViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        CircleImageView plant_circle_image;
        TextView plant_title_tv, plant_sci_tv;

        public FoilageOnClickViewHolder(@NonNull View itemView) {
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
            Intent exploreIntent = new Intent(context, PlantDetailsActivity.class);
            exploreIntent.putExtra("Image", plant_images.get(position));
            exploreIntent.putExtra("Name", plant_titles.get(position));
            exploreIntent.putExtra("Sci_name", plant_sci_names.get(position));
            exploreIntent.putExtra("Description", plant_desc.get(position));
            exploreIntent.putExtra("Type", plant_type.get(position));

            context.startActivity(exploreIntent);
        }
    }
}
