package com.hamitmizrak.security;

import com.hamitmizrak.business.services.IUserServices;
import com.hamitmizrak.data.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//lombok
@RequiredArgsConstructor

@Service
public class UserDetailsServiceCustom implements UserDetailsService {

    //injection Service
    private final IUserServices services;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity=services.findUsername(username).orElseThrow(()->new UsernameNotFoundException(username+ "bulunamadı"));
        return new UserPrincipal(userEntity.getId(),userEntity.getUsername(),userEntity.getPassword());
    }
}
