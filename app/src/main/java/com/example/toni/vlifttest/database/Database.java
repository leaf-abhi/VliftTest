package com.example.toni.vlifttest.database;

import com.example.toni.vlifttest.model.User;

import java.util.ArrayList;
import java.util.List;

//Dummy Database
public class Database {
    private static List<User> users = new ArrayList<>();
    private static Database database;
    static {
        users.add(new User.Builder()
                    .setName("Abhishek")
                    .setEmail("somemail@domain.com")
                    .setPassword("12345678")
                    .setPhoneNo("1234567890")
                    .build());
    }

    private Database() {

    }

    public static Database getInstance() {
        if(database == null)
            database = new Database();
        return database;
    }

    public User getUser(String email) {
        for(User user:users) {
            if(user.getEmail().equalsIgnoreCase(email))
                return user;
        }

        return null;
    }
}
