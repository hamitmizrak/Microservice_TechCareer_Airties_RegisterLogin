package com.hamitmizrak.security.jwt;

import com.hamitmizrak.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;

//spring tarafaından tanınması
@Component
public class JwtProviderImpl  implements  IJwtProvider{

    //Token header
    private static final String JWT_TOKEN_PREFIX="Bearer";
    private static final String JWT_HEADER_STRING="Authorization";

    //application.properties
    @Value("${authentication.jwt.expiration-ms}")
    private Long JWT_EXPRIRATION_MS;

    //Genel Anahtar(Public)
    private PublicKey jwtPublicKey;

    //Özel Anahtar(Private)
    private PublicKey jwtPrivateKey;

    //parametreli constructor
    public JwtProviderImpl() {
    }

    //1.YÖNTEM (Token create)
    //userPrincipal: username,password,roles
    @Override
    public KeyFactory getKeyFactory() {
        try {
            return KeyFactory.getInstance("RSA");
        }catch (NoSuchAlgorithmException keyFactory){
            throw new RuntimeException("bilinmwywn key algoritması ",keyFactory);
        }
    }

    @Override
    public String generateToken(UserPrincipal userPrincipal) {
        return null;
    }


    //2.YÖNTEM (jwt ayrıştırılması Bearer
    //HEADER: bearer => 7
    @Override
    public String resolveToken(HttpServletRequest httpServletRequest) {
        return null;
    }

    @Override
    public Authentication getAuthentication(HttpServletRequest httpServletRequest) {
        return null;
    }

    //3.YÖNTEM (token süresini kontrol etmek )
    @Override
    public boolean isValidateToken(HttpServletRequest httpServletRequest) {
        return false;
    }
}
