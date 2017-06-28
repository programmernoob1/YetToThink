package com.example.santy.yettothink;

/**
 * Created by santy on 6/28/17.
 */

public class AccountUser {
    private String email;
    private String id;
    public AccountUser(String email, String id){
        this.email=email;
        this.id=id;
    }
    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
