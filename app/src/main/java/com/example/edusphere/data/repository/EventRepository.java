package com.example.edusphere.data.repository;

import com.example.edusphere.data.api.events.EventApiService;
import com.example.edusphere.domain.model.events.MyEvent;

import java.util.List;

import retrofit2.Call;

public class EventRepository {
    public static Call<List<MyEvent>> getEventsByTeacherId(long id){
        return EventApiService.getInstance().getEventsByTeacherId(id);
    }
}
