package com.example.edusphere.data.api.events;


import com.example.edusphere.domain.model.events.MyEvent;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface EventApi {
    @GET("/get_event/")
    Call<List<MyEvent>> getEventsByTeacherId(
            @Query("teacher_id")
            long id
    );

}
