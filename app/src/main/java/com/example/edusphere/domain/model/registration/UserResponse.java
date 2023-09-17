package com.example.edusphere.domain.model.registration;

public class UserResponse {
    private long id;
    private String name;
    private String login;

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public long getId() {
        return id;
    }
}
