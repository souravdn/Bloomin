package com.example.simplecalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class indoor_single_page_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.indoor_single_page_activity);



        int img=getIntent().getIntExtra("IMAGE",0);
        String tv1=getIntent().getStringExtra("TEXT1");
        String tv2=getIntent().getStringExtra("TEXT2");



        ImageView imageView=findViewById(R.id.img);
        TextView tv=findViewById(R.id.tv);
        TextView tv3=findViewById(R.id.tv2);

        imageView.setImageResource(img);
        tv.setText(tv1);
        tv3.setText(tv2);
    }

}