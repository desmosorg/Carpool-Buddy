package com.example.carpoolbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class SpecificVehicle extends AppCompatActivity {

    private TextView owner;
    private TextView model;
    private TextView capacity;
    private TextView type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_vehicle);

        FirebaseAuth mAuth;
        FirebaseFirestore firestore;

        mAuth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();

        Bundle extras = getIntent().getExtras();

        owner = this.findViewById(R.id.Owner);
        model = this.findViewById(R.id.Model);
        capacity = this.findViewById(R.id.Capacity);
        type = this.findViewById(R.id.Type);


        if(getIntent().hasExtra("id")){
            String id = extras.getString("id");
            System.out.println("ID : " + id);

            DocumentReference doc = firestore.collection(com.example.carpoolbuddy.Constants.VEHICLE_COLLECTION).document(id);

            Task<DocumentSnapshot> query = doc.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {

                @Override
                public void onSuccess(DocumentSnapshot documentSnapshot) {
                    System.out.println(documentSnapshot);

//                    if(documentSnapshot.get("VehicleType").equals("Car")){
//                        Car currentVehicle = documentSnapshot.toObject(Car.class);
//                    }

                    Vehicle currentVehicle = documentSnapshot.toObject(Vehicle.class);

                    owner.setText("Owner : " + currentVehicle.getOwner());
                    model.setText("Model : " + currentVehicle.getModel());
                    capacity.setText("Capacity : " + currentVehicle.getCapacity());
                    type.setText("Type : " + currentVehicle.getVehicleType());



        }
      });
    }
}
}