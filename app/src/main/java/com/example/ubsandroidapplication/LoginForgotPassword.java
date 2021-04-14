package com.example.ubsandroidapplication;

import android.os.Bundle;

import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginForgotPassword extends AppCompatActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_forgot_password);

        mTextView = (TextView) findViewById(R.id.text);

        // Enables Always-on
       // setAmbientEnabled();
    }
}