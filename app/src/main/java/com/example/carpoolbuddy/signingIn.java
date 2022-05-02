package com.example.carpoolbuddy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class signingIn extends AppCompatActivity {


    private FirebaseAuth mAuth;
    private FirebaseFirestore firestore;

    private EditText emailField;
    private EditText passField;
    private EditText nameField;
    private EditText userTypeField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signing_in);

        mAuth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();

        emailField = findViewById(R.id.editTextEmailUp);
        passField = findViewById(R.id.editTextPassUp);
        nameField = findViewById(R.id.editTextNameUp);
        userTypeField = findViewById(R.id.editTextUserTypeUp);

    }



    public void signUp(View v)
    {
        String emailString = emailField.getText().toString();
        String passString = passField.getText().toString();
        String nameString = nameField.getText().toString();
        String userTypeString = userTypeField.getText().toString();
        mAuth.createUserWithEmailAndPassword(emailString, passString).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    FirebaseUser user = mAuth.getCurrentUser();
                    Log.d("SIGN UP", "Successfully signed up the user!");
                    updateUI(user);
//                    Toast message = Toast.makeText(this, "Account Creation Successful", Toast.LENGTH_LONG);
//                    message.show();
                }
                else
                {
                    Log.d("SIGN UP", "createUserWithEmail:failure", task.getException());
                    updateUI(null);
//                    Toast message = Toast.makeText(this, "Account Creation Failed", Toast.LENGTH_LONG);
//                    message.show();
                }
            }
        });



    }

    public void updateUI(FirebaseUser currentUser)
    {
        if(currentUser != null)
        {
            Intent intent = new Intent(this, AuthActivity.class);
            startActivity(intent);
        }

    }


}