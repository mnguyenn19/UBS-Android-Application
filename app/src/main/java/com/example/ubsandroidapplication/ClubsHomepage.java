package com.example.ubsandroidapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ClubsHomepage extends AppCompatActivity {
    private Button CreateClubBtn;
    private Button FindClubBtn;
    TextView ClubsTitle, ViewYourClubs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clubs_hompage);

        CreateClubBtn = findViewById(R.id.CreateClubButton);
        FindClubBtn = findViewById(R.id.FindClubButton);
        ClubsTitle = findViewById(R.id.ClubsTitle);
        ViewYourClubs = findViewById(R.id.YourClubsTitle);

        CreateClubBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent createClub = new Intent(ClubsHomepage.this,ClubsCreateClub.class);
                startActivity(createClub);
                finish();
            }
        });

        FindClubBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent findClub = new Intent(ClubsHomepage.this,ClubsFindClubs.class);
                startActivity(findClub);

            }
        });
    }
}