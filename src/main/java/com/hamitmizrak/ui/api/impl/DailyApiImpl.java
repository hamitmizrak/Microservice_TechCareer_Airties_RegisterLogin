package com.hamitmizrak.ui.api.impl;

import com.google.gson.JsonElement;
import com.hamitmizrak.business.services.IDailyService;
import com.hamitmizrak.ui.api.IDailyApi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//Lombok
@RequiredArgsConstructor

@RestController
@RequestMapping("gateway/daily")
public class DailyApiImpl implements IDailyApi {

    //Injection
    private final IDailyService dailyService;

    //http://localhost:5555/gateway/daily  ==> POST
    //SAVE
    @Override
    @PostMapping
    public ResponseEntity<?> saveDaily(@RequestBody JsonElement jsonElement) {
        return ResponseEntity.ok(dailyService.dailySave(jsonElement));
    }

    //http://localhost:5555/gateway/daily  ==> GET
    @Override
    @GetMapping
    public ResponseEntity<?> listDaily() {
        return ResponseEntity.ok(dailyService.dailyList());
    }

    //http://localhost:5555/gateway/daily/1  ==> DELETE
    @DeleteMapping
    @Override
    public ResponseEntity<?> deleteDaily(Long id) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
