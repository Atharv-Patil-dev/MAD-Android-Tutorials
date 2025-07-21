package com.example.loginsignupproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText username;
    private TextInputEditText password;
    private Button button;
    private TextView signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.name);
        password = findViewById(R.id.password);
        button = findViewById(R.id.login_button);
        signup=findViewById(R.id.signup1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               /* Intent intent=new Intent(SignIn.this,CustomerHomeActivity.class);
                startActivity(intent);*/

                        if (!username.getText().toString().isEmpty() && !password.getText().toString().isEmpty())
                        {
                            Toast.makeText(MainActivity.this, "Login Success", Toast.LENGTH_SHORT).show();

                          //  Toast.makeText(MainActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
                            Intent intent1=new Intent(MainActivity.this,DashboardActivity.class);
                            startActivity(intent1);

                        }
                        else {
                            Toast.makeText(MainActivity.this, "LoginFail", Toast.LENGTH_SHORT).show();

                        }

            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}