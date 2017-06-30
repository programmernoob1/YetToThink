package com.example.santy.yettothink;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.ServerValue;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by santy on 6/29/17.
 */

public class Notification {

    String user_id;
    String message;
    String name;
    long timestamp;
    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name= name;
    }


    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public Notification(String userid,String message,String name) {
        setUser_id(userid);
        setMessage(message);
        setName(name);
    }
    public Notification(){}

}

