package com.altv.dugout_data.network;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiModule {

    private static final String BASE_URL = //"http://192.168.10.10/api/v1/";
     "https://api.dugout.com/api/v1/";

    private static IHttpServiceClient instance;

    public static IHttpServiceClient provideRemoteClient() {
        if(instance==null) {
            instance = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(provideOkHttpClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
                    .create(IHttpServiceClient.class);
        }

        return instance;
    }

    private static OkHttpClient provideOkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        return builder.build();
    }
}
