package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.model.RespuestaLogin;
import com.example.myapplication.network.LoginAPIClient;
import com.example.myapplication.network.LoginAPIService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private LoginAPIService service;
    EditText editTextUsername;
    EditText editTextPassword;
    public void login(View view) {
        if (view.getId()==R.id.btnlogin) {

            EditText caja1 = findViewById(R.id.username);
            EditText caja2 = findViewById(R.id.clave);

            String email = caja1.getText().toString();
            String password = caja2.getText().toString();

            if (email==null || email.length()==0) {
                return;
            }
            if (password==null || password.length()==0) {
                return;
            }
            service.login(email, password).enqueue(new Callback<RespuestaLogin>() {
                @Override
                public void onResponse(Call<RespuestaLogin> call, Response<RespuestaLogin> response) {
                    if (response.isSuccessful()){
                        Datainfo.respuestaLogin=response.body();
                        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                        intent.putExtra("email", email);
                        intent.putExtra("password", password);
                        startActivity(intent);
                    }else {
                        Toast.makeText(MainActivity.this, "Error al Iniciar Sesion", Toast.LENGTH_SHORT).show();
                    }

                }

                @Override
                public void onFailure(Call<RespuestaLogin> call, Throwable t) {
                    Toast.makeText(MainActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });

    }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("msg", "onCreate");

        service= LoginAPIClient.getLoginService();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

}
