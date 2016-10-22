package com.app.godfather.experiences;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.app.godfather.R;

import android.support.annotation.Nullable;
import android.widget.Toast;

import com.app.godfather.addyourexperience.AddYourExperienceActivity;
import com.app.godfather.domain.entity.Experience;
import com.app.godfather.infrastructure.ExperienceRepository;
import com.app.godfather.infrastructure.ExperienceRepository.LoadExperiencesCallback;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by denisvieira on 21/10/16.
 */
public class ExperiencesFragment extends Fragment implements ExperiencesContract.View{

    @BindView(R.id.experiences_view_pager)
    ViewPager mViewPager;

    private CustomSwipeAdapter mCustomSwipeAdapter;

    public static ExperiencesFragment newInstance(){
        ExperiencesFragment fragment = new ExperiencesFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        mCustomSwipeAdapter = new CustomSwipeAdapter(getContext(), new ArrayList<Experience>());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,    @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.experiences_frag, container, false);
        ButterKnife.bind(this, view);
        setHasOptionsMenu(true);

        mViewPager.setAdapter(mCustomSwipeAdapter);
        ExperienceRepository.getInstance().all(new LoadExperiencesCallback() {
            @Override
            public void onSuccess(List<Experience> experiences) {
                mCustomSwipeAdapter.replaceData(experiences);
            }
        });
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, final MenuInflater inflater) {
        getActivity().getMenuInflater().inflate(R.menu.logout_menu, menu);

        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_get_out:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void callHelp() {
        Context context = mViewPager.getContext();
        CharSequence text = "Ajuda a caminho!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

    }

    @Override
    public void shareExperience() {}

    @OnClick(R.id.push_button)
    public void goToAddYourExperience() {
        Intent intent = new Intent(getContext(), AddYourExperienceActivity.class);
        startActivity(intent);
    }
}