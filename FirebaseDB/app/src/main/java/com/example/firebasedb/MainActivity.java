package com.example.firebasedb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    EditText t1,t2,t3,t4;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void process(View view) {
        t1=(EditText) findViewById(R.id.t1);
        t2=(EditText) findViewById(R.id.t2);
        t3=(EditText) findViewById(R.id.t3);
        t4=(EditText) findViewById(R.id.t4);
        button=findViewById(R.id.button);

        String roll=t1.getText().toString().trim();
        String name=t2.getText().toString().trim();
        String cource=t3.getText().toString().trim();
        String duration=t4.getText().toString().trim();

        dataholder obj=new dataholder(name,cource,duration);

        FirebaseDatabase db=FirebaseDatabase.getInstance();
        DatabaseReference node=db.getReference("Students");

        node.child(roll).setValue(obj);
        t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText("");
        Toast.makeText(this, "Data Inserted", Toast.LENGTH_SHORT).show();



    }
}