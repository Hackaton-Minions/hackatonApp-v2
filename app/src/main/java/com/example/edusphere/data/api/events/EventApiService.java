package com.example.edusphere.data.api.events;

import com.example.edusphere.data.api.RetrofitService;

public class EventApiService {

    private static EventApi eventApi;

    private static EventApi create(){
        return RetrofitService.getInstance().create(EventApi.class);
    }

    public static EventApi getInstance(){
        if(eventApi == null) eventApi = create();
        return eventApi;
    }
}
