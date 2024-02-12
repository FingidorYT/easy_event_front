package com.example.easy_event_app.network;

import com.example.easy_event_app.model.RespuestaRegister;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RegisterEmpAPIService {

    @FormUrlEncoded
    @POST("auth/signup_empresario")
    Call<RespuestaRegister> registerEmpresario (@Field("cedula") String cedula,
                                                 @Field("nombre") String nombre,
                                                 @Field("apellido") String apellido,
                                                 @Field("email") String email,
                                                 @Field("fecha_nacimiento") String fechaNacimiento,
                                                 @Field("telefono") String telefono,
                                                 @Field("password") String password,
                                                 @Field("nit_empresa") String nit_empresa,
                                                 @Field("direccion_empresa") String direccion_empresa,
                                                 @Field("nombre_empresa") String nombre_empresa,
                                                 @Field("telefono_empresa") String telefono_empresa,
                                                 @Field("email_empresa") String email_empresa);

}
