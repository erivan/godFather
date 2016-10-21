package com.app.godfather.add_godfather_email;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.godfather.R;

import butterknife.ButterKnife;

/**
 * Created by root on 21/10/16.
 */
public class AddGodFatherEmailFragment extends Fragment {

    public static AddGodFatherEmailFragment newInstance(){
        AddGodFatherEmailFragment fragment = new AddGodFatherEmailFragment();

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_godfather_email_frag, container, false);
        ButterKnife.bind(this, view);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
