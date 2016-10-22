package com.app.godfather.experiences;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.godfather.R;

import org.jetbrains.annotations.Nullable;

import butterknife.ButterKnife;

/**
 * Created by denisvieira on 21/10/16.
 */
public class ExperiencesFragment extends Fragment {

    public static ExperiencesFragment newInstance(){
        ExperiencesFragment fragment = new ExperiencesFragment();

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.experiences_frag, container, false);
        ButterKnife.bind(this, view);

        return view;
    }
}