package com.hcmute.tin3p.retrofit2andrxjava.Retrofit;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

//https://jsonplaceholder.typicode.com/posts
public class RetrofitClient {
    private static Retrofit ourInstance;

    public static Retrofit getClient(String baseUrl) {
        if(ourInstance==null)
            ourInstance=new Retrofit.Builder().baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        return ourInstance;
    }

    public static Retrofit getClient2(String baseUrl) {
        if(ourInstance==null)
            ourInstance=new Retrofit.Builder().baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        return ourInstance;
    }

    private RetrofitClient() {
    }
}
