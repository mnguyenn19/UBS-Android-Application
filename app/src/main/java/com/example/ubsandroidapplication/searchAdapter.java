package com.example.ubsandroidapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class searchAdapter extends RecyclerView.Adapter<searchAdapter.sVH> {

    Context context;
    ArrayList<String> excTitleList;
    ArrayList<String> excDescList;
    ArrayList<String> excUniList;


    class sVH extends RecyclerView.ViewHolder {

        TextView eTitle, eDesc, eUni;
        public sVH(View itemView) {
            super(itemView);
            eTitle = (TextView) itemView.findViewById(R.id.excTitle);
            eDesc = (TextView) itemView.findViewById(R.id.excDescription);
            eUni = (TextView) itemView.findViewById(R.id.excUniversity);
        }
    }

    public searchAdapter(Context context, ArrayList<String> excTitleList, ArrayList<String> excDescList, ArrayList<String> excUniList) {
        this.context = context;
        this.excTitleList = excTitleList;
        this.excDescList = excDescList;
        this.excUniList = excUniList;
    }

    @NonNull
    @Override
    public searchAdapter.sVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.search_card_list,parent, false);
        return new searchAdapter.sVH(view);
    }

    @Override
    public void onBindViewHolder(sVH holder, int position) {
        holder.eTitle.setText(excTitleList.get(position));
        holder.eDesc.setText(excDescList.get(position));
        holder.eUni.setText(excUniList.get(position));
    }

    @Override
    public int getItemCount() {
        return excTitleList.size();
    }

    //how to implement search for other criteria like for sales or members
}
