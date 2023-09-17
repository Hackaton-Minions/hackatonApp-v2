package com.example.edusphere.feature.teachers.presentation;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.edusphere.data.repository.TeachersRepository;
import com.example.edusphere.domain.model.teachers.Teacher2;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeacherViewModel extends ViewModel {
    private MutableLiveData<List<Teacher2>> _teachers = new MutableLiveData<>();
    public LiveData<List<Teacher2>> teachers = _teachers;

    public void load_teachers_parent(Integer parent_id){
        TeachersRepository.getTeachersByParent(parent_id).enqueue(new Callback<List<Teacher2>>() {
            @Override
            public void onResponse(Call<List<Teacher2>> call, Response<List<Teacher2>> response) {
                _teachers.setValue(response.body());
                System.out.println(response.body());
            }

            @Override
            public void onFailure(Call<List<Teacher2>> call, Throwable t) {

            }
        });
    }
    public void load_teachers_student(Integer student_id){
        TeachersRepository.getTeachersByStudent(student_id).enqueue(new Callback<List<Teacher2>>() {
            @Override
            public void onResponse(Call<List<Teacher2>> call, Response<List<Teacher2>> response) {
                _teachers.setValue(response.body());
                System.out.println(response.body());
            }

            @Override
            public void onFailure(Call<List<Teacher2>> call, Throwable t) {

            }
        });
    }
}
