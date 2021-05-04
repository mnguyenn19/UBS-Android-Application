package com.example.ubsandroidapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class ExchangeAnnoucement extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exchange_annoucement);

        tabLayout = findViewById(R.id.exchangeTab);
        viewPager = findViewById(R.id.exchangePgFrag);

        tabLayout.setupWithViewPager(viewPager);
        ExchangeRVA excAdapter = new ExchangeRVA(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        //excAdapter.addFrag(new ExchangeCreateFrag(), "Create Post");
        //excAdapter.addFrag(new ExchangeHomeFrag(), "Home");
        //excAdapter.addFrag(new ExchangeEditFrag(), "Edit Post");
        viewPager.setAdapter(excAdapter);
        viewPager.setCurrentItem(1, false);

        /*
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.exchangePgFrag, new ExchangeHomeFrag());
        fragmentTransaction.commit();
        */
    }
}

/*public class ExchangeAnnoucement extends FragmentActivity {

    private ViewPager pageFragViewer;
    //private ViewPagerAdapter adapter;
    private RecyclerView adapter;
    private TabLayout pageTab;

    @Nullable
    //@Override
    public View onCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_exchange_annoucement, container, false);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exchange_annoucement);

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        //tabs.setupWithViewPager(viewPager);
        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });



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
}*/