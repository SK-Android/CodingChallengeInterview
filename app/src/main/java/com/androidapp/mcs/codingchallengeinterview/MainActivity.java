package com.androidapp.mcs.codingchallengeinterview;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.androidapp.mcs.codingchallengeinterview.model.UserList;
import com.androidapp.mcs.codingchallengeinterview.model.contacts;
import com.androidapp.mcs.codingchallengeinterview.viewmodel.MainViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.main_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        MainViewModel mainViewModel = ViewModelProviders.of(this)
                .get(MainViewModel.class);
        UserList userList = mainViewModel.getContacts();
        if(userList!=null){
            List<contacts> mContacts = userList.getContacts();
            MainAdapter adapter = new MainAdapter(mContacts,this);
            recyclerView.setAdapter(adapter);
        }


    }
}

//    JSONObject jsonObject = new JSONObject(readTwitterFeed);
//
//contacts = jsonObject.getJSONArray("contacts");
//
//public void onResponse(JSONObject response) {
//
//        try {
//
//        JSONArray JsonRes = response.getJSONArray("contacts");
//
//        for(int i =0; i <JsonRes.length(); i++){
//
//        JSONObject objectoContact = JsonRes.getJSONObject(i);
//
//        String name = objectoContact.getString("name");
//
//        String presentValStr = mTextView.getText().toString();
//
//        presentValStr += "\n" + name;
//
//        mTextView.setText(presentValStr);
//
//        Toast.makeText(MainActivity.this, "nombres: "+name, Toast.LENGTH_SHORT).show();
//
//
//
//        }