package com.example.farmingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class HomePageActivity extends AppCompatActivity {

    private TextView userEmail;
    private Button signOutButton;
    private ImageView data;
    private ImageView stats;
    private ImageView contacts;
    private ImageView news;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    private FirebaseUser mUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);


        // TextView and Buttons
        userEmail=findViewById(R.id.userEmail);
        signOutButton=findViewById(R.id.SignOutButton);
        data = findViewById(R.id.data);
        contacts= findViewById(R.id.contacts);
        stats= findViewById(R.id.stats);
        news=findViewById(R.id.newsButton);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mUser = mAuth.getCurrentUser();



        signOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(HomePageActivity.this,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);

            }
        });


        data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(HomePageActivity.this, FarmingDataActivity.class));

            }
        });


        contacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(HomePageActivity.this, ContactsActivity.class));

            }
        });

        stats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(HomePageActivity.this, StatisticsActivity.class));
            }
        });

        news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(HomePageActivity.this, NewsActivity.class));
            }
        });



    }
}
