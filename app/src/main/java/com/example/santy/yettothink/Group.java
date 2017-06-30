package com.example.santy.yettothink;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by santy on 7/1/17.
 */

public class Group {
    List<AccountUser> users;
    String groupName;
    public Group(){
        users=new ArrayList<>();
    }
    public void appendtToGroup(AccountUser user){
        users.add(user);
    }
    public List<AccountUser> returnUserList(){
        return users;
    }
    public String getGroupName(){
        return  groupName;
    }
}
