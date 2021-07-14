package com.oho.oho.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.oho.oho.Adapters.SelectRaceAdapter;
import com.oho.oho.Adapters.SelectReligionAdapter;
import com.oho.oho.R;

import java.util.ArrayList;
import java.util.Arrays;

public class FormRaceFragment extends Fragment {

    public FormRaceFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_form_race, container, false);

        RecyclerView recyclerView  = view.findViewById(R.id.recyclerview);

        ArrayList<String> raceDataArrayList = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.race_array)));

        SelectRaceAdapter adapter = new SelectRaceAdapter(raceDataArrayList,getContext());
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        // Inflate the layout for this fragment
        return view;
    }
}