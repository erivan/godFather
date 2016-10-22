package com.app.godfather.addyourexperience;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.godfather.R;

import butterknife.ButterKnife;

/**
 * Created by root on 22/10/16.
 */
public class AddYourExperienceFragment extends Fragment {

    public static AddYourExperienceFragment newInstance(){
        AddYourExperienceFragment fragment = new AddYourExperienceFragment();

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_your_experience_frag, container, false);
        ButterKnife.bind(this, view);


        return view;
    }
}
