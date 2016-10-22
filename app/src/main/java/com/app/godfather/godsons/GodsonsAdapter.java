package com.app.godfather.godsons;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.app.godfather.R;

import java.util.List;

/**
 * Created by stant on 22/10/16.
 */
public class GodsonsAdapter extends RecyclerView.Adapter<GodsonsAdapter.ViewHolder> {

    private List<String> mGodsons;
    private Context mContext;
    private ViewHolder mViewHolder;

    public GodsonsAdapter(Context context, List<String> godsons) {
        mGodsons = godsons;
        mContext = context;
    }

    public void replaceData(List list) {
        mGodsons = list;
        notifyDataSetChanged();
    }

    @Override
    public GodsonsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.godsons_recycle_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GodsonsAdapter.ViewHolder holder, int position) {
        mViewHolder = holder;

        String godson = mGodsons.get(position);

        mViewHolder.mButton.setText(godson);

    }

    @Override
    public int getItemCount() {
        return mGodsons.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private Button mButton;

        public ViewHolder(View v) {
            super(v);

            mButton         = (Button) v.findViewById(R.id.godsons_button);
        }
    }
}