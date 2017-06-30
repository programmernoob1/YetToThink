package com.example.santy.yettothink;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

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
 * Created by santy on 7/1/17.
 */

public class Tab2Groups extends android.support.v4.app.Fragment {
    private FirebaseDatabase database;
    private DatabaseReference reference;
    private GroupAdapter groupAdapter;
    private FirebaseAuth auth;
    private FirebaseUser user;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        database=FirebaseDatabase.getInstance();
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main2, container, false);
        final ListView listView=(ListView) rootView.findViewById(R.id.messageListView);
        final List<Group> groupList=new ArrayList<>();
        groupAdapter=new GroupAdapter(getActivity(),R.layout.emaillist,groupList);
        listView.setAdapter(groupAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent=new Intent(getActivity(),HomeActivity.class);
//                intent.putExtra("startid",user.getUid());
//                intent.putExtra("endid",groupList.get(position).getId());
//                startActivity(intent);

            }
        });
        reference=database.getReference().child("groups");
        reference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Group group=(Group)dataSnapshot.getValue(Group.class);
                groupAdapter.add(group);
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
