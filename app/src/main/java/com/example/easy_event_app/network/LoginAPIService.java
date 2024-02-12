package com.example.easy_event_app.network;

import com.example.easy_event_app.model.RespuestaLogin;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface LoginAPIService {

    @FormUrlEncoded
    @POST("auth/login")
    Call<RespuestaLogin> login (@Field("email") String email,
                                @Field("password") String password);


}
