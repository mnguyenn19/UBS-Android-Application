package com.example.ubsandroidapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.SearchView;
import android.widget.Toast;

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