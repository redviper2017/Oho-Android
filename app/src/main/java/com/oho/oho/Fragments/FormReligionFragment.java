package com.oho.oho.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.oho.oho.Adapters.SelectReligionAdapter;
import com.oho.oho.R;

import java.util.ArrayList;
import java.util.Arrays;

public class FormReligionFragment extends Fragment {

    public FormReligionFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_form_religion, container, false);

        RecyclerView recyclerView  = view.findViewById(R.id.recyclerview);

        ArrayList<String> religionDataArrayList = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.religion_array)));

        SelectReligionAdapter adapter = new SelectReligionAdapter(religionDataArrayList,getContext());
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        // Inflate the layout for this fragment
        return view;
    }
}