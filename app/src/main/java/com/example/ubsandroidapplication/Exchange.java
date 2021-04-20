package com.example.ubsandroidapplication;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

/*public class Exchange extends AppCompatActivity implements View.OnClickListener{

    ColorStateList attribute;
    TextView home;
    TextView createpost;
    TextView edit;
    TextView choice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exchange);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        home = findViewById(R.id.home);
        createpost = findViewById(R.id.createpost);
        edit = findViewById(R.id.edit);
        home.setOnClickListener(this);
        createpost.setOnClickListener(this);
        edit.setOnClickListener(this);
        choice = findViewById(R.id.choice);
        attribute = createpost.getTextColors();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.exchange_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int change = item.getItemId();
        if (change == R.id.activity_options)
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.home)
        {
            choice.animate().x(0).setDuration(100);
            home.setTextColor(Color.WHITE);
            createpost.setTextColor(attribute);
            edit.setTextColor(attribute);
        }
        else if (v.getId() == R.id.createpost)
        {
            home.setTextColor(attribute);
            createpost.setTextColor(Color.WHITE);
            edit.setTextColor(attribute);
            int size = createpost.getWidth();
            choice.animate().x(size).setDuration(100);
        }
        else if (v.getId() == R.id.edit)
        {
            home.setTextColor(attribute);
            createpost.setTextColor(Color.WHITE);
            edit.setTextColor(attribute);
            int size = createpost.getWidth()*2;
            choice.animate().x(size).setDuration(100);
        }
    }

}*/