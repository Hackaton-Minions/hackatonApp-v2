package com.example.edusphere.feature.registration.presentation;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.edusphere.data.repository.RegistrationRepository;
import com.example.edusphere.domain.model.registration.Parent;
import com.example.edusphere.domain.model.registration.Student;
import com.example.edusphere.domain.model.registration.Teacher;
import com.example.edusphere.domain.model.registration.UserResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrationViewModel extends ViewModel {
    private MutableLiveData<RegistrationStatus> _status = new MutableLiveData<>();
    public LiveData<RegistrationStatus> status = _status;

    private MutableLiveData<UserResponse> _user = new MutableLiveData<>();
    public LiveData<UserResponse> user = _user;


    public void register_student(Student student){
        _status.setValue(RegistrationStatus.LOADING);
        RegistrationRepository.registerStudent(student).enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                _status.setValue(RegistrationStatus.LOADED);
                _user.setValue(response.body());
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                _status.setValue(RegistrationStatus.FAILURE);
                t.printStackTrace();
            }
        });
    }
    public void register_parent(Parent parent){
        _status.setValue(RegistrationStatus.LOADING);
        RegistrationRepository.registerParent(parent).enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                _status.setValue(RegistrationStatus.LOADED);
                _user.setValue(response.body());
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                _status.setValue(RegistrationStatus.FAILURE);
                t.printStackTrace();
            }
        });
    }
    public void register_teacher(Teacher teacher){
        _status.setValue(RegistrationStatus.LOADING);
        RegistrationRepository.registerTeacher(teacher).enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                _status.setValue(RegistrationStatus.LOADED);
                _user.setValue(response.body());
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                _status.setValue(RegistrationStatus.FAILURE);
                t.printStackTrace();
            }
        });
    }
}
