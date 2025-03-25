package com.example.recipeapp;

public class UserBase {
    // having this will set the field for database for storing user data
    private String fullname, email;


    public UserBase()
    {

    }

    public UserBase(String fullname, String email)
    {
        this.fullname = fullname;
        this.email = email;

    }

    public String getEmail() {
        return email;
    }

    public String getFullname() {
        return fullname;
    }
}


