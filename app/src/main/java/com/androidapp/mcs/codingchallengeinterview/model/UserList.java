package com.androidapp.mcs.codingchallengeinterview.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserList {

    @SerializedName("contacts")
    @Expose
    private List<contacts> contacts = null;

    public List<contacts> getContacts() {
        return contacts;
    }

    public void setContacts(List<contacts> contacts) {
        this.contacts = contacts;
    }

}
