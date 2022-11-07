package com.hamitmizrak.retrofit.request;

import com.google.gson.JsonElement;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface IDailyServiceRequest {

    //CREATE
    @POST("/api/v1/daily")
    Call<JsonElement> dailySave( @Body JsonElement jsonElement);

    //LIST
    @GET("/api/v1/daily")
    Call<List<JsonElement>> dailyList();

    //DELETE
    @DELETE("/api/v1/daily/{id}")
    Call<Void> dailyDelete(@Path("id") Long id);
}
