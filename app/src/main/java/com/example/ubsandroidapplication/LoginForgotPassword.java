package com.example.ubsandroidapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class LoginForgotPassword extends AppCompatActivity {

    TextView SQTitle, SQ1, SQ2, SQ3;
    EditText SQ1Ans, SQ2Ans, SQ3Ans;
    Button ResetPassBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_forgot_password);

        SQTitle = findViewById(R.id.loginSQTitle);
        SQ1 = findViewById(R.id.loginSQ1);
        SQ2 = findViewById(R.id.loginSQ2);
        SQ3 = findViewById(R.id.loginSQ3);

        SQ1Ans = findViewById(R.id.loginSQ1Answer);
        SQ2Ans = findViewById(R.id.loginSQ2Answer);
        SQ3Ans = findViewById(R.id.loginSQ3Answer);

        ResetPassBtn = findViewById(R.id.loginResetButton);

        FirebaseAuth fAuth;
        fAuth = FirebaseAuth.getInstance();

        Intent myIntent = getIntent();
        if (myIntent.hasExtra("myExtra")){
            Toast.makeText(LoginForgotPassword.this, "User ID is: "+myIntent.getStringExtra("myExtra")+"!", Toast.LENGTH_SHORT).show();
        }


        ResetPassBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fAuth.sendPasswordResetEmail(myIntent.getStringExtra("myExtra")).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(LoginForgotPassword.this, "A Reset Password Link has been sent to your Email", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), LoginPage.class));
                            finish();
                        }
                        else{
                            Toast.makeText(LoginForgotPassword.this, "Error !"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), LoginForgotPassword.class));
                            finish();
                            }
                        }
                    });

            }
        });
    }
}