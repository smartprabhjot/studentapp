package com.example.studentapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import java.util.jar.Attributes

class MainActivity : AppCompatActivity() {

    private EditText name;
    private EditText password;
    private Button signUp;
    private Button login;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);

        name = findViewByID(R.id.editEmailAddress);
        password = findViewByID(R.id.editPassword);
        signUp=findViewByID(R.id.signUpButton);
        signIn=findViewByID(R.id.signInButton);






    }



}