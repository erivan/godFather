package com.app.godfather.experiences;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.app.godfather.R;
import com.app.godfather.domain.entity.Experience;

import java.util.List;

/**
 * Created by denisvieira on 29/09/16.
 */
public class CustomSwipeAdapter extends PagerAdapter {

    private Context mContext;
    private LayoutInflater  mLayoutInflater;
    private List<Experience> mExperiences;

    public CustomSwipeAdapter(Context context, List<Experience> experiences){
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

        Experience experience = mExperiences.get(position);

        TextView experienceText = (TextView)item_view.findViewById(R.id.experience_text_view);
        TextView createdAtText  = (TextView)item_view.findViewById(R.id.created_at);

        experienceText.setText(experience.getText());
        createdAtText.setText(experience.getCreatedAt());

        container.addView(item_view);

        return item_view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object){}

    public void replaceData(List<Experience> experiences) {
        mExperiences = experiences;
        notifyDataSetChanged();
    }
}
