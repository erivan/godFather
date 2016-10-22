package com.app.godfather.infrastructure;

import com.app.godfather.domain.entity.Experience;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Collections;
import java.util.List;

/**
 * Created by erivan on 21/10/16.
 */
public class ExperienceRepository {

    private static ExperienceRepository INSTANCE;
    private DatabaseReference mRef;

    public static ExperienceRepository getInstance() {
        if(INSTANCE == null)
            INSTANCE = new ExperienceRepository();

        return INSTANCE;
    }

    private ExperienceRepository() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        mRef = database.getReference("experiences");
    }

    public void save(Experience experience) {
        mRef.push().setValue(experience);
    }

    public interface LoadExperiencesCallback {
        void onSuccess(List<Experience> experiences);
    }

    public void all(final LoadExperiencesCallback callback ) {

        final ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                List<Experience> experiences = ExperienceBase.getExperiences();

                for (DataSnapshot dataSnapshot2 : dataSnapshot.getChildren()) {
                    Experience experience = dataSnapshot2.getValue(Experience.class);
                    experiences.add(experience);
                }
                Collections.reverse(experiences);
                callback.onSuccess(experiences);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        };
        mRef.removeEventListener(postListener);
        mRef.addValueEventListener(postListener);
    }

}
