package com.app.godfather.experiences;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.joooonho.SelectableRoundedImageView;

import java.util.List;

import com.app.godfather.R;

/**
 * Created by denisvieira on 29/09/16.
 */
public class CustomSwipeAdapter extends PagerAdapter {

    private Context mContext;
    private LayoutInflater  mLayoutInflater;
    private List<String> mExperiences;

    public CustomSwipeAdapter(Context context, List<String> experiences){
        this.mContext     = context;
        this.mExperiences = experiences;
    }

    @Override
    public int getCount() {
        return mExperiences.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == (LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position){

        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view  = mLayoutInflater.inflate(R.layout.experiences_pager_item_layout,container,false);

        TextView experienceText = (TextView)item_view.findViewById(R.id.experience_text_view);

        experienceText.setText("Integer ultrices interdum sem a volutpat. Nulla iaculis lorem eget nisi ullamcorper ultricies. Morbi finibus, quam ut blandit feugiat, nulla neque dapibus elit, vitae venenatis lorem neque a diam. Praesent dictum condimentum ex ut elementum. In arcu augue, pretium eu nisl quis, mattis dignissim justo. Nunc quis dignissim orci, nec scelerisque ipsum. Nunc pharetra lacus in dui ultricies, id fermentum felis vestibulum. Mauris mauris elit, dignissim vel bibendum nec, fermentum et quam. Proin diam nisi, vehicula ac risus in, congue rutrum diam.");

        container.addView(item_view);

        return item_view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object){}
}
