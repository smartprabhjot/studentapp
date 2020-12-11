package com.example.studentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class Help extends AppCompatActivity {

    private Button homeButton;
    private Button logoutButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        setTitle("Help");
        logoutButton = (Button) findViewById(R.id.goalLogout);
        homeButton = (Button) findViewById(R.id.homeHelp);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(Help.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(Help.this,HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }


}