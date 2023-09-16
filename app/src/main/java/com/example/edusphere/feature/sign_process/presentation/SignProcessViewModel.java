package com.example.edusphere.feature.sign_process.presentation;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.edusphere.data.repository.EventRepository;
import com.example.edusphere.domain.model.events.MyEvent;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignProcessViewModel extends ViewModel {

    private MutableLiveData<List<MyEvent>> _events = new MutableLiveData<>();
    public LiveData<List<MyEvent>> events = _events;

    private MutableLiveData<SignProcessStatus> _status = new MutableLiveData<>();
    public LiveData<SignProcessStatus> status = _status;


    public void load_events(long id){
        _status.setValue(SignProcessStatus.LOADING);
        EventRepository.getEventsByTeacherId(id).enqueue(new Callback<List<MyEvent>>() {
            @Override
            public void onResponse(Call<List<MyEvent>> call, Response<List<MyEvent>> response) {
                _status.setValue(SignProcessStatus.LOADED);
                _events.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<MyEvent>> call, Throwable t) {
                _status.setValue(SignProcessStatus.FAILURE);
                t.printStackTrace();
            }
        });
    }
}
