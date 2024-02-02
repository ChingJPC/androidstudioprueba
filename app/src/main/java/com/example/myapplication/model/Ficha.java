package com.example.myapplication.model;

import androidx.annotation.NonNull;

public class Ficha {
    private long id;
    private long numero;
    private String programa;
    private String lider;

    public Ficha(long numero, String programa, String lider) {
        this.numero = numero;
        this.programa = programa;
        this.lider = lider;
    }

    public Ficha(long id, Integer numero, String programa, String lider) {
        this.id = id;
        this.numero = numero;
        this.programa = programa;
        this.lider = lider;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public String getLider() {
        return lider;
    }

    public void setLider(String lider) {
        this.lider = lider;
    }

    @NonNull
    @Override
    public String toString(){
        return programa;
    }
}
