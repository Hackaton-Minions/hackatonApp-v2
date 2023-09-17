package com.example.edusphere.data.api.teachers;

import com.example.edusphere.data.api.RetrofitService;

public class TeachersApiService {

    private static TeachersApi teachersApi;

    private static TeachersApi create(){
        return RetrofitService.getInstance().create(TeachersApi.class);
    }

    public static TeachersApi getInstance(){
        if(teachersApi == null) teachersApi = create();
        return teachersApi;
    }
}
