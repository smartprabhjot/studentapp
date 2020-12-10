package com.example.studentapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    private EditText name;
    private EditText password;
    private Button register;
    private EditText email;
    private FirebaseAuth firebaseAuth;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        firebaseAuth = FirebaseAuth.getInstance();
        password= (EditText) findViewById(R.id.editPassword);
        register= (Button) findViewById(R.id.registerButton);
        name= (EditText) findViewById(R.id.editName);
        email = (EditText) findViewById(R.id.editEmail);



        /**
         * Currently the register button takes you to the login screen, Implement the function to store the form information to the database.
         * - We will add another onclick method that will take us to the Login Screen(The MainActivity).
         */
        register.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
            Register();



            }

        });


    }




}