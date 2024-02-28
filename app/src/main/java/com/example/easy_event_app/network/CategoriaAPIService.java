package com.example.easy_event_app.network;

import com.example.easy_event_app.model.CategoriaRespuesta;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface CategoriaAPIService {

    @GET("categoria")
    Call<CategoriaRespuesta> categorias (@Header("Authorization")String authorization);

}
