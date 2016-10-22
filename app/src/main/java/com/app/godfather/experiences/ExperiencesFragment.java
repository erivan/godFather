package com.app.godfather.experiences;

import android.os.Bundle;
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
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by denisvieira on 21/10/16.
 */
public class ExperiencesFragment extends Fragment {

    @BindView(R.id.experiences_view_pager)
    ViewPager mViewPager;

    List<String> mExperiences;

    private CustomSwipeAdapter mCustomSwipeAdapter;

    public static ExperiencesFragment newInstance(){
        ExperiencesFragment fragment = new ExperiencesFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

        mExperiences = new ArrayList<String>();

        mExperiences.add(0,"Nam commodo tempus vestibulum. Sed ornare nullaNam commodo tempus vestibulum. Sed ornare nulla ornare pharetra pharetra. Proin a maximus est, ut pharNam commodo tempus vestibulum. Sed ornare nulla ornare pharetra pharetra. Proin a maximus est, ut phar ornare pharetra pharetra. Proin a maximus est, ut pharetra felis. Ut facilisis auctor facilisis. Aenean sed urna nec ex pharetra commodo non a tellus. Nullam ante sem, venenatis facilisis bibendum ac, convallis at est. Fusce eu turpis imperdiet, ornare lectus in, dictum diam. Nullam nec nibh malesuada, vehicula metus ut,ommodo tempus vestibulum. Sed ornare nullaNam commodo tempus vestibulum. Sed ornare nulla ornare pharetra pharetra. Proin a maximus est, ut pharNam commodo tempus vestibulum. Sed ornare nulla ornare pharetra pharetra. Proin a maximus est, ut phar ornare pharetra pharetra. Proin a maximus est, ut pharetra felis. Ut facilisis auctor facilisis. Aenean sed urna nec ex pharetra commodo non a tellus. Nullam ante sem, venenatis facilisis bibendum ac, convallis at est. Fusce eu turpis imperdiet, ornare lectus in, dictum diam. Nullam nec nibh malesuada, vehicula metus utommodo tempus vestibulum. Sed ornare nullaNam commodo tempus vestibulum. Sed ornare nulla ornare pharetra pharetra. Proin a maximus est, ut pharNam commodo tempus vestibulum. Sed ornare nulla ornare pharetra pharetra. Proin a maximus est, ut phar ornare pharetra pharetra. Proin a maximus est, ut pharetra felis. Ut facilisis auctor facilisis. Aenean sed urna nec ex pharetra commodo non a tellus. Nullam ante sem, venenatis facilisis bibendum ac, convallis at est. Fusce eu turpis imperdiet, ornare lectus in, dictum diam. Nullam nec nibh malesuada, vehicula metus ut interdum purus. Nulla porta maximus enim. Nam faucibus dui sit amet eros porta mattis. Aenean ut sagittis nisi. Aliquam mi risus, volutpat eget maximus sit amet, vestibulum ut magna. Quisque a lacus arcu.");
        mExperiences.add(1,"Cras sit ametommodo tempus vestibulum. Sed ornare nullaNam commodo tempus vestibulum. Sed ornare nulla ornare pharetra pharetra. Proin a maximus est, ut pharNam commodo tempus vestibulum. Sed ornare nulla ornare pharetra pharetra. Proin a maximus est, ut phar ornare pharetra pharetra. Proin a maximus est, ut pharetra felis. Ut facilisis auctor facilisis. Aenean sed urna nec ex pharetra commodo non a tellus. Nullam ante sem, venenatis facilisis bibendum ac, convallis at est. Fusce eu turpis imperdiet, ornare lectus in, dictum diam. Nullam nec nibh malesuada, vehicula metus utommodo tempus vestibulum. Sed ornare nullaNam commodo tempus vestibulum. Sed ornare nulla ornare pharetra pharetra. Proin a maximus est, ut pharNam commodo tempus vestibulum. Sed ornare nulla ornare pharetra pharetra. Proin a maximus est, ut phar ornare pharetra pharetra. Proin a maximus est, ut pharetra felis. Ut facilisis auctor facilisis. Aenean sed urna nec ex pharetra commodo non a tellus. Nullam ante sem, venenatis facilisis bibendum ac, convallis at est. Fusce eu turpis imperdiet, ornare lectus in, dictum diam. Nullam nec nibh malesuada, vehicula metus utommodo tempus vestibulum. Sed ornare nullaNam commodo tempus vestibulum. Sed ornare nulla ornare pharetra pharetra. Proin a maximus est, ut pharNam commodo tempus vestibulum. Sed ornare nulla ornare pharetra pharetra. Proin a maximus est, ut phar ornare pharetra pharetra. Proin a maximus est, ut pharetra felis. Ut facilisis auctor facilisis. Aenean sed urna nec ex pharetra commodo non a tellus. Nullam ante sem, venenatis facilisis bibendum ac, convallis at est. Fusce eu turpis imperdiet, ornare lectus in, dictum diam. Nullam nec nibh malesuada, vehicula metus utommodo tempus vestibulum. Sed ornare nullaNam commodo tempus vestibulum. Sed ornare nulla ornare pharetra pharetra. Proin a maximus est, ut pharNam commodo tempus vestibulum. Sed ornare nulla ornare pharetra pharetra. Proin a maximus est, ut phar ornare pharetra pharetra. Proin a maximus est, ut pharetra felis. Ut facilisis auctor facilisis. Aenean sed urna nec ex pharetra commodo non a tellus. Nullam ante sem, venenatis facilisis bibendum ac, convallis at est. Fusce eu turpis imperdiet, ornare lectus in, dictum diam. Nullam nec nibh malesuada, vehicula metus ut dolor id velit tincidunt coNam commodo tempus vestibulum. Sed ornare nulla ornare pharetra pharetra. Proin a maximus est, ut pharNam commodo tempus vestibulum. Sed ornare nulla ornare pharetra pharetra. Proin a maximus est, ut pharNam commodo tempus vestibulum. Sed ornare nulla ornare pharetra pharetra. Proin a maximus est, ut pharnsequat. Donec mi dolor, accumsan vel felis id, placerat porttitor ipsum. Ut nisi arcu, pulvinar id mollis et, porttitor eu libero. Etiam vestibulum tempor nulla et porta. ");
        mExperiences.add(2," Donec dignissim purus eNam commodo tempus vestommodo tempus vestibulum. Sed ornare nullaNam commodo tempus vestibulum. Sed ornare nulla ornare pharetra pharetra. Proin a maximus est, ut pharNam commodo tempus vestibulum. Sed ornare nulla ornare pharetra pharetra. Proin a maximus est, ut phar ornare pharetra pharetra. Proin a maximus est, ut pharetra felis. Ut facilisis auctor facilisis. Aenean sed urna nec ex pharetra commodo non a tellus. Nullam ante sem, venenatis facilisis bibendum ac, convallis at est. Fusce eu turpis imperdiet, ornare lectus in, dictum diam. Nullam nec nibh malesuada, vehicula metus utommodo tempus vestibulum. Sed ornare nullaNam commodo tempus vestibulum. Sed ornare nulla ornare pharetra pharetra. Proin a maximus est, ut pharNam commodo tempus vestibulum. Sed ornare nulla ornare pharetra pharetra. Proin a maximus est, ut phar ornare pharetra pharetra. Proin a maximus est, ut pharetra felis. Ut facilisis auctor facilisis. Aenean sed urna nec ex pharetra commodo non a tellus. Nullam ante sem, venenatis facilisis bibendum ac, convallis at est. Fusce eu turpis imperdiet, ornare lectus in, dictum diam. Nullam nec nibh malesuada, vehicula metus utommodo tempus vestibulum. Sed ornare nullaNam commodo tempus vestibulum. Sed ornare nulla ornare pharetra pharetra. Proin a maximus est, ut pharNam commodo tempus vestibulum. Sed ornare nulla ornare pharetra pharetra. Proin a maximus est, ut phar ornare pharetra pharetra. Proin a maximus est, ut pharetra felis. Ut facilisis auctor facilisis. Aenean sed urna nec ex pharetra commodo non a tellus. Nullam ante sem, venenatis facilisis bibendum ac, convallis at est. Fusce eu turpis imperdiet, ornare lectus in, dictum diam. Nullam nec nibh malesuada, vehicula metus utommodo tempus vestibulum. Sed ornare nullaNam commodo tempus vestibulum. Sed ornare nulla ornare pharetra pharetra. Proin a maximus est, ut pharNam commodo tempus vestibulum. Sed ornare nulla ornare pharetra pharetra. Proin a maximus est, ut phar ornare pharetra pharetra. Proin a maximus est, ut pharetra felis. Ut facilisis auctor facilisis. Aenean sed urna nec ex pharetra commodo non a tellus. Nullam ante sem, venenatis facilisis bibendum ac, convallis at est. Fusce eu turpis imperdiet, ornare lectus in, dictum diam. Nullam nec nibh malesuada, vehicula metus utibulum. Sed ornare nulla ornare pharetra pharetra. Proin a maximus est, ut pharNam commodo tempus vestibulum. Sed ornare nulla ornare pharetra pharetra. Proin a maximus est, ut pharNam commodo tempus vestibulum. Sed ornare nulla ornare pharetra pharetra. Proin a maximus est, ut phart congue condimentum. In hac habitasse platea dictumst. Nunc magna tortor, sagittis vel aliquet nec, aliquam vitae nisl.");

        mCustomSwipeAdapter = new CustomSwipeAdapter(getContext(),mExperiences);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,    @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.experiences_frag, container, false);
        ButterKnife.bind(this, view);
        setHasOptionsMenu(true);

        mViewPager.setAdapter(mCustomSwipeAdapter);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, final MenuInflater inflater) {
        getActivity().getMenuInflater().inflate(R.menu.get_out, menu);

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
}