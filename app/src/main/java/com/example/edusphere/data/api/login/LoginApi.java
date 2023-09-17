package com.example.edusphere.data.api.login;

import com.example.edusphere.domain.model.ResponseEntity;
import com.example.edusphere.domain.model.registration.Parent;
import com.example.edusphere.domain.model.registration.Student;
import com.example.edusphere.domain.model.registration.Teacher;
import com.example.edusphere.domain.model.registration.UserResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface LoginApi {
    @POST("/authorization/")
    Call<ResponseEntity> authorize(@Query("login") String login, @Query("password") String password);
}
