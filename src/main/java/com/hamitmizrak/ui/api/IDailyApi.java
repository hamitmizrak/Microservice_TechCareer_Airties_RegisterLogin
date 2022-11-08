package com.hamitmizrak.ui.api;
import com.google.gson.JsonElement;
import com.hamitmizrak.error.ApiResult;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IDailyApi {
    //SAVE
    ApiResult saveDaily(JsonElement jsonElement);

    //LIST
    ResponseEntity<List<?>> listDaily();

    //FIND
    ResponseEntity<?> findDaily(Long id);

    //DELETE
    ApiResult deleteDaily(Long id);

    //UPDATE
    ResponseEntity<?> updateDaily(Long id,JsonElement jsonElement);
}
