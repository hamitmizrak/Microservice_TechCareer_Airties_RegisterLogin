package com.hamitmizrak.retrofit.request;

import com.google.gson.JsonElement;
import retrofit2.Call;
import retrofit2.http.*;
import java.util.List;

public interface IDailyServiceRequest {

    //CREATE
    //daily project api bilgilerini yazıyoruz
    @POST("/api/reg/v1/daily/create")
    Call<JsonElement> dailySave( @Body JsonElement jsonElement);

    //LIST
    //daily project api bilgilerini yazıyoruz
    @GET("/api/reg/v1/daily/list")
    Call<List<JsonElement>> dailyList();

    //FIND
    @GET("/api/reg/v1/daily/find/{id}")
    Call<JsonElement> dailyFind(@Path("id") Long id);

    //DELETE
    //daily project api bilgilerini yazıyoruz
    @DELETE("/api/reg/v1/daily/delete/{id}")
    Call<Void> dailyDelete(@Path("id") Long id);

    //UPDATE
    //daily project api bilgilerini yazıyoruz
    @PUT("/api/reg/v1/daily/update/{id}")
    Call<JsonElement> dailyUpdate(@Path("id") Long id, @Body JsonElement jsonElement);
}
