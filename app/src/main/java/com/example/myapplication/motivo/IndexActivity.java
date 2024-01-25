package com.example.myapplication.motivo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication.Datainfo;
import com.example.myapplication.MainActivity2;
import com.example.myapplication.R;
import com.example.myapplication.adapter.MotivoAdapter;
import com.example.myapplication.model.Motivo;
import com.example.myapplication.network.MotivoAPIClient;
import com.example.myapplication.network.MotivoAPIService;

import java.lang.reflect.Array;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IndexActivity extends AppCompatActivity {

    ListView lista;
    private MotivoAPIService service;
    public void back (View view){
        startActivity(new Intent(this, MainActivity2.class));
        finish();
    }
    public void add (View view){
        startActivity(new Intent(this, AddMotivoActivity.class));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        service = MotivoAPIClient.getMotivoInstance();

        lista = findViewById(R.id.lista);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Motivo valor = (Motivo) lista.getItemAtPosition(position);
                Toast.makeText(IndexActivity.this, "POS= " + position+" "+valor, Toast.LENGTH_LONG).show();
            }
        });
        }

    @Override
    protected void onStart() {
        super.onStart();
        //cargarDatos();
        loadData();
    }

    private void loadData(){
    service.getAll().enqueue(new Callback<List<Motivo>>() {
        @Override
        public void onResponse(Call<List<Motivo>> call, Response<List<Motivo>> response) {
            if (response.isSuccessful()){
                List<Motivo> motivos = response.body();
                cargarDatos(motivos);
            }
        }

        @Override
        public void onFailure(Call<List<Motivo>> call, Throwable t) {

        }
    });
    }

    private void cargarDatos(List<Motivo> motivos){
        /*ArrayAdapter<Motivo> datos = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                motivos
        );*/
        MotivoAdapter datos = new MotivoAdapter(motivos, this);
        lista.setAdapter(datos);
    }

}
