package com.example.edusphere.data.repository;

import com.example.edusphere.data.api.teachers.TeachersApiService;
import com.example.edusphere.domain.model.teachers.Teacher2;

import java.util.List;

import retrofit2.Call;

public class TeachersRepository {
    public static Call<List<Teacher2>> getTeachersByParent(Integer parent_id){
        return TeachersApiService.getInstance().getTeachersByParent(parent_id);
    }
    public static Call<List<Teacher2>> getTeachersByStudent(Integer student_id){
        return TeachersApiService.getInstance().getTeachersByStudent(student_id);
    }
}
