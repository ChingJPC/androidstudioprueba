package com.example.myapplication.motivo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.model.Ficha;
import com.example.myapplication.network.FichaAPIClient;
import com.example.myapplication.network.FichaAPIService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddFichaActivity extends AppCompatActivity {
    private FichaAPIService service;

    public void back(View view) {
        startActivity(new Intent(this, IndexFichaActivity.class));
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_ficha);
        service = FichaAPIClient.getFichaInstance();

    }

    public void click(View view) {
        if (view.getId() == R.id.btnadd) {
            EditText caja1 = findViewById(R.id.txtnumero);
            String value1 = caja1.getText().toString();
            EditText caja2 = findViewById(R.id.txtprograma);
            String value2 = caja2.getText().toString();
            EditText caja3 = findViewById(R.id.txtlider);
            String value3 = caja3.getText().toString();

            if (value1 != null && value1.length() > 0) {
                Ficha nuevaFicha = new Ficha(Integer.parseInt(value1), value2, value3);


                service.add(nuevaFicha).enqueue(new Callback<Ficha>() {
                    @Override
                    public void onResponse(Call<Ficha> call, Response<Ficha> response) {
                        Toast.makeText(AddFichaActivity.this, "Ficha creada correctamente", Toast.LENGTH_SHORT).show();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<Ficha> call, Throwable t) {
                        Toast.makeText(AddFichaActivity.this, "Error al crear la ficha", Toast.LENGTH_SHORT).show();
                    }
                });
            } else {
                Toast.makeText(AddFichaActivity.this, "Ingrese un número válido", Toast.LENGTH_SHORT).show();
            }
        }
    }
}


