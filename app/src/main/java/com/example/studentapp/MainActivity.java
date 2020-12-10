package com.example.studentapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private EditText email;
    private EditText password;
    private  Button signIn;
    private Button signUp;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = (EditText) findViewById(R.id.editEmailAddress);
        password = (EditText) findViewById(R.id.editRegPassword);
        signIn = (Button) findViewById(R.id.signInButton);
        signUp = (Button) findViewById(R.id.signUpButton);
        firebaseAuth = FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(this);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(registerIntent);
            }
        });

        signIn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
               // Intent homeIntent = new Intent(MainActivity.this, HomeActivity.class);
                //startActivity(homeIntent);
                Login();
            }
        });



    }

    private void Login(){
        String newEmail = email.getText().toString();
        String newPassword = password.getText().toString();

        if(TextUtils.isEmpty(newEmail)){
            email.setError("Please enter your email");
            return;
        }

        else if(TextUtils.isEmpty(newPassword)){
            password.setError("Please enter your password");
            return;
        }


        progressDialog.setMessage("Please wait..");
        progressDialog.show();
        progressDialog.setCanceledOnTouchOutside(false);
        firebaseAuth.signInWithEmailAndPassword(newEmail,newPassword).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(MainActivity.this,"Sign in is sucessful!",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish();

                }
                else{
                    Toast.makeText(MainActivity.this,"Failure!"+task.getException(),Toast.LENGTH_LONG).show();
                }

                progressDialog.dismiss();
            }
        });

    }
}