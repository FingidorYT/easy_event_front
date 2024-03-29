package com.example.easy_event_app.network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AlquilerApiCliente {

    private static final String URL = "http://10.201.194.86:8000/api/";

    private static AlquilerApiService instance;

    public static AlquilerApiService getAlquilerService() {
        if (instance==null) {

            final HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);

            final OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            httpClient.addInterceptor(logging);

            Retrofit http  = new Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build();
            instance = http.create(AlquilerApiService.class);

        }
        return instance;
    }
}
