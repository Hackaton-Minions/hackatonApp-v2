package com.example.edusphere.domain.model.registration;

import java.util.List;

public class Teacher {
    private String name;
    private String login;
    private String password;
    private String subject;

    public Teacher(String name, String login, String password, String subject) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.subject = subject;
    }
}
