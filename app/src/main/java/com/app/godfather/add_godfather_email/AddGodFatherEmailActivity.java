package com.app.godfather.add_godfather_email;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.app.godfather.R;
import com.app.godfather.home.HomeFragment;

/**
 * Created by root on 21/10/16.
 */
public class AddGodFatherEmailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_godfather_email_act);


        AddGodFatherEmailFragment addGodFatherEmailFragment =
                (AddGodFatherEmailFragment) getSupportFragmentManager()
                        .findFragmentById(R.id.add_godfather_email_content_frame);

        if (addGodFatherEmailFragment == null){
            addGodFatherEmailFragment = AddGodFatherEmailFragment.newInstance();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.add_godfather_email_content_frame, addGodFatherEmailFragment).commit();
        }

    }

}
