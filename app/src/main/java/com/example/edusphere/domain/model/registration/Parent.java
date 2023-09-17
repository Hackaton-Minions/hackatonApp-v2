package com.example.edusphere.domain.model.registration;

public class Parent {
    private String name;
    private String login;
    private String password;

    public Parent(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }
}
