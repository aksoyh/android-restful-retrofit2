package com.bacbenc.android_restful_retrofit2.Utils;

public class ApiUtils {
    private ApiUtils() {
    }

    public static final String API_URL = "https://arsr.herokuapp.com/api/";

    public static UserService getuserService(){
        return  RetrofitClient.getRetrofitClient(API_URL).create(UserService.class);
    }
}
