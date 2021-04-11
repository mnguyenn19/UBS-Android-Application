package com.example.ubsandroidapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    ///Variables

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
    }
}