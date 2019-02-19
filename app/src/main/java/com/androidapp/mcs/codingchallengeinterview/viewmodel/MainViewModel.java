package com.androidapp.mcs.codingchallengeinterview.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;
import android.util.Log;

import com.androidapp.mcs.codingchallengeinterview.model.UserList;
import com.androidapp.mcs.codingchallengeinterview.model.contacts;
import com.androidapp.mcs.codingchallengeinterview.service.ApiInterface;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public class MainViewModel extends AndroidViewModel {

    private UserList contact;


    public MainViewModel(@NonNull Application application) {
        super(application);
        getData();
    }

   public UserList getContacts(){
        return contact;
    }

    private void getData() {
        ApiInterface apiInterface = ApiInterface.retrofit.create(ApiInterface.class);
        Call<UserList> call = apiInterface.getContacts();
        call.enqueue(new Callback<UserList>() {
            @Override
            public void onResponse(Call<UserList> call, Response<UserList> response) {
                if(response.isSuccessful())
                {
                    contact = response.body();

                }
            }

            @Override
            public void onFailure(Call<UserList> call, Throwable t) {

                Log.i(TAG, "onFailure: MainViewModel ");
            }
        });

    }

}
