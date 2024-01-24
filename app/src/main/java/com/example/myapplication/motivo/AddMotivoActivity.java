package com.example.myapplication.motivo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.myapplication.Datainfo;
import com.example.myapplication.MainActivity2;
import com.example.myapplication.R;

public class AddMotivoActivity extends AppCompatActivity {
    public void back (View view){
        startActivity(new Intent(this, IndexActivity.class));
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_motivo);
    }
    public void click(View view){
    if(view.getId()==R.id.btnadd){
        EditText caja = findViewById(R.id.txtmotivo);
        String value = caja.getText().toString();
        if (value!=null && value.length()>0){
            Datainfo.datos.add(value);
            finish();
            return;
        }
    }
    }
}