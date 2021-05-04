package com.example.ubsandroidapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ClubsFindClubs extends AppCompatActivity {

    TextView AllClubsTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clubs_find_clubs);

        AllClubsTitle = findViewById(R.id.AllClubsTitle);


    }
}