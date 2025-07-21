package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    LaptopAdapter adapter;
    List<Laptops> laptopsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView= findViewById(R.id.recyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        laptopsList = new ArrayList<>();
        laptopsList.add(new Laptops(1,"Apple MacBook Air Core i5 5th Gen _(8GB/128GB SSD/Mac OS Sierra)", "13.3 Inch, 256GB",4.3, 60000, R.drawable.macbook ));
        laptopsList.add(new Laptops(1,"Dell Inspiron 7000 Core i5 7th Gen - (8 GB/1 TB HDD/Windows 10 Home)","14 inch, Gray, 1.659 kg", 4.3,60000,  R.drawable.dellinspiron));
        laptopsList.add(new Laptops(1, "Microsoft Surface Pro 4 Core m3 6th Gen - (4 GB/128 GB SSD/Windows 10)","13.3 inch, Silver, 1.35 kg",4.3,6000, R.drawable.surface));
        laptopsList.add(new Laptops(1,"Apple MacBook Air Core i5 5th Gen _(8GB/128GB SSD/Mac OS Sierra)", "13.3 Inch, 256GB",4.3, 60000, R.drawable.macbook ));
        laptopsList.add(new Laptops(1,"Dell Inspiron 7000 Core i5 7th Gen - (8 GB/1 TB HDD/Windows 10 Home)","14 inch, Gray, 1.659 kg", 4.3,60000,  R.drawable.dellinspiron));
        laptopsList.add(new Laptops(1, "Microsoft Surface Pro 4 Core m3 6th Gen - (4 GB/128 GB SSD/Windows 10)","13.3 inch, Silver, 1.35 kg",4.3,6000, R.drawable.surface));
        laptopsList.add(new Laptops(1,"Apple MacBook Air Core i5 5th Gen _(8GB/128GB SSD/Mac OS Sierra)", "13.3 Inch, 256GB",4.3, 60000, R.drawable.macbook ));
        laptopsList.add(new Laptops(1,"Dell Inspiron 7000 Core i5 7th Gen - (8 GB/1 TB HDD/Windows 10 Home)","14 inch, Gray, 1.659 kg", 4.3,60000,  R.drawable.dellinspiron));
        laptopsList.add(new Laptops(1, "Microsoft Surface Pro 4 Core m3 6th Gen - (4 GB/128 GB SSD/Windows 10)","13.3 inch, Silver, 1.35 kg",4.3,6000, R.drawable.surface));
      laptopsList.add(new Laptops(2,"fgr","mgkm",3.4,40000,R.drawable.surface));
        adapter=new LaptopAdapter(MainActivity.this,laptopsList);
        recyclerView.setHasFixedSize(true);
      recyclerView.setAdapter(adapter);
    }
}