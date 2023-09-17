package com.example.edusphere.feature.sign.presentation;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.edusphere.data.repository.EventRepository;
import com.example.edusphere.domain.model.events.MyEvent;
import com.example.edusphere.domain.model.events.Sign;
import com.example.edusphere.feature.sign_process.presentation.SignProcessStatus;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignViewModel extends ViewModel {
    private MutableLiveData<List<Sign>> _signs = new MutableLiveData<>();
    public LiveData<List<Sign>> signs = _signs;

    private MutableLiveData<SignStatus> _status = new MutableLiveData<>();
    public LiveData<SignStatus> status = _status;


    public void load_data(long userId, String userType){
        _status.setValue(SignStatus.LOADING);
        EventRepository.getEventsByUser(userType, userId).enqueue(new Callback<List<Sign>>() {
            @Override
            public void onResponse(Call<List<Sign>> call, Response<List<Sign>> response) {
                _status.setValue(SignStatus.LOADED);
//                Log.d("TAGG", "omgg");
                if(response.isSuccessful()){
                    _signs.setValue(response.body());
                }else{
                    _signs.setValue(new ArrayList<Sign>());
                }
            }

            @Override
            public void onFailure(Call<List<Sign>> call, Throwable t) {

            }
        });
    }
}
