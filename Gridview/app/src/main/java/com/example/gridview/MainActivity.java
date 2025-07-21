package com.example.gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    GridAdapter gridAdapter;

    String[] countryName = {"India","US","Ukraine","Yemen","Uzabekistan"};
    int[] images = {R.drawable.ganpati,R.drawable.us,R.drawable.ukraine,R.drawable.uzabekistan,R.drawable.uzabekistan};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = findViewById(R.id.gridView);
        gridAdapter = new GridAdapter(MainActivity.this, countryName,images);
        gridView.setAdapter(gridAdapter);

       /* gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    // Action for item at position 0
                    Toast.makeText(MainActivity.this, "Clicked item 0", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(intent);
                } else {}
            }
        });*/
    }

}