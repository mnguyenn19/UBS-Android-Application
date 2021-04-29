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
                Intent intent = new Intent(MainActivity.this,Search.class);
                startActivity(intent);
            }
        });

        moveExchange = findViewById(R.id.exchangeButton);
        moveSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ExchangeAnnoucement.class);
                startActivity(intent);
            }
        });

        moveClubs = findViewById(R.id.clubsButton);
        moveSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ClubViewYourClubs.class);
                startActivity(intent);
            }
        });

        /*
        moveSales = findViewById(R.id.salesButton);
        moveSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SalesFilename.class);
                startActivity(intent);
            }
        });

        moveCommunication = findViewById(R.id.commButton);
        moveSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,CommFileName.class);
                startActivity(intent);
            }
        });*/

    }

    public void logoutBtn(View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(),UbsStart.class));
        finish();
    }
}