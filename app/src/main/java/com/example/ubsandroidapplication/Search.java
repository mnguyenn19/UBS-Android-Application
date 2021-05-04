package com.example.ubsandroidapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Search extends AppCompatActivity {

    DatabaseReference firebaseReference;
    EditText searchEditText;
    RecyclerView recyclerView;
    FirebaseUser firebaseUser;

    ArrayList<String> excTitleList;
    ArrayList<String> excDescList;
    ArrayList<String> excUniList;
    searchAdapter sAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        searchEditText = (EditText) findViewById(R.id.searchPage);
        firebaseReference = FirebaseDatabase.getInstance().getReference();// ("ubs-android-application-t11-default-rtdb").child("User").child("Exchange");//.child("ubs-android-application-t11-default-rtdb").child("User").child("Exchange");
        recyclerView = (RecyclerView) findViewById(R.id.searchRecyclerView);
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        excTitleList = new ArrayList<>();
        excDescList = new ArrayList<>();
        excUniList = new ArrayList<>();

        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(!s.toString().isEmpty()) {
                    setAdapter(s.toString());
                }
                else {
                    //Clears list for a new search
                    excTitleList.clear();
                    excDescList.clear();
                    excUniList.clear();
                    recyclerView.removeAllViews();
                }
            }
        });

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ImageView backArrow = findViewById(R.id.backArrow);
        ImageView settingsIcon = findViewById(R.id.settingsIcon);
        TextView appName = findViewById(R.id.appName);

        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Search.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        settingsIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Search.this, "Menu Options", Toast.LENGTH_SHORT).show();
            }
        });
        appName.setText("UBS");
    }

    private void setAdapter(final String sstring) {
        firebaseReference.child("Database").child("User").child("Exchange").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //Clears list for a new search
                excTitleList.clear();
                excDescList.clear();
                excUniList.clear();
                recyclerView.removeAllViews();

                int tracker = 0;

                for (DataSnapshot dsnapshot: snapshot.getChildren()) {
                    String id = dsnapshot.getKey();
                    String eTitle = dsnapshot.child("excTitle").getValue(String.class);
                    String eDesc = dsnapshot.child("excAnnouncementBox").getValue(String.class);
                    String eUsername = dsnapshot.child("excUniversity").getValue(String.class);

                    if (eTitle.toLowerCase().contains(sstring.toLowerCase())) {
                        excTitleList.add(eTitle);
                        excDescList.add(eDesc);
                        excUniList.add(eUsername);
                        tracker++;
                    }
                    else if (eDesc.toLowerCase().contains(sstring.toLowerCase())) {
                        excTitleList.add(eTitle);
                        excDescList.add(eDesc);
                        excUniList.add(eUsername);
                        tracker++;
                    }
                    else if (eUsername.toLowerCase().contains(sstring.toLowerCase())) {
                        excTitleList.add(eTitle);
                        excDescList.add(eDesc);
                        excUniList.add(eUsername);
                        tracker++;
                    }
                    if (tracker == 20)
                        break;
                }

                //LinearLayoutManager manager = new LinearLayoutManager(this);
                //recyclerView.setLayoutManager(manager);
                //recyclerView.setHasFixedSize(true);
                sAdapter = new searchAdapter(Search.this, excTitleList, excDescList, excUniList);
                recyclerView.setAdapter(sAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
