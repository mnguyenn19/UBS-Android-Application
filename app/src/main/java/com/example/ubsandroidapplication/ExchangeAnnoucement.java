package com.example.ubsandroidapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class ExchangeAnnoucement extends AppCompatActivity {

    private ViewPager pageFragViewer;
    //private ViewPagerAdapter adapter;
    private RecyclerView adapter;
    private TabLayout pageTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exchange_annoucement);

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
        actionBar.setElevation(0);

    }
}