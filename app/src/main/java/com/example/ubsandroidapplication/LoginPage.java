package com.example.ubsandroidapplication;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginPage extends AppCompatActivity {

    TextView UBSTitle, UserIDTitle, PasswordTitle;
    EditText Username, Password;
    Button LoginBtn, ForgotPassBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        UBSTitle = findViewById(R.id.LoginUBSTitle);
        UserIDTitle = findViewById(R.id.LoginUserIDTitle);
        PasswordTitle = findViewById(R.id.LoginPassTitle);
        Username = findViewById(R.id.LoginUsername);
        Password = findViewById(R.id.LoginPassword);

        LoginBtn = findViewById(R.id.LoginButton);
        ForgotPassBtn = findViewById(R.id.LoginForgotPasswordButton);

        LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = Username.getText().toString().trim();
                String pass = Password.getText().toString().trim();

                if(TextUtils.isEmpty(user)){
                    Username.setError("Enter UserID");
                }

                if(TextUtils.isEmpty(pass)){
                    Password.setError("Enter Password");
                }
            }
        });

        ForgotPassBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = Username.getText().toString().trim();

                if(TextUtils.isEmpty(user)){
                    Username.setError("Need UserID");
                }

            }

        });

    }
}