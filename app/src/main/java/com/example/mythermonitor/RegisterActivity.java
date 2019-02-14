package com.example.mythermonitor;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    private EditText emailn;
    private EditText name;
    private EditText passwordn;
    private EditText confirm;
    private Button login;
    private Button register;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);
        firebaseAuth=FirebaseAuth.getInstance();
        name=findViewById(R.id.editText);
        emailn =findViewById(R.id.editText2);
        passwordn =findViewById(R.id.editText7);
        confirm=findViewById(R.id.editText8);
        register=findViewById(R.id.button3);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String user_email= emailn.getText().toString().trim();
                final String user_password=passwordn.getText().toString().trim();
                final String user_confrim=confirm.getText().toString().trim();
                firebaseAuth.createUserWithEmailAndPassword(user_email, user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(RegisterActivity.this,"Registration succesful",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegisterActivity.this,ListActivity.class));
                        }
                        else{
                            if(user_password.equals(user_confrim)) {
                                if (user_password.length() < 6) {
                                    Toast.makeText(RegisterActivity.this, "Password is too short", Toast.LENGTH_SHORT).show();
                                }
                                if (user_password.length() == 0) {
                                    Toast.makeText(RegisterActivity.this, "Please enter a Password", Toast.LENGTH_SHORT).show();
                                }
                                if (user_confrim.length() == 0) {
                                    Toast.makeText(RegisterActivity.this, "Please enter a Password", Toast.LENGTH_SHORT).show();
                                }
                                if (user_email.length() == 0) {
                                    Toast.makeText(RegisterActivity.this, "Please enter a valid email", Toast.LENGTH_SHORT).show();

                                }
                            }
                             else{
                                    Toast.makeText(RegisterActivity.this,"Password not correct",Toast.LENGTH_SHORT).show();
                                }
                        }


                    }
                });


            }
        });
        login=findViewById(R.id.button4);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();

            }
        });


    }


}
