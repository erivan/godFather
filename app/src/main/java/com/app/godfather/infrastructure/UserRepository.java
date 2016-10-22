package com.app.godfather.infrastructure;

import com.app.godfather.domain.entity.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by erivan on 21/10/16.
 */
public class UserRepository {
    private static UserRepository INSTANCE;
    private DatabaseReference mRef;

    public static UserRepository getInstance() {
        if(INSTANCE == null)
            INSTANCE = new UserRepository();

        return INSTANCE;
    }

    private UserRepository() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        mRef = database.getReference("users");
    }

    public void save(User user) {
        mRef.child(user.getEmail().replace("@", "").replace(".", "")).setValue(user);
    }

    public interface LoadUserCallback {
        void onSuccess(User user);
    }

    public void findByEmail(String email, final LoadUserCallback callback ) {
        final ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                callback.onSuccess(snapshot.getValue(User.class));
            }
            @Override public void onCancelled(DatabaseError error) { }
        };
        mRef.removeEventListener(postListener);
        mRef.child(email).addValueEventListener(postListener);
    }
}
