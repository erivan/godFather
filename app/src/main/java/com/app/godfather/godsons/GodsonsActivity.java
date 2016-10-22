package com.app.godfather.godsons;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.app.godfather.R;

/**
 * Created by stant on 22/10/16.
 */
public class GodsonsActivity extends AppCompatActivity {

    private GodsonsFragment mGodsonsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.godsons_act);

        mGodsonsFragment = GodsonsFragment.newInstance();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.godsons_content_frame, mGodsonsFragment).commit();

        if (mGodsonsFragment == null){
            mGodsonsFragment = GodsonsFragment.newInstance();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.godsons_content_frame, mGodsonsFragment).commit();
        }

    }
}