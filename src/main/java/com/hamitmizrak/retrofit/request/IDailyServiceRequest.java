package com.hamitmizrak.retrofit.request;

import com.google.gson.JsonElement;
import retrofit2.Call;

import java.util.List;

public interface IDailyServiceRequest {

    //CREATE
    Call<JsonElement> dailySave(JsonElement jsonElement);

    //DELETE
    Call<Void> dailyDelete(Long id);

    //LIST
    Call<List<JsonElement>> dailyList();

}
