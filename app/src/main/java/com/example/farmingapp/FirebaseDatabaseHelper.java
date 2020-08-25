package com.example.farmingapp;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.auth.User;

import java.util.ArrayList;
import java.util.List;

public class FirebaseDatabaseHelper {

    private FirebaseDatabase mDatabase;
    private DatabaseReference mReference;
    private List<UserRobot> data = new ArrayList<>();

    public interface DataStatus{

        void DataIsLoaded(List<UserRobot> data, List<String> keys);
        void DataIsInserted();
        void DataIsUpdated();
        void DataIsDeleted();


    }

    public FirebaseDatabaseHelper(){
        mDatabase = FirebaseDatabase.getInstance();
        mReference = mDatabase.getReference("users");
    }

    public void readData(final DataStatus dataStatus){
        mReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                data.clear();
                List<String> keys = new ArrayList<>();
                for(DataSnapshot keyNode: dataSnapshot.getChildren()){
                    keys.add(keyNode.getKey());
                    UserRobot userData = keyNode.getValue(UserRobot.class);
                    data.add(userData);
                }
                dataStatus.DataIsLoaded(data,keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
