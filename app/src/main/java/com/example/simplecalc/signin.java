package com.example.simplecalc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signin extends AppCompatActivity {
    private TextInputEditText mEmail, mPass;
    private TextView mTextView;
    private Button signInBtn;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        mEmail = findViewById(R.id.edit_email2);
        mPass = findViewById(R.id.edit_password2);
        signInBtn = findViewById(R.id.signin_btn);
        mTextView = findViewById(R.id.text1);
        mAuth = FirebaseAuth.getInstance();

        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });

        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(signin.this, signup.class));
            }
        });
    }

    private void loginUser() {
        final String email = mEmail.getText().toString();
        final String pass = mPass.getText().toString();

        if (!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            if (!pass.isEmpty()) {
                mAuth.signInWithEmailAndPassword(email, pass)
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                Toast.makeText(signin.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(signin.this, signout.class));
                                UserDB userDb = new UserDB(getApplicationContext());
                                Log.i("Email",email);
                                Log.i("Email_EditTxt",mEmail.getText().toString());
                                Log.i("Passwd",pass);
                                Log.i("Edit_Passwd",mPass.getText().toString());
                                userDb.loginUser(email, pass);
                                finish();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(signin.this, "Login Failed, Check Username or password again!", Toast.LENGTH_SHORT).show();
                            }
                        });
            } else {
                mPass.setText("Empty fild are not allowed");
            }
        } else if (email.isEmpty()) {
            mEmail.setError("Empty fild are not allowed");
        } else {
            mEmail.setError("Please Enter correct email.");
        }

    }

}