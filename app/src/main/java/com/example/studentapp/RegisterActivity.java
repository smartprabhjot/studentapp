package com.example.studentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {
    EditText name;
    EditText password;
    Button register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name= (EditText) findViewById(R.id.registerName);
        password= (EditText) findViewById(R.id.editPassword);
        register= (Button) findViewById(R.id.registerButton);

        /**
         * Currently the register button takes you to the login screen, Implement the function to store the form information to the database.
         * - We will add another onclick method that will take us to the Login Screen(The MainActivity).
         */
        register.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent registerIntent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(registerIntent);
            }
        });


    }
}