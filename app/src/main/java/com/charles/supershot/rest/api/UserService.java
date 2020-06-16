package com.charles.supershot.rest.api;

import com.charles.supershot.rest.model.AddFriend;
import com.charles.supershot.rest.model.UserInfo;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

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

    /**
     *
     * 친구 리스트 조회
     *
     */
    @GET("friends")
    Call<AddFriend> friendList(
            @Header("Authorization") String authorization
            ,@QueryMap Map<String, Object> reqData
    );
}
