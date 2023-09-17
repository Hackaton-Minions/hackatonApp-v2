package com.example.edusphere.feature.login.presentation;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.edusphere.data.repository.LoginRepository;
import com.example.edusphere.domain.model.ResponseEntity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginViewModel extends ViewModel {
    private MutableLiveData<ResponseEntity> _entity = new MutableLiveData<>();
    public LiveData<ResponseEntity> entity = _entity;

    public void authorize_person(String login, String password){
        LoginRepository.authorize(login, password).enqueue(new Callback<ResponseEntity>() {
            @Override
            public void onResponse(Call<ResponseEntity> call, Response<ResponseEntity> response) {
                if(response.code() == 200){
                    _entity.setValue(response.body());
                }else{
                    _entity.setValue(new ResponseEntity(-1, "-", "-"));
                }
            }

            @Override
            public void onFailure(Call<ResponseEntity> call, Throwable t) {

            }
        });
    }
}
