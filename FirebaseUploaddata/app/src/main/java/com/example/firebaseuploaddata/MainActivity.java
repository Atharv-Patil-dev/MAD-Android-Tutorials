package com.example.firebaseuploaddata;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import com.example.firebaseuploaddata.databinding.ActivityDashboardBinding;
import com.example.firebaseuploaddata.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    FirebaseDatabase firebaseDatabase;
    // DatabaseReference mRef;
    private static final int Gallary_code=1;
    Uri imageUrl= null;
    ProgressDialog progressDialog;

    FirebaseStorage mStorage;
    DatePickerDialog pickerDialog;
    ArrayList<String> sportId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        firebaseDatabase= FirebaseDatabase.getInstance();
        //  mRef=mDatabase.getReference().child("Sports");
        mStorage=FirebaseStorage.getInstance();
        FirebaseApp.initializeApp(this);
        progressDialog=new ProgressDialog(this);
        sportId = new ArrayList<>();
        sportId.add("sportId");


        binding.imgupload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent,Gallary_code);
            }
        });
        binding.eteventstartdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR);
                int mMonth = c.get(Calendar.MONTH);
                int mDay = c.get(Calendar.DAY_OF_MONTH);

                pickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        binding.eteventstartdate.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                    }
                }, mYear, mMonth, mDay);
                pickerDialog.show();
            }
        });
        binding.eteventenddate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR);
                int mMonth = c.get(Calendar.MONTH);
                int mDay = c.get(Calendar.DAY_OF_MONTH);

                pickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        binding.eteventenddate.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                    }
                }, mYear, mMonth, mDay);
                pickerDialog.show();
            }
        });


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Gallary_code && requestCode == RESULT_OK) {
            imageUrl = data.getData();
            binding.imgupload.setImageURI(imageUrl);
        }
        binding.btnuploaddata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadmodel uploadmodel1= new uploadmodel();
              uploadmodel1.setSportname(binding.etsportname.getText().toString().trim());
                uploadmodel1.setSportdetails(binding.etdetails.getText().toString().trim());
                uploadmodel1.setStartdate(binding.eteventstartdate.getText().toString().trim());
                uploadmodel1.setEnddate(binding.eteventenddate.getText().toString().trim());

              /*  final String image = imageUrl != null ? imageUrl.toString() : null;*/


                progressDialog.setTitle("uploading...");
                progressDialog.show();
                Uri uri = data.getData();
                StorageReference filepath = mStorage.getReference().child("imagePost").child(uri.getLastPathSegment());
                filepath.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        Task<Uri> downloadurl = taskSnapshot.getStorage().getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
                            @Override
                            public void onComplete(@NonNull Task<Uri> task) {

                                uploadmodel1.setImage(task.getResult().toString());
                                String id = firebaseDatabase.getReference().push().getKey();
                                uploadmodel1.setId(id.toString());
                                firebaseDatabase.getReference().child("Sport").child(id).setValue(uploadmodel1).addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        Toast.makeText(MainActivity.this, "Sport added successfully", Toast.LENGTH_SHORT).show();
                                        progressDialog.dismiss();
                                        Intent intent1 = new Intent(MainActivity.this, Dashboard.class);
                                        startActivity(intent1);
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {

                                    }
                                });






                            }
                        });
                    }
                });

            }
        });
    }
}