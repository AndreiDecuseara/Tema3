package com.example.tema3;

import java.util.Objects;

public class User {
    public int id;
    public String name;
    public String username;
    public String email;

    public User(int id, String name, String username ,String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
