package com.example.mythermonitor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
private EditText email;
private EditText Password;
private Button Login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email=findViewById(R.id.email);
        Password=findViewById(R.id.editText3);
        Login=findViewById(R.id.button2);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openListActivity();
            }
        });

    }
    public void openListActivity(){
        Intent intent = new Intent(this,ListActivity.class);
        startActivity(intent);
        finish();

    }
}
