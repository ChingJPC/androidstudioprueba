package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextUsername;
    EditText editTextPassword;
    public void login(View view) {
        editTextUsername = findViewById(R.id.username);
        editTextPassword = findViewById(R.id.clave);
        String username = editTextUsername.getText().toString();
        String password = editTextPassword.getText().toString();

        if (username.equals("ching")&&password.equals("123")){
        Intent home = new Intent(this, MainActivity2.class);
        home.putExtra("username", username);
        home.putExtra("password", password);

        startActivity(home);
    }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

}
