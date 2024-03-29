package com.example.easy_event_app.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterAPICliente {

    private static final String URL = "http://10.201.194.86:8000/api/";

    private static RegisterAPIService instance;

    public static RegisterAPIService getRegisterService() {
        if (instance==null) {
            Retrofit http  = new Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create()).build();
            instance = http.create(RegisterAPIService.class);

        }
        return instance;
    }

}
