package com.example.edusphere.data.api.events;


import com.example.edusphere.domain.model.events.MyEvent;
import com.example.edusphere.domain.model.events.Sign;

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

    @GET("/get_event_by_user/")
    Call<List<Sign>> getEventByUser(@Query("user_type") String userType, @Query("user_id") long userId);
}
