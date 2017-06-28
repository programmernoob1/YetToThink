package com.example.santy.yettothink;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by santy on 6/27/17.
 */

public class Tab1Chats extends android.support.v4.app.Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main2, container, false);
        ListView listView=(ListView) rootView.findViewById(R.id.messageListView);
        final List<AccountUser> userList=new ArrayList<>();
        EmailAdapter emailAdapter=new EmailAdapter(getActivity(),R.layout.emaillist,userList);
        listView.setAdapter(emailAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), userList.get(position).getEmail(), Toast.LENGTH_SHORT).show();
            }
        });
        return rootView;
    }
}
