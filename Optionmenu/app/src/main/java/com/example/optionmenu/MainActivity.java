package com.example.optionmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Toolbar toolbar;
ConstraintLayout constraint;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.toolbar);
         setSupportActionBar(toolbar);
        constraint=findViewById(R.id.constraint);

    }

    @SuppressLint("RestrictedApi")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);

        if(menu instanceof MenuBuilder){
            MenuBuilder m = (MenuBuilder) menu;
            m.setOptionalIconsVisible(true);
        }
        return true;
    }



@Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int ID = item.getItemId();
        if (ID == R.id.first) {
          //  constraint.setBackgroundColor(Color.RED);
            Intent intent=new Intent(MainActivity.this,MainActivity2.class);
            startActivity(intent);
            Toast.makeText(this, "ONE", Toast.LENGTH_SHORT).show();
        } else if (ID == R.id.second) {
            constraint.setBackgroundColor(Color.GREEN);
            Toast.makeText(this, "TWO", Toast.LENGTH_SHORT).show();
        } else if (ID == R.id.third) {
            constraint.setBackgroundColor(Color.YELLOW);
            Toast.makeText(this, "THREE", Toast.LENGTH_SHORT).show();
        } else if (ID == R.id.fourth) {
            constraint.setBackgroundColor(Color.BLUE);
            Toast.makeText(this, "FOUR", Toast.LENGTH_SHORT).show();
        }

        return true;
    }
}