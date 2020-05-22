package com.charles.supershot.rest;

import android.content.Context;
import android.content.res.Resources;

import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.util.concurrent.TimeUnit;

import okhttp3.JavaNetCookieJar;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class HttpClientHolder {
    private static HttpClientHolder instance = new HttpClientHolder();
    private OkHttpClient okHttpClient;
    public static HttpClientHolder instance(){
        return instance;
    }

    public OkHttpClient getHttpClient(Context context) {
        CookieHandler cookieHandler = new CookieManager(
                new PersistentCookieStore(context), CookiePolicy.ACCEPT_ALL
        );

        okHttpClient = new OkHttpClient.Builder().addInterceptor(chain -> {

            Request original = chain.request();

            Request request = original.newBuilder()
                    .header("app-name", "com.charles.supershot")
                    .header("HTTP_ACCEPT_LANGUAGE", Resources.getSystem().getConfiguration().locale.getLanguage())
                    .header("Content-Type", "application/json")
                    .method(original.method(), original.body())
                    .build();

            return chain.proceed(request);
        })
                .cookieJar(new JavaNetCookieJar(cookieHandler))
                //.addInterceptor(new AddCookiesInterceptor())
                //.addInterceptor(new ReceivedCookiesInterceptor())
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .build();
        return okHttpClient;
    }
    private HttpClientHolder(){}
}
