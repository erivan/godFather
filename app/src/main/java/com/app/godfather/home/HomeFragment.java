package com.app.godfather.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.godfather.R;

/**
 * Created by root on 21/10/16.
 */
public class HomeFragment extends Fragment {

    public static HomeFragment newInstance(){
        HomeFragment fragment = new HomeFragment();

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_frag, container, false);
        ButterKnife.bind(this, view);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
