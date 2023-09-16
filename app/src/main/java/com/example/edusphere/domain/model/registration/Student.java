package com.example.edusphere.domain.model.registration;

public class Student {
    private String login;
    private String parent_login;
    private String group;
    private String name;
    private String password;
    public Student(String login, String password, String name){
        this.login = login;
        this.password = password;
        this.name = name;
    }
}
