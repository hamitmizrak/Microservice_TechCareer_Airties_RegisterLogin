package com.hamitmizrak.business.services.impl;

import com.hamitmizrak.business.dto.UserDto;
import com.hamitmizrak.business.services.IAuthenticationService;
import com.hamitmizrak.security.UserPrincipal;
import com.hamitmizrak.security.jwt.IJwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

//lombok
//@RequiredArgsConstructor
public class AuthenticationServiceImpl implements IAuthenticationService {

    //injection
    @Autowired
    private  AuthenticationManager authenticationManager;
    @Autowired
    private  IJwtProvider iJwtProvider;


    @Override
    public String loginReturnJwt(UserDto userDto) {
        //Authentication
        Authentication authentication=authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userDto.getUsername(),userDto.getPassword()));

        //UserPrincipal
        UserPrincipal userPrincipal= (UserPrincipal) authentication.getPrincipal();

        //bu user kişisiyle git token oluştur
        return iJwtProvider.generateToken(userPrincipal);
    }
}
