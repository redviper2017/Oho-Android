package com.oho.oho.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;
import android.widget.Toast;

import com.google.android.material.textview.MaterialTextView;
import com.oho.oho.R;

public class FormHeightFragment extends Fragment {

    public FormHeightFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_form_height, container, false);

        NumberPicker feetPicker = view.findViewById(R.id.feetpicker);
        NumberPicker inchPicker = view.findViewById(R.id.inchpicker);
        MaterialTextView feet   = view.findViewById(R.id.text_feet);
        MaterialTextView inch   = view.findViewById(R.id.text_inch);

        String [] feetPickerValues = new String[] {"1 ft","2 ft","3 ft","4 ft","5 ft","6 ft","7 ft"};

        feetPicker.setMaxValue(6);
        feetPicker.setMinValue(0);
        feetPicker.setValue(5);
        feetPicker.setDisplayedValues(feetPickerValues);

        String [] inchPickerValues = new String[] {"1 inch","2 inch","3 inch","4 inch","5 inch","6 inch","7 inch","8 inch","9 inch","10 inch","11 inch",};

        inchPicker.setMaxValue(6);
        inchPicker.setMinValue(0);
        inchPicker.setValue(5);
        inchPicker.setDisplayedValues(inchPickerValues);

        feetPicker.setWrapSelectorWheel(true);
//        feetPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
//            @Override
//            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
//                int feetSelected = newVal+1;
//                Toast.makeText(getContext(),"feet = "+feetSelected,Toast.LENGTH_SHORT).show();
//            }
//        });

        feetPicker.setOnScrollListener(new NumberPicker.OnScrollListener() {
            @Override
            public void onScrollStateChange(NumberPicker view, int scrollState) {
                if (scrollState == NumberPicker.OnScrollListener.SCROLL_STATE_IDLE) {
                    int feetSelected = feetPicker.getValue()+1;
                    Toast.makeText(getContext(),"feet = "+feetSelected,Toast.LENGTH_SHORT).show();
                    String feetSelectedText = String.valueOf(feetSelected)+" \'";
                    feet.setText(feetSelectedText);
                }
            }
        });

        inchPicker.setWrapSelectorWheel(true);
//        inchPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
//            @Override
//            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
//                int inchSelected = newVal+1;6
//                Toast.makeText(getContext(),"inch = "+inchSelected,Toast.LENGTH_SHORT).show();
//            }
//        });

        inchPicker.setOnScrollListener(new NumberPicker.OnScrollListener() {
            @Override
            public void onScrollStateChange(NumberPicker view, int scrollState) {
                if (scrollState == NumberPicker.OnScrollListener.SCROLL_STATE_IDLE) {
                    int inchSelected = inchPicker.getValue()+1;
                    Toast.makeText(getContext(),"inch = "+inchSelected,Toast.LENGTH_SHORT).show();
                    String inchSelectedText = String.valueOf(inchSelected)+" \"";
                    inch.setText(inchSelectedText);
                }
            }
        });

        // Inflate the layout for this fragment
        return view;
    }
}