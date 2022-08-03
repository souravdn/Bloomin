package com.example.simplecalc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class indoor extends AppCompatActivity implements Recyclerview_interface {
    private RecyclerView rcv;
    private ArrayList<indoor_model> indoorModelArratList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indoor);

        rcv = findViewById(R.id.indoor_rcv);

        indoorModelArratList = new ArrayList<>();
        indoorModelArratList.add(new indoor_model("Aloveraa", "Aloe barbadensis miller", R.drawable.aloevera));
        indoorModelArratList.add(new indoor_model("Jasmine", "Jasminum Nudiflorum", R.drawable.jasmine));
        indoorModelArratList.add(new indoor_model("Aloveraa", "Aloe barbadensis miller", R.drawable.aloevera));
        indoorModelArratList.add(new indoor_model("Jasmine", "Jasminum Nudiflorum", R.drawable.jasmine));

        indoorModelArratList.add(new indoor_model("Aloveraa", "Aloe barbadensis miller", R.drawable.aloevera));
        indoorModelArratList.add(new indoor_model("Jasmine", "Jasminum Nudiflorum", R.drawable.jasmine));

        indoorModelArratList.add(new indoor_model("Aloveraa", "Aloe barbadensis miller", R.drawable.aloevera));
        indoorModelArratList.add(new indoor_model("Jasmine", "Jasminum Nudiflorum", R.drawable.jasmine));

        indoorModelArratList.add(new indoor_model("Aloveraa", "Aloe barbadensis miller", R.drawable.aloevera));
        indoorModelArratList.add(new indoor_model("Jasmine", "Jasminum Nudiflorum", R.drawable.jasmine));


        indoor_adapter indoor_adapter = new indoor_adapter(this, indoorModelArratList, this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rcv.setLayoutManager(linearLayoutManager);
        rcv.setAdapter(indoor_adapter);
    }

    //what is going to be happen after click each view
    @Override
    public void onitemClick(int position) {
        Intent intent = new Intent(indoor.this, indoor_single_page_activity.class);
        intent.putExtra("IMAGE", indoorModelArratList.get(position).getTree_img());
        intent.putExtra("TEXT1", indoorModelArratList.get(position).getTree_name1());
        intent.putExtra("TEXT2", indoorModelArratList.get(position).getTree_name2());

        startActivity(intent);

    }
}