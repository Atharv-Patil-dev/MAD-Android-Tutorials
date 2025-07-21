package com.example.loginsignupproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    private EditText fName;
    private EditText lName;
    private EditText email;
    private EditText pass;
    private String gender;
    private Button button;

    private RadioGroup group2;
    Spinner spinner;
    String [] Country ={"Select Country","India","UK","US","Pakistan"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        fName = findViewById(R.id.editfirst);
        lName = findViewById(R.id.editlast);
        email = findViewById(R.id.editemail);
        pass = findViewById(R.id.editpassword);
        group2 = findViewById(R.id.Radiogroup1);
        button = findViewById(R.id.btup);
        spinner=findViewById(R.id.spinner);

        ArrayAdapter arrayAdapter=new ArrayAdapter(RegisterActivity.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,Country);
        spinner.setAdapter(arrayAdapter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mEmail = email.getText().toString();

                String firstName = fName.getText().toString();
                String lastName = lName.getText().toString();
                String password = pass.getText().toString();
                if(firstName.isEmpty()) {
                    fName.setError("Please Enter First Name");
                    fName.requestFocus();
                    return;
                }

                if (lastName.isEmpty()) {
                    lName.setError("Please Enter Last Name");
                    lName.requestFocus();
                    return;
                }

                if(mEmail.isEmpty()) {
                    email.setError("Please Enter Email id");
                    email.requestFocus();
                    return;
                }

                if(password.isEmpty()) {
                    pass.setError("Please Enter Password");
                    pass.requestFocus();
                    return;
                }
                if(gender == null) {
                    Toast.makeText(RegisterActivity.this, "Please tell us your gender", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!mEmail.isEmpty() && !password.isEmpty()){
                    Intent intent=new Intent(RegisterActivity.this,MainActivity.class);
                    startActivity(intent);
                    Toast.makeText(RegisterActivity.this, "Registration Successfully", Toast.LENGTH_SHORT).show();
                }

            }
        });
        group2.setOnCheckedChangeListener((group, checkedId) -> {
            if(checkedId == R.id.female) {
                gender = "Male";
            } else gender = "Female";
        });
    }

}