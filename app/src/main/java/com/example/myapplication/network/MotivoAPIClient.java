package com.example.myapplication.network;

import com.example.myapplication.model.Motivo;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MotivoAPIClient {
    private static final String URL = "http://10.201.194.60:8000/api/";

    private static MotivoAPIService instance;

    public static MotivoAPIService getMotivoInstance(){
        if(instance==null){
            Retrofit retro = new Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
                    instance = retro.create(MotivoAPIService.class);
        }
        return instance;
    }
}
