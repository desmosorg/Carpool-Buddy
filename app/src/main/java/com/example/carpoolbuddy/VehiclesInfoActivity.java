package com.example.carpoolbuddy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class VehiclesInfoActivity extends AppCompatActivity implements VehiclesInfoAdapter.OnNoteListener {

    RecyclerView recView;


    private FirebaseAuth mAuth;
    private FirebaseFirestore firestore;

    private ArrayList<Vehicle> allVehicles;


    public void toUserProfileActivity(View v)
    {
        Intent nextScreen = new Intent(getBaseContext(), UserProfileActivity.class);
        startActivity(nextScreen);
    }

    public void createAdapter(ArrayList<Vehicle> vehiclesList) {

        VehiclesInfoAdapter myAdapter = new VehiclesInfoAdapter(vehiclesList, this);

        recView.setAdapter(myAdapter);
        recView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicles_info);

        mAuth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();

        recView = this.findViewById(R.id.recView);

        allVehicles = new ArrayList<>();

        getVehicles();
    }

    public void getVehicles(){
        TaskCompletionSource<String> getAllRidesTask = new TaskCompletionSource<>();
        firestore.collection("Vehicles").whereEqualTo("open", true)
                .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful() && task.getResult() != null) {
                    for (QueryDocumentSnapshot document : task.getResult()) {

                        allVehicles.add(document.toObject(Vehicle.class));

                    }
                    getAllRidesTask.setResult(null);
                }
                else {
                    Log.d("VehiclesInfoActivity", "Error getting documents from db: ", task.getException());
                }
            }
        });
        getAllRidesTask.getTask().addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(@NonNull Task<String> task) {
                System.out.println("All Vehicles: " + allVehicles);
                createAdapter(allVehicles);

            }
        });
    }



    @Override
    public void onNoteClick(int position) {
        System.out.println("CLICKED: " + position);

        Intent intent = new Intent(this, SpecificVehicle.class);

        intent.putExtra("id", "" + allVehicles.get(position).getVehicleID());

        startActivity(intent);
    }



}