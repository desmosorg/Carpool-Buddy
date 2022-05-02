package com.example.carpoolbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class VehiclesInfoActivity extends AppCompatActivity {

    public void toUserProfileActivity(View v)
    {
        Intent nextScreen = new Intent(getBaseContext(), UserProfileActivity.class);
        startActivity(nextScreen);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicles_info);
    }
}