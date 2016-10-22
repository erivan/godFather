package com.app.godfather.addyourexperience;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.app.godfather.R;
import com.app.godfather.addyouremail.AddYourEmailContract;
import com.app.godfather.domain.entity.Experience;
import com.app.godfather.infrastructure.ExperienceRepository;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by root on 22/10/16.
 */
public class AddYourExperienceFragment extends Fragment implements AddYourEmailContract.View{

    @BindView(R.id.experience_text)
    EditText mExperienceText;

    public static AddYourExperienceFragment newInstance(){
        AddYourExperienceFragment fragment = new AddYourExperienceFragment();

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_your_experience_frag, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    @OnClick(R.id.enviar_experiencia)
    public void saveExperience() {
        ExperienceRepository.getInstance().save(new Experience(mExperienceText.getText().toString()));
        getActivity().finish();
    }
}
