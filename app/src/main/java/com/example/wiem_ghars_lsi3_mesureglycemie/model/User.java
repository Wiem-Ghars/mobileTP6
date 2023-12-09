package com.example.wiem_ghars_lsi3_mesureglycemie.model;

import android.widget.EditText;

public class User {
    private String UserName;
    private String password;

    public User(String userName, String password) {
        UserName = userName;
        this.password = password;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
