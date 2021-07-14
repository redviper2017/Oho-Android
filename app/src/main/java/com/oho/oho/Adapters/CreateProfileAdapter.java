package com.oho.oho.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.oho.oho.Fragments.FormDobFragment;
import com.oho.oho.Fragments.FormGenderFragment;
import com.oho.oho.Fragments.FormHeightFragment;
import com.oho.oho.Fragments.FormLocationFragment;
import com.oho.oho.Fragments.FormNameFragment;
import com.oho.oho.Fragments.FormOccupationFragment;
import com.oho.oho.Fragments.FormPhoneFragment;
import com.oho.oho.Fragments.FormRaceFragment;
import com.oho.oho.Fragments.FormReligionFragment;

public class CreateProfileAdapter extends FragmentPagerAdapter {

    public CreateProfileAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new FormNameFragment();
            case 1:
                return new FormPhoneFragment();
            case 2:
                return new FormGenderFragment();
            case 3:
                return new FormOccupationFragment();
            case 4:
                return new FormDobFragment();
            case 5:
                return new FormHeightFragment();
            case 6:
                return new FormReligionFragment();
            case 7:
                return new FormRaceFragment();
            case 8:
                return new FormLocationFragment();
        }
        return new Fragment();
    }

    @Override
    public int getCount() {
        return 9;
    }
}
