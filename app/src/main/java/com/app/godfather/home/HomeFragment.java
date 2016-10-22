package com.app.godfather.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.godfather.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.IgnoreExtraProperties;
import com.google.firebase.database.ValueEventListener;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.ButterKnife;

/**
 * Created by root on 21/10/16.
 */

public class HomeFragment extends Fragment {

    TextView textView;

    View view ;
    @IgnoreExtraProperties
    public static  class History {
        public String history;
        public String createdAt;

        public History() {
        }

        public History(String history, String createdAt) {
            this.history = history;
            this.createdAt = createdAt;
        }
    }
    public static HomeFragment newInstance(){
        return new HomeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.home_frag, container, false);
        ButterKnife.bind(this, view);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("histories");


        textView = (TextView) view.findViewById(R.id.history);
        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get Post object and use the values to update the UI
                // ...

                view = inflater.inflate(R.layout.home_frag, container, false);
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){

                    History history = dataSnapshot1.getValue(History.class);
                    textView.setText(history.history);

                }
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w("ERRORFIRE", "loadPost:onCancelled", databaseError.toException());
                // ...
            }
        };
        myRef.addValueEventListener(postListener);


//        myRef.push().setValue(history1);

//        histories.add(new History("CU","icu2"));
//        history.put("history",new History("History","Date"));

//        myRef.setValue(histories);


        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
