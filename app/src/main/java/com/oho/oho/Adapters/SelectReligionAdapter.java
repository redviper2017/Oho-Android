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

public class SelectReligionAdapter extends RecyclerView.Adapter<SelectReligionAdapter.RecyclerViewHolder> {

    private final ArrayList<String> religionDataArrayList;
    private Context context;

    public SelectReligionAdapter(ArrayList<String> religionDataArrayList, Context context){
        this.religionDataArrayList = religionDataArrayList;
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
        String religion = religionDataArrayList.get(position);
        holder.religionText.setText(religion);
    }

    @Override
    public int getItemCount() {
        return religionDataArrayList.size();
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder{
        private final MaterialTextView religionText;
        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            religionText = itemView.findViewById(R.id.text_religion);
        }
    }
}
