package com.example.easy_event_app.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductoAPICliente {

    private static final String URL = "http://10.0.2.2:8000/api/";

    private static ProductoAPIService instance;

    public static ProductoAPIService getProductoService() {
        if (instance==null) {
            Retrofit http  = new Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create()).build();
            instance = http.create(ProductoAPIService.class);

        }
        return instance;
    }

}
