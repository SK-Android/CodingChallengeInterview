package com.androidapp.mcs.codingchallengeinterview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.androidapp.mcs.codingchallengeinterview.model.UserList;
import com.androidapp.mcs.codingchallengeinterview.service.ApiInterface;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity {

    String responseString = "";
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         textView = findViewById(R.id.textView);
        getData();
    }

    private void getData() {
        ApiInterface apiInterface = ApiInterface.retrofit.create(ApiInterface.class);
        Call<UserList> call = apiInterface.getContact();
        call.enqueue(new Callback<UserList>() {
            @Override
            public void onResponse(Call<UserList> call, Response<UserList> response) {
                if (response.isSuccessful()) {

                    int size = response.body().getContacts().size();

                    for (int i = 0; i < size; i++) {
                        String name = response.body().getContacts().get(i).getName();
                        String email = response.body().getContacts().get(i).getEmail();
                        String home = response.body().getContacts().get(i).getPhone().getHome();
                        String mobile = response.body().getContacts().get(i).getPhone().getMobile();

                        responseString += "Name: " + name + "\n\n";
                        responseString += "Email: " + email + "\n\n";
                        responseString += "Home: " + home + "\n\n";
                        responseString += "Mobile: " + mobile + "\n\n\n\n";

                        textView.setText(responseString);
                    }
                }
            }


            @Override
            public void onFailure(Call<UserList> call, Throwable t) {

                Log.i(TAG, "onFailure: MainViewModel ");
            }
        });

    }
}