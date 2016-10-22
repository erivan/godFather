package com.app.godfather.godsons;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.app.godfather.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by stant on 22/10/16.
 */
public class GodsonsFragment  extends Fragment implements GodsonsContract.View{

    List<String> mGodsons;

    @BindView(R.id.godsons_recycler)
    RecyclerView mVerticalRecycler;


    @BindView(R.id.godsons_toolbar)
    Toolbar mPlacesToolbar;

    private GodsonsAdapter mGodsonsAdapter;

    public static GodsonsFragment newInstance(){
        GodsonsFragment fragment = new GodsonsFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

        mGodsons = new ArrayList<String>();

        mGodsons.add(0, "erivan@gmail.com");
        mGodsons.add(1, "denis@gmail.com");
        mGodsons.add(2, "gabe@gmail.com");

        mGodsonsAdapter    = new GodsonsAdapter(getContext(), mGodsons);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.godsons_frag, container, false);
        ButterKnife.bind(this, view);
        setHasOptionsMenu(true);

        RecyclerView.LayoutManager layout = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        mVerticalRecycler.setLayoutManager(layout);
        mVerticalRecycler.setAdapter(mGodsonsAdapter);

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
    public void offerHelp(String godsonGuid) {

    }
}
