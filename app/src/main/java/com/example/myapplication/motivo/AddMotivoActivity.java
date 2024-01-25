package com.example.myapplication.motivo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.Datainfo;
import com.example.myapplication.MainActivity2;
import com.example.myapplication.R;
import com.example.myapplication.model.Motivo;
import com.example.myapplication.network.MotivoAPIClient;
import com.example.myapplication.network.MotivoAPIService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddMotivoActivity extends AppCompatActivity {
    private MotivoAPIService service;
    public void back (View view){
        startActivity(new Intent(this, IndexActivity.class));
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_motivo);
        service = MotivoAPIClient.getMotivoInstance();

    }
    public void click(View view){
    if(view.getId()==R.id.btnadd){
        EditText caja = findViewById(R.id.txtmotivo);
        String value = caja.getText().toString();
        if (value!=null && value.length()>0){
            service.add(new Motivo(value)).enqueue(new Callback<Motivo>() {
                @Override
                public void onResponse(Call<Motivo> call, Response<Motivo> response) {
                    Toast.makeText(AddMotivoActivity.this, "Motivo creado OK", Toast.LENGTH_SHORT).show();
                    finish();
                }

                @Override
                public void onFailure(Call<Motivo> call, Throwable t) {
                    Toast.makeText(AddMotivoActivity.this, "Error al crear el motivo", Toast.LENGTH_SHORT).show();
                }
            });
            //Datainfo.datos.add(new Motivo(value));
            //finish();
            //return;
        }
    }
    }
}