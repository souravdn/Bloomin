package com.example.simplecalc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class outdoor extends AppCompatActivity implements Recyclerview_interface {
    private RecyclerView rcv1;
    private ArrayList<outdoor_model> outdoorModelArratList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outdoor);

        rcv1=findViewById(R.id.outdoor_rcv);

        outdoorModelArratList=new ArrayList<outdoor_model>();
        outdoorModelArratList.add(new outdoor_model("Bigleaf hydrangea","Hydrangea macrophylla",R.drawable.bigleaf_hydrangea)) ;
        outdoorModelArratList.add(new outdoor_model("Bougainvillea","Bougainvillea spectabilis",R.drawable.bougainvillea)) ;
        outdoorModelArratList.add(new outdoor_model("Bigleaf hydrangea","Hydrangea macrophylla",R.drawable.bigleaf_hydrangea)) ;
        outdoorModelArratList.add(new outdoor_model("Bougainvillea","Bougainvillea spectabilis",R.drawable.bougainvillea)) ;

        outdoorModelArratList.add(new outdoor_model("Bigleaf hydrangea","Hydrangea macrophylla",R.drawable.bigleaf_hydrangea)) ;
        outdoorModelArratList.add(new outdoor_model("Bougainvillea","Bougainvillea spectabilis",R.drawable.bougainvillea)) ;

        outdoorModelArratList.add(new outdoor_model("Bigleaf hydrangea","Hydrangea macrophylla",R.drawable.bigleaf_hydrangea)) ;
        outdoorModelArratList.add(new outdoor_model("Bougainvillea","Bougainvillea spectabilis",R.drawable.bougainvillea)) ;



        outdoor_adapter outdoor_adapter=new outdoor_adapter(this,outdoorModelArratList,this);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rcv1.setLayoutManager(linearLayoutManager);
        rcv1.setAdapter(outdoor_adapter);
    }

    //what is going to be happen after click each view
    @Override
    public void onitemClick(int position) {
        Intent intent = new Intent(outdoor.this, indoor_single_page_activity.class);
        intent.putExtra("IMAGE", outdoorModelArratList.get(position).getTree_img());
        intent.putExtra("TEXT1", outdoorModelArratList.get(position).getTree_name1());
        intent.putExtra("TEXT2", outdoorModelArratList.get(position).getTree_name2());

        startActivity(intent);

    }
}