package com.example.santy.yettothink;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by santy on 6/27/17.
 */

public class Tab1Chats extends android.support.v4.app.Fragment{
    private FirebaseDatabase database;
    private DatabaseReference reference;
    private EmailAdapter emailAdapter;
    private FirebaseAuth auth;
    private FirebaseUser user;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        auth=FirebaseAuth.getInstance();
        user=auth.getCurrentUser();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_main2, container, false);
        final ListView listView=(ListView) rootView.findViewById(R.id.messageListView);
        final List<AccountUser> userList=new ArrayList<>();
        emailAdapter=new EmailAdapter(getActivity(),R.layout.emaillist,userList);
        listView.setAdapter(emailAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity(),HomeActivity.class);
                intent.putExtra("startid",user.getUid());
                intent.putExtra("endid",userList.get(position).getId());
                startActivity(intent);
            }
        });
        database=FirebaseDatabase.getInstance();
        reference=database.getReference().child("users");
        reference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                AccountUser accountUser=(AccountUser)dataSnapshot.getValue(AccountUser.class);
                emailAdapter.add(accountUser);
            }
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
            }
            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }
            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return rootView;
    }
}
