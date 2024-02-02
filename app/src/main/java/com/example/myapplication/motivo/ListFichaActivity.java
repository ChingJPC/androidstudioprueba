package com.example.myapplication.motivo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.myapplication.Datainfo;
import com.example.myapplication.R;
import com.example.myapplication.adapter.FichaAdapter;
import com.example.myapplication.model.Ficha;
import com.example.myapplication.network.LoginAPIClient;
import com.example.myapplication.network.LoginAPIService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListFichaActivity extends AppCompatActivity {
    ListView listaficha;
    private LoginAPIService service;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_ficha);
        service= LoginAPIClient.getLoginService();
        listaficha=findViewById(R.id.listaficha);
    }
    @Override
    protected void onStart(){
        super.onStart();
        loadData();
    }

    private void loadData() {
        Log.i("Login", "Load");
        service.getFichas(Datainfo.respuestaLogin.getToken_type()+" "+
                Datainfo.respuestaLogin.getAccess_token()).enqueue(new Callback<List<Ficha>>() {
            @Override
            public void onResponse(Call<List<Ficha>> call, Response<List<Ficha>> response) {
                Log.i("Login", response.toString());
                if (response.isSuccessful()) {
                    List<Ficha> fichas = response.body();
                    cargarDatos(fichas);
                }
            }

            @Override
            public void onFailure(Call<List<Ficha>> call, Throwable t) {
                Log.e("Login", t.getMessage());
            }
        });
    }

    private void cargarDatos(List<Ficha> fichas) {

        FichaAdapter datos = new FichaAdapter(fichas, this);
        listaficha.setAdapter((ListAdapter) datos);
    }
}