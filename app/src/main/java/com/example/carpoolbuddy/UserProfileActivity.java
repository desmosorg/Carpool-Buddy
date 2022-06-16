package com.example.carpoolbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class UserProfileActivity extends AppCompatActivity {

    public void toVehiclesInfo(View v)
    {
        Intent nextScreen = new Intent(getBaseContext(), VehiclesInfoActivity.class);
        startActivity(nextScreen);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
    }

    public void createVehicle(View v){
        Intent nextScreen = new Intent(getBaseContext(), CreateVehicleActivity.class);
        startActivity(nextScreen);
    }
}