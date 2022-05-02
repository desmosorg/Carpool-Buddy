package com.example.carpoolbuddy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class AuthActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseFirestore firestore;

    private EditText emailField;
    private EditText passField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        mAuth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();

        emailField = findViewById(R.id.editTextUser);
        passField = findViewById(R.id.editTextPass);

        String email = emailField.getText().toString();
        String pass = passField.getText().toString();

    }

    public void signIn(View v)
    {
        String email = emailField.getText().toString();
        String pass = passField.getText().toString();

        mAuth.signInWithEmailAndPassword( email, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("SIGNIN SUCCESSFULL", "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("SIGNIN SUCCESSFULL", "signInWithEmail:failure", task.getException());

                            updateUI(null);
                        }
                    }
                });
        User myself = new User("1234","nathan", "nathaniel_powell@fis.edu", "student", 0.5);

        firestore.collection("CarpoolBuddy").document("Information").collection("Users").document(myself.getUid()).set(myself);

    }


   public void signUp(View v)
   {
        String emailString = emailField.getText().toString();
        String passString = passField.getText().toString();
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



//       Intent intent = new Intent(this, signingIn.class);
//       startActivity(intent);
  }

    public void updateUI(FirebaseUser currentUser)
    {
        if(currentUser != null)
        {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }

    }
}