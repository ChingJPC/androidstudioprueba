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

import java.lang.reflect.Array;

public class IndexActivity extends AppCompatActivity {

    ListView lista;
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

        lista = findViewById(R.id.lista);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String valor = (String) lista.getItemAtPosition(position);
                Toast.makeText(IndexActivity.this, "POS= " + position+" "+valor, Toast.LENGTH_LONG).show();
            }
        });
        }

    @Override
    protected void onStart() {
        super.onStart();
        cargarDatos();
    }

    private void cargarDatos(){
        ArrayAdapter<String> datos = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_single_choice,
                Datainfo.datos
        );
        lista.setAdapter(datos);
    }

}
