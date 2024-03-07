package com.example.odercoffee.Class;

import android.content.Context;
import android.content.SharedPreferences;

public class DuyTriDangNhap {

    private static final String PREF_NAME = "MyAppPrefs";
    private static final String KEY_USERNAME = "email";
    private static final String KEY_LOGGED_IN = "loggedIn";

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    public DuyTriDangNhap(Context context) {
        preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    public void setLoggedIn(boolean loggedIn) {
        editor.putBoolean(KEY_LOGGED_IN, loggedIn);
        editor.apply();
    }

    public boolean isLoggedIn() {
        return preferences.getBoolean(KEY_LOGGED_IN, false);
    }

    public void setEmail(String email) {
        editor.putString(KEY_USERNAME, email);
        editor.apply();
    }

    public String getEmail() {
        return preferences.getString(KEY_USERNAME, "");
    }

    public void clearSession() {
        editor.remove(KEY_USERNAME);
        editor.remove(KEY_LOGGED_IN);
        editor.apply();
    }

}

