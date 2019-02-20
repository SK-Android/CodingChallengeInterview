package com.androidapp.mcs.codingchallengeinterview.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.TextView;

import com.androidapp.mcs.codingchallengeinterview.model.UserList;
import com.androidapp.mcs.codingchallengeinterview.model.contacts;
import com.androidapp.mcs.codingchallengeinterview.service.ApiInterface;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public class MainViewModel extends AndroidViewModel {

    // Hashmap for ListView
    ArrayList<HashMap<String, String>> contactList;


    public MainViewModel(@NonNull Application application) {
        super(application);
        contactList = new ArrayList<HashMap<String, String>>();

        getData();
    }

   public ArrayList<HashMap<String, String>> getContactList(){

        return contactList;
    }

    private void getData() {
        ApiInterface apiInterface = ApiInterface.retrofit.create(ApiInterface.class);
        Call<JSONObject> call = apiInterface.getContact();
        call.enqueue(new Callback<JSONObject>() {
            @Override
            public void onResponse(Call<JSONObject> call, Response<JSONObject> response) {
                if (response.isSuccessful()) {

                    try {

                        // Getting JSON Array node
                        JSONArray contacts = response.body().getJSONArray("contacts");

//                        int contactsSize = response.body().getContacts().size();
                        for(int i=0;i<contacts.length();i++) {

                            JSONObject c = contacts.getJSONObject(i);


                            String name =c.getString("name");
                            String address =c.getString("address");
                            String email = c.getString("email");
                            String gender = c.getString("gender");

                            // Phone node is JSON Object
                            JSONObject phone = c.getJSONObject("phone");
                            String mobile = phone.getString("mobile");
                            String home = phone.getString("home");
                            String office = phone.getString("office");


                            // tmp hashmap for single contact
                            HashMap<String, String> contact = new HashMap<String, String>();

                            // adding each child node to HashMap key => value

                            contact.put("name", name);
                            contact.put("email", email);
                            contact.put("address", address);
                            contact.put("gender", gender);
                            contact.put("home", home);
                            contact.put("mobile", mobile);

                            // adding contact to contact list
                            contactList.add(contact);


                        }


                }
                catch (JSONException e){
                        e.printStackTrace();
                }
            }
                }


            @Override
            public void onFailure(Call<JSONObject> call, Throwable t) {

                Log.i(TAG, "onFailure: MainViewModel ");
            }
        });

    }

}
