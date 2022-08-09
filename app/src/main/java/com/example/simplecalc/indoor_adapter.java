package com.example.simplecalc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class indoor_adapter extends RecyclerView.Adapter<indoor_adapter.Viewholder> {
    private final Recyclerview_interface recyclerview_interface;
    private Context context;

    public indoor_adapter(Context context, ArrayList<indoor_model> indoorModelArratList,
                          Recyclerview_interface recyclerview_interface) {
        this.context = context;
        this.indoorModelArratList = indoorModelArratList;
        this.recyclerview_interface = recyclerview_interface;
    }

    private ArrayList<indoor_model> indoorModelArratList;

    @NonNull
    @Override
    public indoor_adapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.indoor_item, parent, false);
        return new Viewholder(view,recyclerview_interface);
    }

    @Override
    public void onBindViewHolder(@NonNull indoor_adapter.Viewholder holder, int position) {

        indoor_model model = indoorModelArratList.get(position);
        holder.tv1.setText(model.getTree_name1());
        holder.tv2.setText(model.getTree_name2());
        holder.iv.setImageResource(model.getTree_img());


    }

    @Override
    public int getItemCount() {
        return indoorModelArratList.size();
    }


    public static class Viewholder extends RecyclerView.ViewHolder {
        public ImageView iv;
        public TextView tv1, tv2;

        public  Viewholder(@NonNull View itemView, final Recyclerview_interface recyclerview_interface) {
            super(itemView);
            iv = itemView.findViewById(R.id.image_indoor1);
            tv1 = itemView.findViewById(R.id.indoor_tv1);
            tv2 = itemView.findViewById(R.id.indoor_tv2);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(recyclerview_interface != null){
                        int position=getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION){
                            recyclerview_interface.onitemClick(position);
                        }
                    }
                }
            });
        }
    }


}
