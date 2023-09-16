package com.example.edusphere.data.repository;

import com.example.edusphere.data.api.events.EventApiService;
import com.example.edusphere.data.api.registration.RegistrationApiService;
import com.example.edusphere.domain.model.events.MyEvent;
import com.example.edusphere.domain.model.registration.Parent;
import com.example.edusphere.domain.model.registration.Student;
import com.example.edusphere.domain.model.registration.Teacher;
import com.example.edusphere.domain.model.registration.UserResponse;

import java.util.List;

import retrofit2.Call;

public class RegistrationRepository {
    public static Call<UserResponse> registerStudent(Student student){
        return RegistrationApiService.getInstance().registerStudent(student);
    }
    public static Call<UserResponse> registerParent(Parent parent){
        return RegistrationApiService.getInstance().registerParent(parent);
    }
    public static Call<UserResponse> registerTeacher(Teacher teacher) {
        return RegistrationApiService.getInstance().registerTeacher(teacher);
    }
}
