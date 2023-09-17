package com.example.edusphere.domain.model.registration;

import java.util.List;

public class Teacher {
    private String name;
    private String login;
    private String password;
    private List<String> groups;

    public Teacher(String name, String login, String password, List<String> groups) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.groups = groups;
    }
}
