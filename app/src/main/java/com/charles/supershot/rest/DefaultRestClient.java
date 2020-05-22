package com.charles.supershot.rest;

import android.content.Context;

import com.charles.supershot.common.Const;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DefaultRestClient<T> {
    private T service;
    private Context context;
    public DefaultRestClient(Context context){
        this.context = context;
    }
    public T getClient(Class<? extends T> type) {
        OkHttpClient okHttpClient = HttpClientHolder.instance().getHttpClient(context);
        Retrofit client = new Retrofit.Builder()
                .baseUrl(Const.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = client.create(type);
        return service;
    }
}
