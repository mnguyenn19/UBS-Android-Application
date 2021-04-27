package com.example.ubsandroidapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.ubsandroidapplication.ui.main.SectionsPagerAdapter;

public class ExchangeAnnoucement extends AppCompatActivity {

    private ViewPager pageFragViewer;
    //private ViewPagerAdapter adapter;
    private RecyclerView adapter;
    private TabLayout pageTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exchange_annoucement);

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });




        /*
        pageFragViewer = (ViewPager) findViewById(R.id.exchangePgFrag);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        pageTab = (TabLayout) findViewById(R.id.exchangeTab);

        //Add Frag Here

        adapter.AddFragment(new ExchangeCreateFrag(),"Create Post");
        adapter.AddFragment(new ExchangeHomeFrag(),"Home");
        adapter.AddFragment(new ExchangeEditFrag(),"Edit Post");

        pageFragViewer.setAdapter(adapter);
        pageTab.setupWithViewPager(pageFragViewer);

        pageTab.getTabAt(0).setIcon(R.drawable.exchange_add_35);
        pageTab.getTabAt(1).setIcon(R.drawable.exchange_home_35);
        pageTab.getTabAt(2).setIcon(R.drawable.exchange_edit_35);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setElevation(0);*/

    }
}