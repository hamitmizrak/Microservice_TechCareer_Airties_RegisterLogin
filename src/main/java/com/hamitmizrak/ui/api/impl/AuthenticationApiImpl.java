package com.hamitmizrak.ui.api.impl;

import com.hamitmizrak.business.dto.UserDto;
import com.hamitmizrak.business.services.IAuthenticationService;
import com.hamitmizrak.business.services.IUserServices;
import com.hamitmizrak.ui.api.IAuthenticationApi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//lombok
@RequiredArgsConstructor

@RestController
@RequestMapping("/api/authentication")
public class AuthenticationApiImpl implements IAuthenticationApi {

    //Injection
    private final IAuthenticationService authenticationService;
    private final IUserServices userServices;

    //LOGIN
    // http://localhost:5555/api/authentication/login
    @Override
    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(authenticationService.loginReturnJwt(userDto), HttpStatus.OK);
    }

    //REGISTER
    // http://localhost:5555/api/authentication/register
    @Override
    @PostMapping("register")
    public ResponseEntity<?> register(@RequestBody UserDto userDto) {
        //kullanıcı adımız unique olmalıdır.
        if(userServices.findUsername(userDto.getUsername()).isPresent()){
            //aynı kullanıcı varsa conflict oluşturalım
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(userServices.createUser(userDto),HttpStatus.CREATED);
    }
}
