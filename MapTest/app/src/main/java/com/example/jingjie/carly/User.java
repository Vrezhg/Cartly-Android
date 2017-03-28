package com.example.jingjie.carly;

/**
 * Created by Jingjie on 3/7/2017.
 */

public class User
{
    public String email;
    public String isDriver;
    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String isDriver, String email) {
        this.email = email;
        this.isDriver=isDriver;
    }
}
