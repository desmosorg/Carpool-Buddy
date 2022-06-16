package com.example.carpoolbuddy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class VehiclesInfoActivity extends AppCompatActivity {

    RecyclerView recView;



    public void toUserProfileActivity(View v)
    {
        Intent nextScreen = new Intent(getBaseContext(), UserProfileActivity.class);
        startActivity(nextScreen);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicles_info);
        recView = findViewById(R.id.recView);


    }
}