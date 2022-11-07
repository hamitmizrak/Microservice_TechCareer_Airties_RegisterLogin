package com.hamitmizrak.ui.api.impl;

import com.google.gson.JsonElement;
import com.hamitmizrak.ui.api.IDailyApi;
import org.springframework.http.ResponseEntity;

public class IDailyApiImpl implements IDailyApi {

    @Override
    public ResponseEntity<?> saveDaily(JsonElement jsonElement) {
        return null;
    }

    @Override
    public ResponseEntity<?> listDaily() {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteDaily(Long id) {
        return null;
    }
}
