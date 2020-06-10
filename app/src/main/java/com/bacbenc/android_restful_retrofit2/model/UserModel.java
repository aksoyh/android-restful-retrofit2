package com.bacbenc.android_restful_retrofit2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserModel {

    @SerializedName("id") //@SerializedName changes the automated matching to and from the JSON
    @Expose //An annotation that indicates this member should be exposed for JSON serialization or deserialization
    private int id;

    @SerializedName("name")
    @Expose
    private String name;

    public UserModel(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public UserModel() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
