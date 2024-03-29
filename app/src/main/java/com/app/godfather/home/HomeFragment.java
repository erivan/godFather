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
import com.app.godfather.domain.entity.User;
import com.app.godfather.experiences.ExperiencesActivity;
import com.app.godfather.godsons.GodsonsActivity;
import com.app.godfather.infrastructure.UserRepository;
import com.app.godfather.infrastructure.UserRepository.LoadUserCallback;
import com.app.godfather.infrastructure.UserSession;

import butterknife.ButterKnife;
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
        ButterKnife.bind(this, view);

        UserSession userSession = new UserSession(getContext());
        if (userSession.getSessionEmail() != null) {
            UserRepository.getInstance().findByEmail(userSession.getSessionEmail(), new LoadUserCallback() {
                @Override
                public void onSuccess(User user) {
                    if (user.getType() == User.GOD_FATHER) {
                        Intent i = new Intent(getContext(), GodsonsActivity.class);
                        startActivity(i);
                    }
                    if (user.getType() == User.CHEMICAL_DEPENDENT) {
                        Intent i = new Intent(getContext(), ExperiencesActivity.class);
                        startActivity(i);
                    }
                }
            });

        }


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
