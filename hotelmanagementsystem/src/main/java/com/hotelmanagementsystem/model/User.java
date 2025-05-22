package com.hotelmanagementsystem.model;

public abstract class User {
    public String userId;
    public String name;
    public String email;

    public User(String userId, String name, String email){
        this.userId = userId;
        this.name = name;
        this.email = email;
    }

    public String getUserId(){ return userId;}
    public String getName(){ return name;}
    public String getEmail(){ return email;}


}
