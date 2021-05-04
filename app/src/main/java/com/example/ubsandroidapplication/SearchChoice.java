package com.example.ubsandroidapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SearchChoice extends AppCompatActivity {

    Button searchExc, searchBuy, searchOrg, searchBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_choice);

        searchExc = findViewById(R.id.searchExcBtn);
        searchExc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Search.class);
                startActivity(intent);
                finish();
            }
        });

        searchBuy = findViewById(R.id.searchSalesBtn);
        searchBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SearchSales.class);
                startActivity(intent);
                finish();
            }
        });

        searchOrg = findViewById(R.id.searchClubsBtn);
        searchOrg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SearchClubs.class);
                startActivity(intent);
                finish();
            }
        });

        searchBack = findViewById(R.id.searchBackBtn);
        searchBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}