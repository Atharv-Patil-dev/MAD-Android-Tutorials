package com.example.alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
        @Override
        public void onBackPressed() {
            super.onBackPressed();
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage("This is Alert Dialog");
            builder.setTitle("Alert Dialog");
            builder.setIcon(R.mipmap.ic_launcher);
            


            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // finish();
                    Intent a = new Intent(Intent.ACTION_MAIN);
                    a.addCategory(Intent.CATEGORY_HOME);
                    a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(a);
                    Toast.makeText(MainActivity.this, "Exit", Toast.LENGTH_SHORT).show();
                }
            });

            builder.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                 //   startActivity(new Intent(MainActivity.this, MainActivity.class));
dialog.cancel();
                }
            });


            AlertDialog alertDialog = builder.create();
            alertDialog.setCancelable(false);
            alertDialog.show();

        }
    }
