package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.myapplication.motivo.IndexActivity;

public class MainActivity2 extends AppCompatActivity {

    TextView textViewUsername;
    TextView textViewPassword;
    public void bro2 (View view){
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }
    public void motivo (View view){
        startActivity(new Intent(this, IndexActivity.class));
        finish();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String username = getIntent().getStringExtra("username");
        String password = getIntent().getStringExtra("password");

        textViewUsername = findViewById(R.id.user);
        textViewPassword = findViewById(R.id.pass);

        textViewUsername.setText("User: "+username);
        textViewPassword.setText("Password: "+password);
    }
}