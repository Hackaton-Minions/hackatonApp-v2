package com.example.edusphere.data.api.teachers;

import com.example.edusphere.domain.model.teachers.Teacher2;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TeachersApi {
    @GET("/teachers_by_parent/")
    Call<List<Teacher2>> getTeachersByParent(@Query("parent_id") Integer parent_id);

    @GET("/teachers_by_student/")
    Call<List<Teacher2>> getTeachersByStudent(@Query("student_id") Integer student_id);
}
