package com.sreeyainfotech.basicproject.networkCall;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


public interface ApiInterface {

    @FormUrlEncoded
    @POST("Photos/LogOn")
    Call<JsonObject> loginAction(@Field("UserId") String username,
                                 @Field("PWD") String password);   // user name-admin, password-test


}
