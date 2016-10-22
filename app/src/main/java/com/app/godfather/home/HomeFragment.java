package com.app.godfather.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.godfather.R;
import com.app.godfather.addyouremail.AddYourEmailActivity;

import butterknife.OnClick;

/**
 * Created by root on 21/10/16.
 */
public class HomeFragment extends Fragment implements HomeContract.View {

    public static final String KEY_USER_TYPE = "KEY_USER";

    private boolean isAddict = false;

    public static HomeFragment newInstance(){
        return new HomeFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.home_frag, container, false);
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

//        User user = new User("god_fathermail@example.com", User.GOD_FATHER);
//        user.addSonEmail("ermailexamplecom");
//        UserRepository.getInstance().save(user);


        return view;
    }

    @Override
    @OnClick(R.id.btn_go_to_addict_form)
    public void goToAddictRegisterForm() {
        Intent intent = new Intent(getContext(), AddYourEmailActivity.class);
        isAddict = true;
        Bundle mBundle = new Bundle();
        mBundle.putBoolean(KEY_USER_TYPE, isAddict);
        intent.putExtras(mBundle);

        startActivity(intent);
    }

    @Override
    @OnClick(R.id.btn_go_to_god_father_form)
    public void goToGodfatherRegisterForm() {
        Intent intent = new Intent(getContext(), AddYourEmailActivity.class);
        isAddict = false;
        Bundle mBundle = new Bundle();
        mBundle.putBoolean(KEY_USER_TYPE, isAddict);
        intent.putExtras(mBundle);

        startActivity(intent);
   }
}
