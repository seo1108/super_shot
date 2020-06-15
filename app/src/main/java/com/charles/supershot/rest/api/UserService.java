package com.charles.supershot.rest.api;

import com.charles.supershot.rest.model.UserInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface UserService {
    /**
     *
     * 회원정보
     *
     */
    @GET("user/{userSeq}")
    Call<UserInfo> userInfo(
            @Header("Authorization") String authorization
            ,@Path("userSeq") String userSeq
    );
}
