package com.example.edusphere.data.api.registration;

import com.example.edusphere.domain.model.registration.Parent;
import com.example.edusphere.domain.model.registration.Student;
import com.example.edusphere.domain.model.registration.Teacher;
import com.example.edusphere.domain.model.registration.UserResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
public interface RegistrationApi {
    @POST("/register/student")
    Call<UserResponse> registerStudent(@Body Student student);

    @POST("/register/parent")
    Call<UserResponse> registerParent(@Body Parent parent);

    @POST("/register/teacher")
    Call<UserResponse> registerTeacher(@Body Teacher teacher);
}
