package com.app.godfather.addyouremail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.app.godfather.R;
import com.app.godfather.home.HomeFragment;

/**
 * Created by root on 21/10/16.
 */
public class AddYourEmailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_your_email_act);

        final boolean isAddict = getIntent().getExtras().getBoolean(HomeFragment.KEY_USER_TYPE);

        AddYourEmailFragment addGodFatherEmailFragment =
                (AddYourEmailFragment) getSupportFragmentManager()
                        .findFragmentById(R.id.add_your_email_content_frame);

        if (addGodFatherEmailFragment == null){
            addGodFatherEmailFragment = AddYourEmailFragment.newInstance(isAddict);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.add_your_email_content_frame, addGodFatherEmailFragment).commit();
        }

    }
}
