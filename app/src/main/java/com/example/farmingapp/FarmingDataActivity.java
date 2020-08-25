package com.example.farmingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class FarmingDataActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farming_data);

        recyclerView= findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final RecyclerView_Config.DataAdapter adapter = new RecyclerView_Config.DataAdapter();
        recyclerView.setAdapter(adapter);

        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        ((LinearLayoutManager) mLayoutManager).setReverseLayout(true); // THIS ALSO SETS setStackFromBottom to true
        recyclerView.setLayoutManager(mLayoutManager);


        new FirebaseDatabaseHelper().readData(new FirebaseDatabaseHelper.DataStatus() {
            @Override
            public void DataIsLoaded(List<UserRobot> data, List<String> keys) {
                adapter.submitList(data,keys);
            }

            @Override
            public void DataIsInserted() {

            }

            @Override
            public void DataIsUpdated() {

            }

            @Override
            public void DataIsDeleted() {

            }
        });





    }


}
