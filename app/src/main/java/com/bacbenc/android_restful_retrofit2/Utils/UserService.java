package com.bacbenc.android_restful_retrofit2.Utils;

import com.bacbenc.android_restful_retrofit2.model.UserModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface UserService {

    @GET("users/")
    Call<List<UserModel>> getUsers(); //Call<T> = An invocation of a Retrofit method that sends a request to a webserver and returns a response

    @POST("add/")
    Call<UserModel> addUser(@Body UserModel userModel);

    @PUT("update/{id}")
    Call<UserModel> updateUser(@Path("id") int id, @Body UserModel userModel);

    @DELETE("delete/{id}")
    Call<UserModel> deleteUser(@Path("id") int id);
}
