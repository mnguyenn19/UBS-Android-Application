package com.example.ubsandroidapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class ClubsCreateClub extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner ClubUniveristySpinner;
    TextView CreateClubTitle, ClubNameTitle, ClubLeaderTitle, ClubUniversityTitle, ClubDescriptionTitle;
    EditText ClubName, ClubLeader, ClubDescription;
    Button CreateBtn, CancelBtn;

    FirebaseAuth fAuth;
    DatabaseReference rootDatabaseref;

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




        CreateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ClubUserName = ClubName.getText().toString().trim();
                String LeaderName = ClubLeader.getText().toString().trim();
                String University = ClubUniveristySpinner.getSelectedItem().toString();
                String Description = ClubDescription.getText().toString().trim();

                boolean b = false;

                if (TextUtils.isEmpty(ClubUserName)) {
                    ClubName.setError("Must enter a Club Name");
                    b = true;
                    return;
                }

                if (TextUtils.isEmpty(LeaderName)) {
                    ClubLeader.setError("Must Enter Name");
                    b = true;
                    return;
                }


                if (TextUtils.isEmpty(Description)) {
                    ClubDescription.setError("Must Enter a Club Description");
                    b = true;
                    return;
                }

                if(!b){

                    fAuth = FirebaseAuth.getInstance();
                    rootDatabaseref = FirebaseDatabase.getInstance().getReference("Database").child("User").child("Clubs");
                    Intent intent = new Intent(ClubsCreateClub.this,ClubsHomepage.class);
                    startActivity(intent);
                    finish();
                    HashMap hashMap = new HashMap();


                    hashMap.put("clubDescription", Description);
                    hashMap.put("clubLeader", LeaderName);
                    hashMap.put("clubUniversity", University);
                    hashMap.put("clubName",ClubUserName);


                    rootDatabaseref.child(fAuth.getUid()).updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener() {
                        @Override
                        public void onSuccess(Object o) {
                            Toast.makeText(ClubsCreateClub.this, "Database updated", Toast.LENGTH_SHORT).show();


                        }
                    });


                }


            }
        });

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