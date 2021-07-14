package com.oho.oho.Fragments;

import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.DrawableRes;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textview.MaterialTextView;
import com.oho.oho.R;

import java.util.Objects;

public class FormGenderFragment extends Fragment implements View.OnClickListener{

    private TextView buttonFemaleText;
    private TextView buttonMaleText;
    private TextView buttonOtherText;

    private boolean isButtonSelectedFlag = false;
    private String  buttonSelected = "";

    public FormGenderFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_form_gender, container, false);

        MaterialCardView buttonFemale = view.findViewById(R.id.button_female);
        MaterialCardView buttonMale   = view.findViewById(R.id.button_male);
        MaterialCardView buttonOther  = view.findViewById(R.id.button_other);
        buttonFemaleText              = view.findViewById(R.id.button_female_text);
        buttonMaleText                = view.findViewById(R.id.button_male_text);
        buttonOtherText               = view.findViewById(R.id.button_other_text);

        buttonFemale.setOnClickListener(this);
        buttonMale.setOnClickListener(this);
        buttonOther.setOnClickListener(this);

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_female){
            if (buttonFemaleText.getTag().equals("unselected")) {
                if (!isButtonSelectedFlag) {
                    isButtonSelectedFlag = true;
                    buttonSelected = "female";
                    buttonFemaleText.setTag("selected");
                    buttonFemaleText.setTextColor(ResourcesCompat.getColor(requireContext().getResources(), R.color.white, requireContext().getTheme()));
                    buttonFemaleText.setBackground(ResourcesCompat.getDrawable(requireContext().getResources(), R.drawable.gradient_button, requireContext().getTheme()));
                }else
                    Toast.makeText(getContext(),"You can only select one gender",Toast.LENGTH_SHORT).show();
            }else {
                isButtonSelectedFlag = false;
                buttonSelected = "";
                buttonFemaleText.setTag("unselected");
                buttonFemaleText.setTextColor(ResourcesCompat.getColor(requireContext().getResources(),R.color.black,requireContext().getTheme()));
                buttonFemaleText.setBackground(ResourcesCompat.getDrawable(requireContext().getResources(), R.color.white, requireContext().getTheme()));
            }
        }
        if (v.getId() == R.id.button_male){
            if (buttonMaleText.getTag().equals("unselected")) {
                if (!isButtonSelectedFlag) {
                    isButtonSelectedFlag = true;
                    buttonSelected = "male";
                    buttonMaleText.setTag("selected");
                    buttonMaleText.setTextColor(ResourcesCompat.getColor(requireContext().getResources(), R.color.white, requireContext().getTheme()));
                    buttonMaleText.setBackground(ResourcesCompat.getDrawable(requireContext().getResources(), R.drawable.gradient_button, requireContext().getTheme()));
                }else
                    Toast.makeText(getContext(),"You can only select one gender",Toast.LENGTH_SHORT).show();
            }else {
                isButtonSelectedFlag = false;
                buttonSelected = "";
                buttonMaleText.setTag("unselected");
                buttonMaleText.setTextColor(ResourcesCompat.getColor(requireContext().getResources(),R.color.black,requireContext().getTheme()));
                buttonMaleText.setBackground(ResourcesCompat.getDrawable(requireContext().getResources(), R.color.white, requireContext().getTheme()));
            }
        }
        if (v.getId() == R.id.button_other){
            if (buttonOtherText.getTag().equals("unselected")) {
                if (!isButtonSelectedFlag) {
                    isButtonSelectedFlag = true;
                    buttonSelected = "other";
                    buttonOtherText.setTag("selected");
                    buttonOtherText.setTextColor(ResourcesCompat.getColor(requireContext().getResources(), R.color.white, requireContext().getTheme()));
                    buttonOtherText.setBackground(ResourcesCompat.getDrawable(requireContext().getResources(), R.drawable.gradient_button, requireContext().getTheme()));
                }else
                    Toast.makeText(getContext(),"You can only select one gender",Toast.LENGTH_SHORT).show();
            }else {
                isButtonSelectedFlag = false;
                buttonSelected = "";
                buttonOtherText.setTag("unselected");
                buttonOtherText.setTextColor(ResourcesCompat.getColor(requireContext().getResources(),R.color.black,requireContext().getTheme()));
                buttonOtherText.setBackground(ResourcesCompat.getDrawable(requireContext().getResources(), R.color.white, requireContext().getTheme()));
            }
        }
    }
}