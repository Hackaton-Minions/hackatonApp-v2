package com.example.edusphere.domain.model;

public class ResponseEntity {
    private long id;
    private String user_type;
    private String name_user;

    public ResponseEntity(long id, String userType, String nameUser) {
        this.id = id;
        user_type = userType;
        name_user = nameUser;
    }

    public long getId() {
        return id;
    }

    public String getUser_type() {
        return user_type;
    }

    public String getName_user() {
        return name_user;
    }
}
