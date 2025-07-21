package com.example.firebaseuploaddata;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.firebaseuploaddata.Adapter.sportadapter;
import com.example.firebaseuploaddata.databinding.ActivityDashboardBinding;
import com.example.firebaseuploaddata.databinding.ActivityMainBinding;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;

import java.util.ArrayList;
import java.util.List;

public class Dashboard extends AppCompatActivity {

    FirebaseDatabase mDatabase;
    FirebaseStorage mStorage;
    DatabaseReference mRef;
    RecyclerView recyclerView;
    sportadapter adapter;
    List<uploadmodel> sportList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        sportList=new ArrayList<uploadmodel>();
        mDatabase=FirebaseDatabase.getInstance();
        mRef=mDatabase.getReference().child("Sport");
        mStorage=FirebaseStorage.getInstance();
        recyclerView=findViewById(R.id.recyclerView);

        initComponents();
        mRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                uploadmodel uploadmodel1= snapshot.getValue(uploadmodel.class);
                sportList.add(uploadmodel1);
               adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    private void initComponents() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new sportadapter(Dashboard.this,sportList);
        recyclerView.setAdapter(adapter);
        recyclerView.smoothScrollToPosition(0);

    }
    }