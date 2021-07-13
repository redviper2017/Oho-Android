package com.oho.oho.Fragments;

import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.NumberPicker;
import android.widget.Toast;

import com.google.android.material.textview.MaterialTextView;
import com.oho.oho.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class FormDobFragment extends Fragment {

    public FormDobFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_form_dob, container, false);

        NumberPicker datePicker   = view.findViewById(R.id.datepicker);
        NumberPicker monthePicker = view.findViewById(R.id.monthpicker);
        NumberPicker yearPicker   = view.findViewById(R.id.yearpicker);
        MaterialTextView ageText  = view.findViewById(R.id.age_text);

        datePicker.setMaxValue(31);
        datePicker.setMinValue(1);
        datePicker.setValue(Calendar.getInstance().get(Calendar.DAY_OF_MONTH));

        yearPicker.setMaxValue(2021);
        yearPicker.setMinValue(1970);
        yearPicker.setValue(Calendar.getInstance().get(Calendar.YEAR));

        String [] monthPickerValues = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec",};

        monthePicker.setDisplayedValues(monthPickerValues);
        monthePicker.setMinValue(0);
        monthePicker.setMaxValue(11);

        String month_now = new SimpleDateFormat("MMM", Locale.getDefault()).format(Calendar.getInstance().getTime());

        for(int i =0; i<monthPickerValues.length-1; i++)
            if (monthPickerValues[i].equals(month_now))
                monthePicker.setValue(i);

        yearPicker.setOnScrollListener(new NumberPicker.OnScrollListener() {
            @Override
            public void onScrollStateChange(NumberPicker view, int scrollState) {
                if (scrollState == NumberPicker.OnScrollListener.SCROLL_STATE_IDLE){
                    int age = Calendar.getInstance().get(Calendar.YEAR) - yearPicker.getValue();
                    String age_string = age+" years";
                    ageText.setText(age_string);
                }
            }
        });

        // Inflate the layout for this fragment
        return view;
    }
}