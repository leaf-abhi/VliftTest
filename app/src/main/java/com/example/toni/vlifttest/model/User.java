package com.example.toni.vlifttest.model;

public class User {
    private String name;
    private String email;
    private String phoneNo;
    private String password;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getPassword() {
        return password;
    }

    public static class Builder {
        private String name;
        private String email;
        private String phoneNo;
        private String password;

        public Builder() {

        }

        public User build(){
            User user = new User();
            user.name = name;
            user.email = email;
            user.phoneNo = phoneNo;
            user.password = password;

            return user;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPhoneNo(String phoneNo) {
            this.phoneNo = phoneNo;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }
    }
}
