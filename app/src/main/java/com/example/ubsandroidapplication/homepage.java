package com.example.ubsandroidapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Toolbar;

public class homepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        Toolbar hp_toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(hp_toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(homepage menu) {
        getMenuInflater().inflate(R.menu.homepage_tb_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemSelected = item.getItemId();

        if (itemSelected == R.id.account)
        {
            Toast.makeText(getApplicationContext(), "Account Information", Toast.LENGTH_SHORT).show();
        }
        else if(itemSelected == R.id.language)
        {
            Toast.makeText(getApplicationContext(), "Change Primary Language", Toast.LENGTH_SHORT).show();
        }
        else if(itemSelected == R.id.terms_of_use)
        {
            Toast.makeText(getApplicationContext(), "UBS is not responsible for any third party applications that you are linked to.", Toast.LENGTH_SHORT).show();
        }
        else if(itemSelected == R.id.help)
        {
            Toast.makeText(getApplicationContext(), "More information", Toast.LENGTH_SHORT).show();
        }
        else if(itemSelected == R.id.logout)
        {
            Toast.makeText(getApplicationContext(), "Goodbye!", Toast.LENGTH_SHORT).show();
        }
        return true;

    }
}