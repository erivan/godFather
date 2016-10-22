package com.app.godfather.experiences;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.app.godfather.R;

/**
 * Created by denisvieira on 21/10/16.
 */
public class ExperiencesActivity  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.experiences_act);


        ExperiencesFragment experiencesFragment =
                (ExperiencesFragment) getSupportFragmentManager()
                        .findFragmentById(R.id.experiences_content_frame);

        if (experiencesFragment == null){
            experiencesFragment = ExperiencesFragment.newInstance();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.experiences_content_frame, experiencesFragment).commit();
        }

    }

}