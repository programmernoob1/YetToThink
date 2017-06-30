package com.example.santy.yettothink;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by santy on 7/1/17.
 */

public class GroupAdapter extends ArrayAdapter<Group> {
    public GroupAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Group> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView==null){
            convertView=((Activity)getContext()).getLayoutInflater().inflate(R.layout.emaillist,parent,false);
        }
        TextView textView=(TextView)convertView.findViewById(R.id.email);
        Group group=getItem(position);
        textView.setText(group.getGroupName());
        return convertView;
    }


}
