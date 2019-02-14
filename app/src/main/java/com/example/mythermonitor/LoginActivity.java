package com.example.mythermonitor;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.text.TextUtils;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {
    EditText email;
    EditText Password;
    Button Login;
    Button register;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseApp.initializeApp(this);
        mAuth=FirebaseAuth.getInstance();
        email=findViewById(R.id.email);
        Password=findViewById(R.id.editText3);
        register=findViewById(R.id.button);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(go);
                finish();
            }
        });
        Login=findViewById(R.id.button2);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                final String user_email= email.getText().toString().trim();
//                final String user_password=Password.getText().toString().trim();
//                mAuth.signInWithEmailAndPassword(user_email,user_password).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(Task<AuthResult> task) {
//                        if (!task.isSuccessful()) {
//                            Toast.makeText(ThisActivity.this, "sign in error", Toast.LENGTH_SHORT).show();
//                        } else
//                            mAuth.addAuthStateListener(firebaseAuthListener);
//                    }
//                });
                final String user_email = email.getText().toString().trim();
                final String user_password = Password.getText().toString().trim();

                if (!TextUtils.isEmpty(user_email) && !TextUtils.isEmpty(user_password)) {
                    mAuth.signInWithEmailAndPassword(user_email, user_password).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {

                                Toast.makeText(getApplicationContext(), "sign in error", Toast.LENGTH_SHORT).show();
                            } else {
//                                mAuth.addAuthStateListener(firebaseAuthListener);
                                Intent intent = new Intent(LoginActivity.this, ListActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        }

                    });
                }
            }
        });
    }
}
