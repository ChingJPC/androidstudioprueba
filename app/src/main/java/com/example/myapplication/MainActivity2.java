package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.myapplication.motivo.IndexActivity;
import com.example.myapplication.motivo.IndexFichaActivity;
import com.example.myapplication.motivo.ListFichaActivity;

public class MainActivity2 extends AppCompatActivity {

    TextView textViewUsername;
    TextView textViewPassword;
    public void bro2 (View view){
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }
    public void ficha (View view){
        startActivity(new Intent(this, IndexFichaActivity.class));
    }
    public void motivo (View view){
        startActivity(new Intent(this, IndexActivity.class));
    }
    public void gomotivotoken (View view){
        startActivity(new Intent(this, ListFichaActivity.class));
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