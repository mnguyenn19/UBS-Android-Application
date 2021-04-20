package com.example.ubsandroidapplication;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ExchangeAdapter extends FragmentPagerAdapter {

    private final List<Fragment> firstFrag = new ArrayList<>();
    private final List<String> firstName = new ArrayList<>();

    public ExchangeAdapter(@NonNull FragmentManager fm) {
        super(fm); //Can remove behavior
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return firstFrag.get(position);
    }

    @Override
    public int getCount() {
        return firstName.size();
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return firstName.get(position);
    }

    public void AdditionFrag (Fragment fragment, String name) {
        firstName.add(name);
        firstFrag.add(fragment);
    }
}
