package com.app.godfather.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.godfather.R;

/**
 * Created by root on 21/10/16.
 */

public class HomeFragment extends Fragment {
    View view ;
    public static HomeFragment newInstance(){
        return new HomeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.home_frag, container, false);
//        ButterKnife.bind(this, view);

//        ExperienceRepository.getInstance().save(new Experience("New Experience", new Date()));
//
//        ExperienceRepository.getInstance().all(new LoadExperiencesCallback() {
//            @Override
//            public void onSuccess(List<Experience> experiences) {
//                Log.d("HERE", experiences.size() + "");
//                for(Experience experience : experiences) {
//                }
//            }
//        });

//        UserRepository.getInstance().save(new User("mail@example.com", User.GOD_FATHER));


        return view;
    }
}
