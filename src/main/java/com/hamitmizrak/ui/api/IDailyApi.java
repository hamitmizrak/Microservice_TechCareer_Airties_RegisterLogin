package com.hamitmizrak.ui.api;

import com.google.gson.JsonElement;
import org.springframework.http.ResponseEntity;

public interface IDailyApi {
    ResponseEntity<?> saveDaily(JsonElement jsonElement);
    ResponseEntity<?> listDaily();
    ResponseEntity<?> deleteDaily(Long id);
}
