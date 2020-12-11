package com.example.studentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.util.Date;

public class Goal extends AppCompatActivity {
private Button button;
private Button logout;
private EditText goal;
private EditText date;
private DatabaseReference db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal);
        setTitle("Set your Goal!");

        button = (Button) findViewById(R.id.createButton);
        logout = (Button) findViewById(R.id.goalLogout);
        goal = (EditText) findViewById(R.id.goalName);
        date = (EditText) findViewById(R.id.date);
        db = FirebaseDatabase.getInstance().getReference();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.setValue(goal.getText().toString());
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(Goal.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }
}

