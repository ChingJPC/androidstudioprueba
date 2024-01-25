package com.example.myapplication.network;

import com.example.myapplication.model.Motivo;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface MotivoAPIService {
    @GET("motivo")
    Call<List<Motivo>> getAll();

    @GET("motivo/{id}")
    Call<Motivo> get(@Path("id") long id);

    @POST("motivo")
    Call<Motivo> add(@Body Motivo motivo);

    @DELETE("motivo/{id}")
    Call<Motivo> delete(@Path("id") long id);

    Call<Motivo> edit(@Path("id") long id, @Body Motivo motivo);;
}
