package com.hamitmizrak.retrofit.request.services;

import com.google.gson.JsonElement;
import com.hamitmizrak.retrofit.request.IDailyServiceRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import retrofit2.Call;

import java.util.List;

//Lombok
@RequiredArgsConstructor
@Log4j2

@Service
public class DailyServices implements IDailyServiceRequest {


    @Override
    public Call<JsonElement> dailySave(JsonElement jsonElement) {
        return null;
    }

    @Override
    public Call<Void> dailyDelete(Long id) {
        return null;
    }

    @Override
    public Call<List<JsonElement>> dailyList() {
        return null;
    }
}
