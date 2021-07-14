package com.oho.oho.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;
import com.oho.oho.R;

import java.util.ArrayList;

public class SelectRaceAdapter extends RecyclerView.Adapter<SelectRaceAdapter.RecyclerViewHolder> {

    private final ArrayList<String> raceDataArrayList;
    private Context context;

    public SelectRaceAdapter(ArrayList<String> raceDataArrayList, Context context){
        this.raceDataArrayList = raceDataArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_religion,parent,false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        String religion = raceDataArrayList.get(position);
        holder.raceText.setText(religion);
    }

    @Override
    public int getItemCount() {
        return raceDataArrayList.size();
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder{
        private final MaterialTextView raceText;
        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            raceText = itemView.findViewById(R.id.text_religion);
        }
    }
}
