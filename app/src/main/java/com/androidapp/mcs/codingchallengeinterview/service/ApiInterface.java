package com.androidapp.mcs.codingchallengeinterview.service;

import com.androidapp.mcs.codingchallengeinterview.model.UserList;
import com.androidapp.mcs.codingchallengeinterview.model.contacts;

import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface ApiInterface {

    String BASE_URL ="https://api.androidhive.info/";

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @GET("contacts/")
    Call<UserList> getContact();
}
