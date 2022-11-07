package com.hamitmizrak.business.services.impl;

import com.google.gson.JsonElement;
import com.hamitmizrak.business.services.IDailyService;
import com.hamitmizrak.retrofit.RetrofitCommonGenerics;
import com.hamitmizrak.retrofit.request.IDailyServiceRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

//Lombok
@RequiredArgsConstructor
@Log4j2

@Service
public class DailyService implements IDailyService {

    //injection
    private final IDailyServiceRequest iDailyServiceRequest;

    //SAVE
    @Override
    public JsonElement dailySave(JsonElement jsonElement) {
        return RetrofitCommonGenerics.retrofitGenerics(iDailyServiceRequest.dailySave(jsonElement));
    }

    //LİST
    @Override
    public List<JsonElement> dailyList() {
        return RetrofitCommonGenerics.retrofitGenerics(iDailyServiceRequest.dailyList());
    }

    //DELETE
    @Override
    public void dailyDelete(Long id) {
         RetrofitCommonGenerics.retrofitGenerics(iDailyServiceRequest.dailyDelete(id));
    }
}
