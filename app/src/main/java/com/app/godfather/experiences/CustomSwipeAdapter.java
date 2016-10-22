package com.app.godfather.experiences;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.joooonho.SelectableRoundedImageView;

import java.util.List;

import br.com.stant.stant.R;

/**
 * Created by denisvieira on 29/09/16.
 */
public class CustomSwipeAdapter extends PagerAdapter {

    private Context mContext;
    private LayoutInflater  mLayoutInflater;
    private List<String> mImageResources;

    public CustomSwipeAdapter(Context context, List<Integer> imageResources){
        this.mContext        = context;
        this.mImageResources = imageResources;
    }

    @Override
    public int getCount() {
        return mImageResources.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == (LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position){

        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view  = mLayoutInflater.inflate(R.layout.inspection_data_detail_pager_item_layout,container,false);

        SelectableRoundedImageView mainImageView = (SelectableRoundedImageView)item_view.findViewById(R.id.inspection_data_detail_main_image);
        ImageView previousImageView = (ImageView)item_view.findViewById(R.id.item_method_verified_previous_image);
        ImageView nextImageView = (ImageView)item_view.findViewById(R.id.item_method_verified_next_image);

        mainImageView.setImageResource(mImageResources.get(position));

        if(position == 0){
            previousImageView.setVisibility(View.GONE);
        }else{
            previousImageView.setImageResource(mImageResources.get(position-1));
        }


        if(position == mImageResources.size()-1){
            nextImageView.setVisibility(View.GONE);
        }else{
            nextImageView.setImageResource(mImageResources.get(position+1));
        }

        container.addView(item_view);

        return item_view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object){}
}
