package com.hamitmizrak.business.services;

import com.google.gson.JsonElement;

import java.util.List;

public interface IDailyService {

    //SAVE
    JsonElement dailySave(JsonElement jsonElement);

    //LIST
    List<JsonElement> dailyList();

    //DELETE
    void dailyDelete(Long id);
}
