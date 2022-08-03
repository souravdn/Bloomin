package com.example.simplecalc;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.ActivityChooserView;
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

    public class ShopViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView shop_image;
        TextView shop_text;

        public ShopViewHolder(@NonNull View itemView){
            super(itemView);
            itemView.setOnClickListener(this);
            shop_image = itemView.findViewById(R.id.explore_image);
            shop_text = itemView.findViewById(R.id.explore_text);
            shop_image.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = this.getAdapterPosition();
            switch (position){
                case 0:
                    gotoUrl("https://www.amazon.in/s?k=live+plants&i=lawngarden&sprefix=live+p%2Clawngarden%2C321&ref=nb_sb_ss_c_2_6_pltr-ranker-retrain-acsession-acceptance");
                    break;
                case 1:
                    gotoUrl("https://www.amazon.in/s?k=seeds+for+gardening&i=lawngarden&sprefix=seed%2Clawngarden%2C369&ref=nb_sb_ss_pltr-ranker-retrain-acsession-acceptance_1_4");
                    break;
                case 2:
                    gotoUrl("https://www.amazon.in/s?k=planter&i=lawngarden&crid=1T0WRRFNR6V4K&sprefix=planter+stand%2Clawngarden%2C674&ref=nb_sb_noss_1");
                    break;
                case 3:
                    gotoUrl("https://www.amazon.in/s?k=soil+and+fertilizer+for+plants&i=lawngarden&sprefix=soil+and%2Clawngarden%2C286&ref=nb_sb_ss_pltr-ranker-retrain-acsession-acceptance_4_8");
                    break;
                case 4:
                    gotoUrl("https://www.amazon.in/s?k=water+equipment+for+plants&i=lawngarden&sprefix=water+e%2Clawngarden%2C291&ref=nb_sb_ss_i_1_7");
                    break;
                case 5:
                    gotoUrl("https://www.amazon.in/s?k=tools+and+accessories+for+gardening&i=lawngarden&crid=1QSPD35L2CIKI&sprefix=tools+and+accessories+for+gardening%2Clawngarden%2C265&ref=nb_sb_noss");
                    break;

            }
        }

        private void gotoUrl(String s) {
            Uri uri = Uri.parse(s);
            Intent url = new Intent(Intent.ACTION_VIEW, uri);
            context.startActivity(url);
        }
    }
}
