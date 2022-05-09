package com.example.carpoolbuddy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class addVehicles extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vehicles);
    }




    public class addingVehicles extends AppCompatActivity {
//
//
//    private FirebaseAuth mAuth;
//    private FirebaseFirestore firestore;
//
//    private EditText emailField;
//    private EditText passField;
//    private EditText nameField;
//    private EditText userTypeField;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_signing_in);
//
//        mAuth = FirebaseAuth.getInstance();
//        firestore = FirebaseFirestore.getInstance();
//
//        emailField = findViewById(R.id.editTextEmailUp);
//        passField = findViewById(R.id.editTextPassUp);
//        nameField = findViewById(R.id.editTextNameUp);
//        userTypeField = findViewById(R.id.editTextUserTypeUp);
//
//    }
//
//
//
//    public void signUp(View v)
//    {
//        String emailString = emailField.getText().toString();
//        String passString = passField.getText().toString();
//        String nameString = nameField.getText().toString();
//        String userTypeString = userTypeField.getText().toString();
//        mAuth.createUserWithEmailAndPassword(emailString, passString).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//            @Override
//            public void onComplete(@NonNull Task<AuthResult> task) {
//                if(task.isSuccessful())
//                {
//                    FirebaseUser user = mAuth.getCurrentUser();
//                    Log.d("SIGN UP", "Successfully signed up the user!");
//                    updateUI(user);
////                    Toast message = Toast.makeText(this, "Account Creation Successful", Toast.LENGTH_LONG);
////                    message.show();
//                }
//                else
//                {
//                    Log.d("SIGN UP", "createUserWithEmail:failure", task.getException());
//                    updateUI(null);
////                    Toast message = Toast.makeText(this, "Account Creation Failed", Toast.LENGTH_LONG);
////                    message.show();
//                }
//            }
//        });
//
//
//
//    }
//
//    public void updateUI(FirebaseUser currentUser)
//    {
//        if(currentUser != null)
//        {
//            Intent intent = new Intent(this, AuthActivity.class);
//            startActivity(intent);
//        }
//
//    }

/*Change the name of these edit texts*/
        private FirebaseAuth mAuth;
        private FirebaseFirestore firestore;
        private LinearLayout layout;
        private EditText emailField;
        private EditText passwordField;
        private EditText nameField;
        private EditText gradYearField;
        private Spinner userVehicleSpinner;
        private String selectedRole;
        private String uid;
        private int uidGenerator = 1;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            mAuth = FirebaseAuth.getInstance();
            firestore = FirebaseFirestore.getInstance();
            layout = findViewById(R.id.signUpLayout);
            userVehicleSpinner = findViewById(R.id.signUpSpinner);
            setupSpinner();
            uid = "" + uidGenerator;
            uidGenerator++;
        }

        // setup spinner where user selects what user type they want to make an account for
        private void setupSpinner() {
            String[] userTypes = {"Student", "Teacher", "Alumni", "Parent"};
            // add user types to spinner
            ArrayAdapter<String> langArrAdapter = new ArrayAdapter<String>(com.example.carpoolbuddy.addVehicles.this,
                    android.R.layout.simple_spinner_item, userTypes);
            langArrAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            userVehicleSpinner.setAdapter(langArrAdapter);

            //triggered whenever user selects something different
            userVehicleSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
            {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
                {
                    selectedRole = parent.getItemAtPosition(position).toString();
                    addFields();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });
        }

        public void addFields() {
            commonFields();
            if(selectedRole.equals("Alumni")) {
                gradYearField = new EditText(this);
                gradYearField.setHint("Graduation year");
                layout.addView(gradYearField);
            }
        }

        public void commonFields() {
            layout.removeAllViewsInLayout();
            nameField = new EditText(this);
            nameField.setHint("Name");
            layout.addView(nameField);
            emailField = new EditText(this);
            emailField.setHint("Email");
            layout.addView(emailField);
            passwordField = new EditText(this);
            passwordField.setHint("Password");
            layout.addView(passwordField);
        }


        public void signUp(View v) {
            String nameString = nameField.getText().toString();
            String emailString = emailField.getText().toString();
            String passwordString = passwordField.getText().toString();
            mAuth.createUserWithEmailAndPassword(emailString, passwordString)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()) {
                                Log.d("SIGN UP", "successfully signed up the user");
                                FirebaseUser user = mAuth.getCurrentUser();
                                updateUI(user);
                            }
                            else {
                                Log.d("SIGN UP", "createUserWithEmail:failure", task.getException());
                                Toast.makeText(com.example.carpoolbuddy.addVehicles.this,"Sign up failed", Toast.LENGTH_LONG).show();
                                updateUI(null);
                            }
                        }
                    });



            if(selectedRole.equals("Alumni")) {
                int gradYearInt = Integer.parseInt(gradYearField.getText().toString());
//            Alumni newUser = new Alumni(uid, nameString, emailString, gradYearInt);
//            uidGenerator++;
//            firestore.collection("people").document(uid).set(newUser);
            }
        }

        public void updateUI(FirebaseUser currentUser) {
            if (currentUser != null) {
                Intent intent = new Intent(this, UserProfileActivity.class);
                startActivity(intent);
            }
        }

    }
}