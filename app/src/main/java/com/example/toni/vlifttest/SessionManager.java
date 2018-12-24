package com.example.toni.vlifttest;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.toni.vlifttest.database.Database;
import com.example.toni.vlifttest.model.User;

public class SessionManager {
    private static final String SESSION_DATA_PREFERENCE_FILE_KEY = "com.example.toni.session_preference_file_key" ;
    private static final String SESSION_ALIVE_KEY = "session alive key";
    private static final String LOGGED_IN_USER_KEY = "logged in user key";
    private static SessionManager sessionManager;
    private boolean sessionAlive;
    private String loggedInUserId;
    private User loggedInUser;
    private SharedPreferences preferences;
    private SessionManager() {
        //private constructor
    }

    public static SessionManager getInstance() {
        if(sessionManager == null)
            throw new SessionManagerNotInitializedException("Session manager not intialized - " +
                    "Call SessionManager.init(Context) to initialize");
        return sessionManager;
    }

    public static void init(Context context) {
        if(sessionManager == null)
            sessionManager = new SessionManager();
        else
            return;

        sessionManager.preferences = context.getSharedPreferences(SESSION_DATA_PREFERENCE_FILE_KEY,
                Context.MODE_PRIVATE);
        sessionManager.sessionAlive = sessionManager.preferences.getBoolean(SESSION_ALIVE_KEY,false);
        if(sessionManager.isSessionAlive()) { // if session was previously alive
            sessionManager.loggedInUserId = sessionManager.preferences.getString(LOGGED_IN_USER_KEY,null);
        }

        if(sessionManager.loggedInUserId!=null) { //fetch details from the database
            //TODO: Add actual code to access database here
            sessionManager.loggedInUser = Database.getInstance().getUser(sessionManager.loggedInUserId);
        }

    }

    public boolean isSessionAlive() {
        return sessionAlive;
    }

    public boolean isSharedPreferencesSet() {
        return preferences!=null;
    }
    public boolean createSession(User user) {
        if(!isSharedPreferencesSet())
            throw new SessionManagerNotInitializedException("SharedPreference must be set for the SessionManger" +
                    "to function");

        if(isSessionAlive())
            return false;

        //create the memeber session
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(LOGGED_IN_USER_KEY,user.getEmail());
        editor.putBoolean(SESSION_ALIVE_KEY,true);
        editor.commit();

        loggedInUser = user;
        this.loggedInUserId = user.getEmail();
        sessionAlive = true;
        return true;
    }

    public boolean destroySession() {
        if (!isSharedPreferencesSet())
            throw new SessionManagerNotInitializedException("SharedPreference must be set for the SessionManger" +
                    "to function");
        if (!isSessionAlive())
            return false;

        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.commit();

        loggedInUserId = null;
        loggedInUser = null;
        return true;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }
}
