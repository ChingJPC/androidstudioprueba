package com.example.myapplication.motivo;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication.MainActivity2;
import com.example.myapplication.R;
import com.example.myapplication.adapter.FichaAdapter;
import com.example.myapplication.model.Ficha;
import com.example.myapplication.network.FichaAPIClient;
import com.example.myapplication.network.FichaAPIService;
import androidx.appcompat.widget.AppCompatImageButton;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IndexFichaActivity extends AddMotivoActivity {
    ListView listaficha;
    private FichaAPIService service;
    private Ficha fichaSeleccionada;

    public void backficha(View view) {
        startActivity(new Intent(this, MainActivity2.class));
        finish();
    }

    public void addficha(View view) {
        startActivity(new Intent(this, AddFichaActivity.class));
    }

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index_ficha);
        service = FichaAPIClient.getFichaInstance();
        listaficha = findViewById(R.id.listaficha);
        listaficha.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listaficha.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Ficha valor = (Ficha) listaficha.getItemAtPosition(position);
                Toast.makeText(IndexFichaActivity.this, "POS= " + position + " " + valor, Toast.LENGTH_LONG).show();
            }
        });

        AppCompatImageButton btneliminar = findViewById(R.id.btnEliminar);
        btneliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eliminarFicha();
            }
        });
        listaficha.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                fichaSeleccionada = (Ficha) listaficha.getItemAtPosition(position);
                Toast.makeText(IndexFichaActivity.this, "POS= " + position + " " + fichaSeleccionada, Toast.LENGTH_LONG).show();
            }
        });

    }


    @Override
    protected void onStart() {
        super.onStart();
        //cargarDatos();
        loadData();
    }

    private void loadData() {
        service.getAll().enqueue(new Callback<List<Ficha>>() {
            @Override
            public void onResponse(Call<List<Ficha>> call, Response<List<Ficha>> response) {
                if (response.isSuccessful()) {
                    List<Ficha> fichas = response.body();
                    cargarDatos(fichas);
                }
            }

            @Override
            public void onFailure(Call<List<Ficha>> call, Throwable t) {

            }
        });
    }

    private void cargarDatos(List<Ficha> fichas) {

        FichaAdapter datos = new FichaAdapter(fichas, this);
        listaficha.setAdapter((ListAdapter) datos);
    }

    public void eliminarFicha() {
        if (fichaSeleccionada != null) {
            Toast.makeText(this, "*****"+fichaSeleccionada.getId(), Toast.LENGTH_SHORT).show();
            service.delete(fichaSeleccionada.getId()).enqueue(new Callback<Ficha>() {
                @Override
                public void onResponse(Call<Ficha> call, Response<Ficha> response) {
                    if (response.isSuccessful()) {
                        Toast.makeText(IndexFichaActivity.this, "Ficha eliminada correctamente", Toast.LENGTH_SHORT).show();
                        loadData();
                    } else {
                        Toast.makeText(IndexFichaActivity.this, "Error al eliminar la ficha", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Ficha> call, Throwable t) {
                    Toast.makeText(IndexFichaActivity.this, "Error de red al eliminar la ficha", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            Toast.makeText(IndexFichaActivity.this, "Seleccione una ficha antes de eliminar", Toast.LENGTH_SHORT).show();
        }
    }
}