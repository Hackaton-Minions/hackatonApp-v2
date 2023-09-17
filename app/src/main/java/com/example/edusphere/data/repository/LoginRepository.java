package com.example.edusphere.data.repository;

import com.example.edusphere.data.api.login.LoginApiService;
import com.example.edusphere.domain.model.ResponseEntity;

import retrofit2.Call;

public class LoginRepository {
    public static Call<ResponseEntity> authorize(String login, String password){
        return LoginApiService.getInstance().authorize(login, password);
    }
}
