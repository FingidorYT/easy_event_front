package com.example.easy_event_app.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterEmpAPICliente {

    private static final String URL = "http://10.0.2.2:8000/api/";

    private static RegisterEmpAPIService instance;

    public static RegisterEmpAPIService getRegisterEmpService() {
        if (instance == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            instance = retrofit.create(RegisterEmpAPIService.class);
        }
        return instance;
    }

}
