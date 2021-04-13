package com.example.ubsandroidapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class searchAdapter extends RecyclerView.Adapter<searchAdapter.viewer> {

    ArrayList<Database> list;
    public searchAdapter(ArrayList<Database> list)
    {
        this.list = list;
    }

    @NonNull
    @Override
    public viewer onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vision = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_card_list,parent, false);
        return new viewer(vision);
    }

    @Override
    public void onBindViewHolder(@NonNull viewer holder, int position) {
        holder.searchExcTitle.setText(list.get(position).getExcTitle());
        holder.searchExcDescription.setText(list.get(position).getExcAnnouncementBox());
        holder.searchExcUniversity.setText(list.get(position).getExcUniversity());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class viewer extends RecyclerView.ViewHolder {
        TextView searchExcTitle, searchExcDescription, searchExcUniversity; // found in search_card_list.xml
        public viewer(@NonNull View itemView) {
            super(itemView);
            searchExcTitle = itemView.findViewById(R.id.excTitle);
            searchExcDescription = itemView.findViewById(R.id.excDescription);
            searchExcUniversity = itemView.findViewById(R.id.excUniversity);

            //how to implement search for other criteria like for sales or members
        }
    }
}
