package com.hamitmizrak.retrofit;

import lombok.extern.log4j.Log4j2;
import retrofit2.Call;
import retrofit2.Response;

@Log4j2
public class RetrofitCommonGenerics {

    public static <T> T retrofitGenerics(Call<T> request){
        try {
            Response<T> response=request.execute();
            if(!response.isSuccessful()){
                log.error("Retrofit Daily Failed statusCode:{} reason:{}",response.code(),response.errorBody().string());
            }
            return response.body();
        }catch (Exception exception){
            exception.printStackTrace();
            throw new RuntimeException(exception);
        }
    }
}
