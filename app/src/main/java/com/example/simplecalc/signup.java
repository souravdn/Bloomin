package com.example.simplecalc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signup extends AppCompatActivity {
    private TextInputEditText mEmail, mPass, mPass1;
    private TextView mTextView;
    private Button signUpBtn;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //--------------------------------------------
        mEmail = findViewById(R.id.edit_email);
        mPass = findViewById(R.id.edit_password);
        mPass1 = findViewById(R.id.edit_password1);
        mTextView = findViewById(R.id.text1);
        signUpBtn = findViewById(R.id.signup_btn);
        mAuth = FirebaseAuth.getInstance();


        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(signup.this, signin.class));
            }
        });


        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createUser();
            }
        });
        //-------------------------------------------------


    }

    //---------------------------------------------------------------------------------------------------
    private void createUser() {
        String email = mEmail.getText().toString();
        String pass = mPass.getText().toString();
        String pass1 = mPass1.getText().toString();

        if (!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            if (!pass.isEmpty()) {
                mAuth.createUserWithEmailAndPassword(email, pass)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Toast.makeText(signup.this, "Registered Successfully!", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(signup.this, signout.class));
                                UserDB userDb = new UserDB(getApplicationContext());
                                userDb.loginUser(email, pass);
                                finish();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(signup.this, "Registration Error!", Toast.LENGTH_LONG).show();
                            }
                        });
            } else if (pass.length() < 5) {
                Toast.makeText(signup.this, "Password should not be less then 5 word.", Toast.LENGTH_LONG).show();
//                mPass.setText("Password should not be less then 5 word.");
            }
        } else if (email.isEmpty()) {
            Toast.makeText(signup.this, "Empty fild are not allowed", Toast.LENGTH_LONG).show();
//            mEmail.setError("Empty fild are not allowed");
        } else {
            Toast.makeText(signup.this, "Please Enter correct email.", Toast.LENGTH_LONG).show();
//            mEmail.setError("Please Enter correct email.");
        }

    }
    //---------------------------------------------------------------------------------------------

}