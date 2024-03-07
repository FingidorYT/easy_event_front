package com.example.easy_event_app.network;

import com.example.easy_event_app.model.InfoAlquiler;
import com.example.easy_event_app.model.Alquiler;
import com.example.easy_event_app.model.AlquilerRespuesta;
import com.example.easy_event_app.model.ContadorAlquileres;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface AlquilerApiService {

    @GET("alquiler")
    Call<AlquilerRespuesta> alquileres (@Header("Authorization")String authorization);

    @GET("alquiler/{id}")
    Call<InfoAlquiler> alquiler_id (@Header("Authorization")String authorization,
                                    @Path("id") long id);

    @FormUrlEncoded
    @POST("alquiler/filtrar")
    Call <AlquilerRespuesta> alquiler_filtrado (@Header("Authorization")String authorization,
                                                 @Field("estado") String estado);

    @GET("alquileres/contar")
    Call <ContadorAlquileres> contaralquiler (@Header("Authorization")String authorization);

}
