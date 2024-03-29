package com.example.myapplication.network;

import com.example.myapplication.model.Ficha;
import com.example.myapplication.model.Motivo;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FichaAPIClient {
    private static final String URL = "http://10.201.194.60:8000/api/";

    private static FichaAPIService instance;

    public static FichaAPIService getFichaInstance(){
        if(instance==null){
            Retrofit retro = new Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            instance = retro.create(FichaAPIService.class);
        }
        return instance;
    }
}