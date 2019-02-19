package com.androidapp.mcs.codingchallengeinterview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.androidapp.mcs.codingchallengeinterview.model.UserList;
import com.androidapp.mcs.codingchallengeinterview.model.contacts;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private UserList contactList;
    private Context context;

    MainAdapter(UserList contactList, Context context) {
        this.contactList = contactList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.main_list_item,viewGroup,false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        contacts mContact = contactList.getContacts().get(i);
        viewHolder.name.setText(mContact.getName());
        viewHolder.email.setText(mContact.getEmail());
        viewHolder.address.setText(mContact.getAddress());
        viewHolder.gender.setText(mContact.getGender());
        viewHolder.mobile.setText(mContact.getPhone().getMobile());
        viewHolder.home.setText(mContact.getPhone().getHome());
        viewHolder.office.setText(mContact.getPhone().getOffice());
    }

    @Override
    public int getItemCount() {
        return contactList.getContacts().size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView email;
        TextView address;
        TextView gender;
        TextView mobile;
        TextView home;
        TextView office;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            email = itemView.findViewById(R.id.email);
            address = itemView.findViewById(R.id.address);
            gender = itemView.findViewById(R.id.gender);
            mobile = itemView.findViewById(R.id.mobile);
            home = itemView.findViewById(R.id.home);
            office = itemView.findViewById(R.id.office);
        }
    }
}
