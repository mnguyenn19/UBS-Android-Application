package com.example.ubsandroidapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginPage extends AppCompatActivity {

    TextView UBSTitle, UserIDTitle, PasswordTitle;
    EditText Email, Password;
    Button LoginBtn, ForgotPassBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        UBSTitle = findViewById(R.id.LoginUBSTitle);
        UserIDTitle = findViewById(R.id.LoginEmailTitle);
        PasswordTitle = findViewById(R.id.LoginPassTitle);
        Email = findViewById(R.id.LoginEmail);
        Password = findViewById(R.id.LoginPassword);

        LoginBtn = findViewById(R.id.LoginButton);
        ForgotPassBtn = findViewById(R.id.LoginForgotPasswordButton);

        FirebaseAuth fAuth;
        fAuth = FirebaseAuth.getInstance();

        LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = Email.getText().toString().trim();
                String pass = Password.getText().toString().trim();

                boolean b = false;

                if(TextUtils.isEmpty(pass)){
                    Password.setError("Enter Password");
                    b = true;
                    return;
                }

                if(TextUtils.isEmpty(email)){
                    Email.setError("Enter Email");
                    b = true;
                    return;
                }

                if(!b){
                // authenticate user
                fAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(LoginPage.this, "Logged in Successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            finish();
                        }


                        else{
                            Toast.makeText(LoginPage.this, "Error !"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), LoginPage.class));
                            finish();
                        }
                    }
                });}


            }


        });

        ForgotPassBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = Email.getText().toString().trim();

                if(TextUtils.isEmpty(user)){
                    Email.setError("Need Email");
                }

            }

        });


    }
}