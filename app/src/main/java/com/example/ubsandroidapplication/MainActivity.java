package com.example.ubsandroidapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    ///Variables
    Button moveSearch;
    Button moveExchange;
    Button moveSales;
    Button moveCommunication;
    Button moveClubs;


    //Firebase Database
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    //In each section, where the button is for you to save all the data in the database, put this there:
//    rootNode = FirebaseDatabase.getInstance();
//    reference = rootNode.getReference("Username"); // this changes based on where you want to place the data in firebase. Look in firebase.

//    Class class here.

//    reference.setValue("");

//    Have to create a class for each one too in their specific categories.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        moveSearch = findViewById(R.id.searchButton);
        moveSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Search.class);
                startActivity(intent);
                finish();
            }
        });

        moveExchange = findViewById(R.id.exchangeButton);
        moveExchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ExchangeHomeFrag.class);
                startActivity(intent);
                finish();
            }
        });

        moveClubs = findViewById(R.id.clubsButton);
        moveClubs.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(getApplicationContext(), ClubsHomepage.class);
                 startActivity(intent);
             }
        });

        moveCommunication = findViewById(R.id.commButton);
        moveCommunication.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(),CommunicationView.class);
                    startActivity(intent);
                    finish();
                }
            });
/*
        moveSales = findViewById(R.id.salesButton);
        moveSales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SalesFilename.class);
                startActivity(intent);
                finish();
            }
        });*/


    }

    public void logoutBtn(View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(),UbsStart.class));
        finish();
    }
}