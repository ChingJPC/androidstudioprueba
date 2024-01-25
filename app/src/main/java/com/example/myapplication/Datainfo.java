package com.example.myapplication;

import com.example.myapplication.model.Motivo;

import java.util.ArrayList;
import java.util.Arrays;

public class Datainfo {
    public static ArrayList<Motivo> datos = new ArrayList<>(Arrays.asList(new Motivo[]{
            new Motivo("Salud"),
            new Motivo("Trabajo"),
            new Motivo("Calamidad")}));
}
