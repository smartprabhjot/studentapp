package com.example.studentapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    private EditText name;
    private EditText password;
    private Button register;
    private EditText email;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        firebaseAuth = FirebaseAuth.getInstance();
        password= (EditText) findViewById(R.id.editPassword);
        register= (Button) findViewById(R.id.registerButton);
        name= (EditText) findViewById(R.id.editName);
        email = (EditText) findViewById(R.id.editEmail);
        progressDialog = new ProgressDialog(this);



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

    private void Register() {
        String newEmail = email.getText().toString();
        String newPassword = password.getText().toString();
        String newName = name.getText().toString();
        if(TextUtils.isEmpty(newEmail)){
            email.setError("Please enter your email");
            return;
        }

        else if(TextUtils.isEmpty(newPassword)){
            password.setError("Please enter your password");
            return;
        }

        else if(TextUtils.isEmpty(newName)){
            name.setError("Please enter your Name");
            return;
        }
        else if(newPassword.length()<6){
            password.setError("Password should be more than 6 letters");
            return;
        }

        progressDialog.setMessage("Please wait..");
        progressDialog.show();
        progressDialog.setCanceledOnTouchOutside(false);
        firebaseAuth.createUserWithEmailAndPassword(newEmail,newPassword).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(RegisterActivity.this,"Registration Successful",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(RegisterActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish();

                }
                else{
                    Toast.makeText(RegisterActivity.this,"Failure!"+task.getException(),Toast.LENGTH_LONG).show();
                }
            }
        });

    }


}