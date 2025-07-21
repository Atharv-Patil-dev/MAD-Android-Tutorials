package com.example.signupactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignIn extends AppCompatActivity {
    private TextInputEditText username;
    private TextInputEditText password;
    private Button button;
    private TextView signup;
    FirebaseAuth firebaseAuth;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        username = findViewById(R.id.name);
        password = findViewById(R.id.password);
        firebaseAuth=FirebaseAuth.getInstance();
        button = findViewById(R.id.login_button);
        signup=findViewById(R.id.signup1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                firebaseAuth.signInWithEmailAndPassword(username.getText().toString(),password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful())
                        {
                            Toast.makeText(SignIn.this, "Login Success", Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(SignIn.this,CustomerHomeActivity.class);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(SignIn.this, "Please Check Email Or Password...", Toast.LENGTH_SHORT).show();

                        }
                    }
                });

            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SignIn.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
