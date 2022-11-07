package com.hamitmizrak.retrofit;

import com.google.gson.Gson;
import com.hamitmizrak.retrofit.request.IDailyServiceRequest;
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

    //retrofit => @Bean
    @Bean
    public Retrofit.Builder secureKeyBuilder(OkHttpClient okHttpClient, Gson gson){
        return new Retrofit.Builder().client(okHttpClient).addConverterFactory(GsonConverterFactory.create(gson));
    }

    //OkHttpClient => @Bean
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

    ////////////////////////////////////////////////////////////////////////
    //Microservis buraya tanımlayalım.
    @Bean
    public IDailyServiceRequest dailyServiceRequest(Retrofit.Builder builder,@Value("${daily.service.url}") String dailyBaseUrl){
        return builder.baseUrl(dailyBaseUrl).build().create(IDailyServiceRequest.class);
    }
}
