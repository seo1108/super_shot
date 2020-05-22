package com.charles.supershot.rest.api;

import com.google.gson.JsonObject;

import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.QueryMap;

public interface AuthService {
    /**
     *
     * 아이디 중복 체크
     *
     */
    @GET("validid")
    Call<JsonObject> validid(
            @QueryMap Map<String, Object> reqData
    );


    /**
     *
     * 로그인
     *
     */
    @Multipart
    @FormUrlEncoded
    @POST("signup")
    Call<JsonObject> signup(
            @Part MultipartBody.Part file,
            @FieldMap Map<String, Object> reqData);
}
