package com.oho.oho.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textview.MaterialTextView;
import com.oho.oho.R;

import java.util.ArrayList;

public class SelectRaceAdapter extends RecyclerView.Adapter<SelectRaceAdapter.RecyclerViewHolder> {

    private final ArrayList<String> raceDataArrayList;
    private Context context;

    private boolean isButtonSelectedFlag = false;
    private String  buttonSelected = "";

    public SelectRaceAdapter(ArrayList<String> raceDataArrayList, Context context){
        this.raceDataArrayList = raceDataArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_race,parent,false);
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

    public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private final MaterialTextView raceText;
        private final MaterialCardView raceButton;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            raceText   = itemView.findViewById(R.id.text_race);
            raceButton = itemView.findViewById(R.id.button_race);

            raceButton.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(v.getId() == R.id.button_race){
                if (raceText.getTag().equals("unselected")) {
                    if (!isButtonSelectedFlag) {
                        isButtonSelectedFlag = true;
                        buttonSelected = raceText.getText().toString();
                        raceText.setTag("selected");
                        raceText.setTextColor(ResourcesCompat.getColor(context.getResources(), R.color.white, context.getTheme()));
                        raceText.setBackground(ResourcesCompat.getDrawable(context.getResources(), R.drawable.gradient_button, context.getTheme()));
                    }else
                        Toast.makeText(context,"You can only select one race",Toast.LENGTH_SHORT).show();
                }else {
                    isButtonSelectedFlag = false;
                    buttonSelected = "";
                    raceText.setTag("unselected");
                    raceText.setTextColor(ResourcesCompat.getColor(context.getResources(),R.color.black,context.getTheme()));
                    raceText.setBackground(ResourcesCompat.getDrawable(context.getResources(), R.color.white, context.getTheme()));
                }
            }
        }
    }
}
