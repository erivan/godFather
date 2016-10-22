package com.app.godfather.addyourexperience;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.app.godfather.R;

/**
 * Created by root on 22/10/16.
 */
public class AddYourExperienceActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_your_experience_act);

        AddYourExperienceFragment addYourExperienceFragment =
                (AddYourExperienceFragment) getSupportFragmentManager()
                        .findFragmentById(R.id.add_your_experience_content_frame);

        if (addYourExperienceFragment == null){
            addYourExperienceFragment = AddYourExperienceFragment.newInstance();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.add_your_experience_content_frame, addYourExperienceFragment).commit();
        }

    }
}
