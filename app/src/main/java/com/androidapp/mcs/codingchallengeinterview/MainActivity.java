package com.androidapp.mcs.codingchallengeinterview;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.androidapp.mcs.codingchallengeinterview.model.UserList;
import com.androidapp.mcs.codingchallengeinterview.model.contacts;
import com.androidapp.mcs.codingchallengeinterview.viewmodel.MainViewModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        RecyclerView recyclerView = findViewById(R.id.main_rv);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        ListView listView = findViewById(R.id.main_list);

        MainViewModel mainViewModel = ViewModelProviders.of(this)
                .get(MainViewModel.class);

        ArrayList<HashMap<String, String>> contactsList = mainViewModel.getContactList();

        /**
         * Updating parsed JSON data into ListView
         * */
        ListAdapter adapter = new SimpleAdapter(
                MainActivity.this, contactsList,
                R.layout.main_list_item, new String[] { "name", "email","address","gender","home",
                "mobile","office" }, new int[] { R.id.name,
                R.id.email,R.id.address,R.id.gender,R.id.home, R.id.mobile ,R.id.office});

       listView.setAdapter(adapter);


//        if(contactsList!=null){
//            MainAdapter adapter = new MainAdapter(contactsList,this);
//            recyclerView.setAdapter(adapter);
//        }


    }
}