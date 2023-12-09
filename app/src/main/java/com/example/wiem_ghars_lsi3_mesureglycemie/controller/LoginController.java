package com.example.wiem_ghars_lsi3_mesureglycemie.controller;


import android.content.Context;
import android.content.SharedPreferences;

import com.example.wiem_ghars_lsi3_mesureglycemie.model.User;

public class LoginController {
    private static final String SHERED_PREFS= "sharedPrefs";

    private static User user;
    private static LoginController instance=null;
    private LoginController()
    {
        super();
    }
    public static LoginController getInstance(Context context)
    {
        if (LoginController.instance==null)
            instance =new LoginController();
        recapUser(context);
        return LoginController.instance;
    }
    private static void recapUser(Context context)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHERED_PREFS,Context.MODE_PRIVATE);
        //ken mal9ach username msajel yraja3 chaine vide f west utilisateur w password
        String username =sharedPreferences.getString("username","");
        String password = sharedPreferences.getString("password","");
        user =new User(username,password);


    }
    public void createUser (String username, String password, Context context)
    { //creation  de l'utilisateur
        user = new User(username,password);
        // sauvegarde (persistance ) de l'utilisateur
        SharedPreferences sharedPreferences= context.getSharedPreferences(SHERED_PREFS,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= sharedPreferences.edit();
        editor.putString("userName",username);
        //mech b 4aroura nafs el esm houwa nafs el var
        editor.putString("password",password);
        editor.apply();


    }
    public String getUserName() {
        return user.getUserName();
    }
    public String getPassword() {
        return user.getPassword();
    }
}

