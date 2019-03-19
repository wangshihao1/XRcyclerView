package com.bawei.weektwos.data.utils;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RectrofitUtils {

    private static volatile RectrofitUtils instance;
    private final Retrofit retrofit;

    private RectrofitUtils(){

        retrofit = new Retrofit.Builder()
                .baseUrl(Apis.BEAUTIFUL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static RectrofitUtils getInstance() {
        if (instance==null){
            synchronized (RectrofitUtils.class){
                if (instance==null){
                    instance = new RectrofitUtils();
                }
            }
        }
        return instance;
    }


    public <T> T  response(Class<T> service){

        return retrofit.create(service);
    }
}
