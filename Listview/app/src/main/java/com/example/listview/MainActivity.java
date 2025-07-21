package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayAdapter arrayAdapter;
    String[] Days = {"Sunday" ,"Monday", "Tuesday", "Wednesday", "Thusday", "Friday", "Saturday"};
   SearchView searchView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listview);
        searchView=findViewById(R.id.searchView);
        arrayAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, Days);
        listView.setAdapter(arrayAdapter);
listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(MainActivity.this, ""+Days[position], Toast.LENGTH_SHORT).show();
  if(position==0){
      Intent intent=new Intent(MainActivity.this,MainActivity2.class);
      startActivity(intent);
  } else if (position==1) {
      Intent intent=new Intent(MainActivity.this,MainActivity2.class);
      startActivity(intent);
  } else if (position%2==0){
      view.setBackgroundResource(R.drawable.back);

  } else if (position%2==1) {
     view.setBackgroundColor((getResources().getColor(R.color.black)));
  }
    }
});
searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        arrayAdapter.getFilter().filter(newText);
        return false;
    }
});



    }}
