package com.app.godfather.experiences;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.app.godfather.R;

/**
 * Created by denisvieira on 21/10/16.
 */
public class ExperiencesActivity extends AppCompatActivity {

    private ExperiencesFragment mExperiencesFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.experiences_act);



        mExperiencesFragment = ExperiencesFragment.newInstance();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.experiences_content_frame, mExperiencesFragment).commit();

        if (mExperiencesFragment == null){
            mExperiencesFragment = ExperiencesFragment.newInstance();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.experiences_content_frame, mExperiencesFragment).commit();
        }

    }
}