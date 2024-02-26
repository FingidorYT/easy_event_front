package com.example.easy_event_app.network;

import com.example.easy_event_app.model.CategoriaRespuesta;
import com.example.easy_event_app.model.ProductoRespuesta;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface ProductoAPIService {

    @GET("producto")
    Call<ProductoRespuesta> productos (@Header("Authorization")String authorization);


}
