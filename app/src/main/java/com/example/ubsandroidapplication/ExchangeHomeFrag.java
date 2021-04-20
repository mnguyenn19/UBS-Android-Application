package com.example.ubsandroidapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class


ExchangeHomeFrag extends Fragment {
    View view;

    private RecyclerView rV;
    private List<Database> post;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.exchange_home_frag, container, false);
        rV = (RecyclerView) view.findViewById(R.id.home_recycler_viewer);
        RecyclerViewAdapter recyclerAdapter = new RecyclerViewAdapter(getContext(),post);
        rV.setLayoutManager(new LinearLayoutManager(getActivity()));
        rV.setAdapter(recyclerAdapter);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        post = new ArrayList<>();
        post.add(new Database("", "", "", "", "", "", "", "", "uta000", "Meeting Cancelled", "Description here", "UTA", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", '\0', "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", '\0', ""));
        //"", "", "", "", "", "", "", "", "uta123", "Meeting Cancelled", "Description here", "UTA", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", '\0', "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", '\0', ""//
        post.add(new Database("", "", "", "", "", "", "", "", "uta001", "Tesla Hiring", "Looking for CSE applicants!", "TCU", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", '\0', "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", '\0', ""));
        post.add(new Database("", "", "", "", "", "", "", "", "uta002", "Dance Practice", "Hello dancers! Remember today's meeting at 6pm in the gym!", "A&M", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", '\0', "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", '\0', ""));
        post.add(new Database("", "", "", "", "", "", "", "", "uta003", "Lost cat near Central Library", "Looking for a blue eyed, white furry cat. 10 pounds and loves fish.", "SMU", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", '\0', "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", '\0', ""));
        post.add(new Database("", "", "", "", "", "", "", "", "uta004", "Meet your advisors!", "Meet and greet session at the engineering building. 5pm!", "Rice", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", '\0', "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", '\0', ""));
        post.add(new Database("", "", "", "", "", "", "", "", "uta005", "Looking for Lab Participants", "Description here", "UTA", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", '\0', "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", '\0', ""));
        post.add(new Database("", "", "", "", "", "", "", "", "uta006", "Found a Student ID", "Description here", "UTA", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", '\0', "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", '\0', ""));
        post.add(new Database("", "", "", "", "", "", "", "", "uta007", "Lost my calculator", "Description here", "UTA", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", '\0', "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", '\0', ""));
        post.add(new Database("", "", "", "", "", "", "", "", "uta008", "Looking for a New Roomate", "Description here", "UTA", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", '\0', "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", '\0', ""));
        post.add(new Database("", "", "", "", "", "", "", "", "uta009", "Offering tutoring", "Description here", "UTA", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", '\0', "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", '\0', ""));
        post.add(new Database("", "", "", "", "", "", "", "", "uta010", "Found lost cat", "Description here", "UTA", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", '\0', "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", '\0', ""));
        post.add(new Database("", "", "", "", "", "", "", "", "uta011", "Movie night!", "Description here", "UTA", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", '\0', "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", '\0', ""));
        post.add(new Database("", "", "", "", "", "", "", "", "uta012", "Happy Spring Break", "Description here", "UTA", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", '\0', "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", '\0', ""));
    }
}
