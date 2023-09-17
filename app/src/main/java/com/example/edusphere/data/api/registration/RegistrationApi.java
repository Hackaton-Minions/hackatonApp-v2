package com.example.edusphere.data.api.registration;

import com.example.edusphere.domain.model.registration.Parent;
import com.example.edusphere.domain.model.registration.Student;
import com.example.edusphere.domain.model.registration.Teacher;
import com.example.edusphere.domain.model.registration.UserResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RegistrationApi {
    @POST("/register/student/")
    Call<UserResponse> registerStudent(@Body Student student, @Query("parent_login") String parent_login, @Query("group") String group);

    @Headers({
            "Accept: application/json",
            "Content-type: application/json"
    })
    @POST("/register/parent/")
    Call<UserResponse> registerParent(@Body Parent parent);

    @Headers({
            "Accept: application/json",
            "Content-type: application/json"
    })
    @POST("/register/teacher/")
    Call<UserResponse> registerTeacher(@Body Teacher teacher, @Query("group") String group);
}
