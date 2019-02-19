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
        UserList mContacts = mainViewModel.getContacts();
        if(mContacts!=null){
            MainAdapter adapter = new MainAdapter(mContacts,this);
            recyclerView.setAdapter(adapter);
        }


    }
}
