package com.app.godfather.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.app.godfather.R;

import butterknife.OnClick;

/**
 * Created by root on 21/10/16.
 */
public class HomeActivity extends AppCompatActivity {

    private HomeFragment mHomeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_act);



        mHomeFragment = HomeFragment.newInstance();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.home_content_frame, mHomeFragment).commit();

        if (mHomeFragment == null){
            mHomeFragment = HomeFragment.newInstance();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.home_content_frame, mHomeFragment).commit();
        }

    }

}
