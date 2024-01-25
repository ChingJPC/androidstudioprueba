package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.model.Motivo;

import org.w3c.dom.Text;

import java.util.List;

public class MotivoAdapter extends BaseAdapter {

    private List<Motivo> motivos;
    private Context context;

    public MotivoAdapter(List<Motivo> motivo, Context context) {
        this.motivos = motivo;
        this.context = context;
    }

    @Override
    public int getCount() {
        return motivos.size();
    }

    @Override
    public Object getItem(int position) {
        return motivos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return motivos.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.motivo_item_layout,null);
        }
        Motivo motivo=motivos.get(position);
        TextView txtid = convertView.findViewById(R.id.txtid);
        TextView txtNombre = convertView.findViewById(R.id.txtnombre);
        txtid.setText(String.valueOf(motivo.getId()));
        txtNombre.setText(motivo.getNombre());
        return convertView;
    }
}
