package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.model.Ficha;
import com.example.myapplication.motivo.IndexFichaActivity;

import java.util.List;

public class FichaAdapter extends BaseAdapter {
    private List<Ficha> fichas;
    private Context context;

    public FichaAdapter(List<Ficha> ficha, Context context) {
        this.fichas = ficha;
        this.context = context;
    }

    @Override
    public int getCount() {
        return fichas.size();
    }

    @Override
    public Object getItem(int position) {
        return fichas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return fichas.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.ficha_item_layout,null);
        }
        Ficha ficha=fichas.get(position);
        TextView txtid = convertView.findViewById(R.id.txtid);
        TextView txtNumero = convertView.findViewById(R.id.txtnumero);
        TextView txtPrograma = convertView.findViewById(R.id.txtprograma);
        TextView txtLider = convertView.findViewById(R.id.txtlider);
        txtid.setText(String.valueOf(ficha.getId()));
        txtNumero.setText(""+ ficha.getNumero());
        txtPrograma.setText(ficha.getPrograma());
        txtLider.setText(ficha.getLider());
        return convertView;
    }
}

