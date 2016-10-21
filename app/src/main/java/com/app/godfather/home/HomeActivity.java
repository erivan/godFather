package com.app.godfather.home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.app.godfather.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 21/10/16.
 */
public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_act);


        HomeFragment homeFragment =
                (HomeFragment) getSupportFragmentManager()
                        .findFragmentById(R.id.home_content_frame);

        if (homeFragment == null){
            homeFragment = HomeFragment.newInstance();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.home_content_frame, homeFragment).commit();
        }

    }





}
