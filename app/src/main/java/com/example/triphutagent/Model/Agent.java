package com.example.triphutagent.Model;

public class Agent {
    private String Name;
    private String Password;

    public Agent() {

    }

    public Agent(String name, String password) {
        Name = name;
        Password = password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
