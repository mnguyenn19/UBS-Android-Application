package com.example.ubsandroidapplication;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class UbsStart extends AppCompatActivity {
    private Button StartLoginBtn;
    private Button StartRegisterBtn;
    TextView StartUBSTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubs_start);

        StartLoginBtn =findViewById(R.id.StartLoginButton);
        StartRegisterBtn = findViewById(R.id.StartRegisterButton);
        StartUBSTitle = findViewById(R.id.StartUBSTitle);

        StartLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login = new Intent(UbsStart.this,LoginPage.class);
                startActivity(login);
            }
        });

        StartRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent register= new Intent(UbsStart.this,RegistrationPage.class);
                startActivity(register);
            }
        });
    }



}