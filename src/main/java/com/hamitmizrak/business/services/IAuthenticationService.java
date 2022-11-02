package com.hamitmizrak.business.services;

import com.hamitmizrak.business.dto.UserDto;

public interface IAuthenticationService {

    String loginReturnJwt(UserDto userDto);
}
