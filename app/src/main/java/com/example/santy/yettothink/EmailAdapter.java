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
 * Created by santy on 6/28/17.
 */

public class EmailAdapter extends ArrayAdapter<AccountUser> {
    public EmailAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<AccountUser> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView==null){
            convertView=((Activity)getContext()).getLayoutInflater().inflate(R.layout.emaillist,parent,false);
        }
        TextView textView=(TextView)convertView.findViewById(R.id.email);
        AccountUser user=getItem(position);
        textView.setText(user.getEmail());
        return convertView;
    }

}
