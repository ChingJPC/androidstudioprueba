package com.example.myapplication.model;

import androidx.annotation.NonNull;

public class Motivo {
    private long id;
    private String nombre;

    public Motivo(String nombre) {
        this.nombre = nombre;
    }

    public Motivo(long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /*
    @Override
    public String toString() {
        return "Motivo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }*/

    @NonNull
    @Override
    public String toString(){
        return nombre;
    }
}
