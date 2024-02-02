package com.example.myapplication.network;

import com.example.myapplication.model.Ficha;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface FichaAPIService {
    @GET("ficha")
    Call<List<Ficha>> getAll();

    @GET("ficha/{id}")
    Call<Ficha> get(@Path("id") long id);

    @POST("ficha")
    Call<Ficha> add(@Body Ficha ficha);

    @DELETE("ficha/{id}")
    Call<Ficha> delete(@Path("id") long id);

    Call<Ficha> edit(@Path("id") long id, @Body Ficha ficha);;
}
