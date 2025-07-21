package com.example.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("Activity LifeCycle","onCreate() invoked");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Activity Lifecycle","OnStart");
    }
    /*    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "OnStart", Toast.LENGTH_SHORT).show();
        Log.i("Activity Lifecycle","onStart() invoked");
    }*/

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Activity Lifecycle","onResume() invoked");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Activity Lifecycle","onPause() invoked");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Activity Lifecycle","onStop() invoked");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Activity Lifecycle","onRestart() invoked");
    }

/*    @Override
    protected void onDestroy() {

        super.onDestroy();
        Log.i("Activity Lifecycle", "onDestroy() invoked");
    }*/

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
        Log.i("ActivityLifecycle","OnDestroy");
    }

   /*    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Activity Lidecycle","onDestroy");
    }*/
}