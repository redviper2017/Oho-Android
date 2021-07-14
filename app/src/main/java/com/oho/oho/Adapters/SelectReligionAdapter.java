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

public class SelectReligionAdapter extends RecyclerView.Adapter<SelectReligionAdapter.RecyclerViewHolder> {

    private final ArrayList<String> religionDataArrayList;
    private Context context;

    private boolean isButtonSelectedFlag = false;
    private String  buttonSelected = "";

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

    public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private final MaterialTextView religionText;
        private final MaterialCardView religionButton;
        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            religionText   = itemView.findViewById(R.id.text_religion);
            religionButton = itemView.findViewById(R.id.button_religion);

            religionButton.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(v.getId() == R.id.button_religion){
                if (religionText.getTag().equals("unselected")) {
                    if (!isButtonSelectedFlag) {
                        isButtonSelectedFlag = true;
                        buttonSelected = religionText.getText().toString();
                        religionText.setTag("selected");
                        religionText.setTextColor(ResourcesCompat.getColor(context.getResources(), R.color.white, context.getTheme()));
                        religionText.setBackground(ResourcesCompat.getDrawable(context.getResources(), R.drawable.gradient_button, context.getTheme()));
                    }else
                        Toast.makeText(context,"You can only select one religion",Toast.LENGTH_SHORT).show();
                }else {
                    isButtonSelectedFlag = false;
                    buttonSelected = "";
                    religionText.setTag("unselected");
                    religionText.setTextColor(ResourcesCompat.getColor(context.getResources(),R.color.black,context.getTheme()));
                    religionText.setBackground(ResourcesCompat.getDrawable(context.getResources(), R.color.white, context.getTheme()));
                }
            }
        }
    }
}
