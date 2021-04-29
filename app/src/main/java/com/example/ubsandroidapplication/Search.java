package com.example.ubsandroidapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
//import android.widget.Toolbar;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Search extends AppCompatActivity
{
    ArrayList<Database> directory;
    DatabaseReference firebaseReference;
    SearchView searchView;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        firebaseReference = FirebaseDatabase.getInstance().getReference().child("ubs-android-application-t11-default-rtdb").child("User").child("Exchange"); //30:00 firebaseReference = FirebaseDatabase.getInstance().getReference().child("Database").child("nameOfInnerBranchOnStruct");
        recyclerView = findViewById(R.id.searchRecyclerView);
        searchView = findViewById(R.id.searchPage);

        Toolbar toolbar = findViewById(R.id.toolbar);
        //setActionBar(toolbar);
        setSupportActionBar(toolbar);
        ImageView backArrow = findViewById(R.id.backArrow);
        ImageView settingsIcon = findViewById(R.id.settingsIcon);
        TextView appName = findViewById(R.id.appName);

        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Search.this, "Going back", Toast.LENGTH_SHORT).show();
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

    @Override
    protected void onStart()
    {
        super.onStart();
        if(firebaseReference != null)
        {
            firebaseReference.addValueEventListener(new ValueEventListener()
            {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot)
                {
                    if(snapshot.exists())
                    {
                        directory = new ArrayList<>();
                        for(DataSnapshot ds: snapshot.getChildren()) // 27:34 for(DataSnapshot ds: snapshot.getChildren())
                        {
                            directory.add(ds.getValue(Database.class));
                        }
                        //recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext())); // delete?
                        searchAdapter sa = new searchAdapter(directory);
                        recyclerView.setAdapter(sa);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error)
                {
                    Toast.makeText(Search.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });

        }
        if(searchView != null)
        {
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener()
            {
                @Override
                public boolean onQueryTextSubmit(String query)
                {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String key)
                {
                    seek(key);
                    return true;
                }
            });
        }
    }
    private void seek(String word) // searching through description of exchange announcement
    {
        ArrayList<Database> record = new ArrayList<>();
        for(Database codeWord : directory)
        {
            if(codeWord.getExcAnnouncementBox().toLowerCase().contains(word.toLowerCase()))
            {
                record.add(codeWord);
            }
        }
        searchAdapter sa = new searchAdapter(record);
        recyclerView.setAdapter(sa);
    }
}