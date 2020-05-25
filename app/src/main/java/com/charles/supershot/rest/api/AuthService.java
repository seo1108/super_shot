package com.charles.supershot.rest.api;

import com.charles.supershot.rest.model.Join;
import com.charles.supershot.rest.model.UserData;
import com.google.gson.JsonObject;

import java.util.Map;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
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
     * 회원가입
     *
     */
    @Multipart
    @POST("signup")
    Call<Join> signup(
            @Part MultipartBody.Part file,
            @QueryMap Map<String, Object> reqData);

    /**
     *
     * 소셜 로그인
     *
     */
    @FormUrlEncoded
    @POST("signinWithSNS")
    Call<UserData> signinWithSNS(
            @FieldMap Map<String, Object> reqData
    );

}
