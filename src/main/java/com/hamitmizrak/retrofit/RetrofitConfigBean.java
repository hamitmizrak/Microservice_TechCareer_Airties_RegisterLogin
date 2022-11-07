package com.hamitmizrak.retrofit;


import com.google.gson.Gson;
import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;
//Configuration: spring' yeni bir nesne kardeş var bilgin olsun
@Configuration
public class RetrofitConfigBean {

    @Value("${retrofit.timeout}")
    private Long TIMEOUT_SECONDS;

    //retrofit bean
    @Bean
    public Retrofit.Builder secureKeyBuilder(OkHttpClient okHttpClient, Gson gson){
        return new Retrofit.Builder().client(okHttpClient).addConverterFactory(GsonConverterFactory.create(gson));
    }

    @Bean
    public OkHttpClient secureKeyClient(
            @Value("${service.security.secure-key-username}") String secureKeyUsernameStr,
            @Value("${service.security.secure-key-password}") String secureKeyPasswordStr){
        return specialDefaultClientBuilder().addInterceptor(temp->temp.proceed(
                temp.request().newBuilder().header("Authorization", Credentials.basic(secureKeyUsernameStr,secureKeyPasswordStr))
                        .build())).build();
    }

    private OkHttpClient.Builder specialDefaultClientBuilder() {
        return new OkHttpClient.Builder()
                .writeTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS)
                .readTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS)
                .connectTimeout(TIMEOUT_SECONDS,TimeUnit.SECONDS);
    }
}
