package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    ImageView imageView;
    TextView tvtitle,tvdescrip,tvrating,tvprice;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        imageView=findViewById(R.id.imageView2);
        tvtitle=findViewById(R.id.tvtitleone);
        tvdescrip=findViewById(R.id.TV_Descripone);
        tvrating=findViewById(R.id.TV_Ratingone);
        tvprice=findViewById(R.id.TV_Priceone);

        Intent intent=getIntent();
        String title = intent.getStringExtra("title1");
        String descrip = intent.getStringExtra("descrip");
        String rating = intent.getStringExtra("rating");
        String price = intent.getStringExtra("price");
        int image = intent.getIntExtra("image1",0);

        tvtitle.setText(title);
        tvdescrip.setText(descrip);
        tvrating.setText(rating);
        tvprice.setText(price);
        imageView.setImageResource(image);







    }
}