package com.example.ubsandroidapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class excModelAdapter extends RecyclerView.Adapter<excModelAdapter.exchangeViewHolder> {

    ArrayList<excModel> eList;
    Context context;

    public excModelAdapter(Context context, ArrayList<excModel> eList) {
        this.eList = eList;
        this.context = context;
    }

    @NonNull
    @Override
    public exchangeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.exchange_home_option, parent, false);
        return new exchangeViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull exchangeViewHolder holder, int position) {
        excModel model = eList.get(position);
        holder.title.setText(model.getTitle());
        holder.description.setText(model.getDescription());
        holder.university.setText(model.getUniversity());
        holder.username.setText(model.getUsername());

    }

    @Override
    public int getItemCount() {
        return eList.size();
    }

    public static class exchangeViewHolder extends RecyclerView.ViewHolder {

        TextView title, description, username, university;
        public exchangeViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.exchangePostTitle);
            description = itemView.findViewById(R.id.exchangeDescription);
            username = itemView.findViewById(R.id.exchangeUsername);
            university = itemView.findViewById(R.id.exchangeUni);
        }
    }
}
