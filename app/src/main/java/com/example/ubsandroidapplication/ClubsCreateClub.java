package com.example.ubsandroidapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ClubsCreateClub extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner ClubUniveristySpinner;
    TextView CreateClubTitle, ClubNameTitle, ClubLeaderTitle, ClubUniversityTitle, ClubDescriptionTitle;
    EditText ClubName, ClubLeader, ClubDescription;
    Button CreateBtn, CancelBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clubs_create_club);


        CreateClubTitle = findViewById(R.id.CreateClubTitle);
        ClubNameTitle = findViewById(R.id.ClubNameTitle);
        ClubLeaderTitle = findViewById(R.id.ClubLeaderTitle);
        ClubUniversityTitle = findViewById(R.id.ClubUniversityTitle);
        ClubDescriptionTitle = findViewById(R.id.ClubDescriptionTitle);

        ClubName = findViewById(R.id.ClubName);
        ClubLeader = findViewById(R.id.ClubLeader);
        ClubDescription = findViewById(R.id.ClubDescriptionBox);

        CreateBtn = findViewById(R.id.CreateButton);
        CancelBtn = findViewById(R.id.CancelButton);


        // Spinner
        ClubUniveristySpinner = findViewById(R.id.ClubUniversitySpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.Universities, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ClubUniveristySpinner.setAdapter(adapter);
        ClubUniveristySpinner.setOnItemSelectedListener(this);

        CancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent clubHome = new Intent(ClubsCreateClub.this,ClubsHomepage.class);
                startActivity(clubHome);
                finish();
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}