package com.app.godfather.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.app.godfather.R;
import com.app.godfather.add_godfather_email.AddGodFatherEmailActivity;
import com.app.godfather.add_godfather_email.AddGodFatherEmailFragment;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by root on 21/10/16.
 */
public class HomeFragment extends Fragment implements HomeContract.View {

    public static HomeFragment newInstance(){
        return new HomeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_frag, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    @OnClick(R.id.btn_go_to_addict_form)
    public void goToAddictRegisterForm() {
        Intent intent = new Intent(getContext(), AddGodFatherEmailActivity.class);
        startActivity(intent);
    }

    @Override
    @OnClick(R.id.btn_go_to_god_father_form)
    public void goToGodfatherRegisterForm() {
        Toast.makeText(getContext(), "GODFATHER", Toast.LENGTH_SHORT).show();
    }
}
