package com.example.studentapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {
  private Button logout;
  private Button goalButton;
  private Button calendarButton;
  private Button helpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Home");
        setContentView(R.layout.activity_home);
        logout = (Button) findViewById(R.id.logout);
        goalButton = (Button) findViewById(R.id.goal);
        calendarButton = (Button)findViewById(R.id.calendar);
        helpButton = (Button) findViewById(R.id.help);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(HomeActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        goalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(HomeActivity.this,Goal.class);
                startActivity(intent);
                finish();
            }
        });

        calendarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,Calendar.class);
                startActivity(intent);
                finish();
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(HomeActivity.this, Help.class);
                startActivity(intent);
                finish();
            }
        });
    }
}

