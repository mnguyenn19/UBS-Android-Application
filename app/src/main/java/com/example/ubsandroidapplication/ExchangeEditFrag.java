package com.example.ubsandroidapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

public class ExchangeEditFrag extends Fragment {
    View view;

    private Button excSubmitBtn;
    private Button excCancelBtn;
    private Button excDeleteBtn;

    private ViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.exchange_edit_frag, container, false);

        excSubmitBtn = (Button) view.findViewById(R.id.exchangeSubmitButton);
        excCancelBtn = view.findViewById(R.id.exchangeCancelButton);
        excDeleteBtn = view.findViewById(R.id.exchangeDeleteButton);
        viewPager = (ViewPager) getActivity().findViewById(R.id.exchangePgFrag);

        excSubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(1);

                /*FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.exchangePgFrag, new ExchangeHomeFrag());
                ft.commit();*/
            }
        });

        excCancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(1);
            }
        });

        excDeleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(1);
            }
        });

        return view;
    }
}
