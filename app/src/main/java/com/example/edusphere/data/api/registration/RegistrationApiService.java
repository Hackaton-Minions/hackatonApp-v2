package com.example.edusphere.data.api.registration;

import com.example.edusphere.data.api.RetrofitService;

public class RegistrationApiService {

    private static RegistrationApi registrationApi;

    private static RegistrationApi create(){
        return RetrofitService.getInstance().create(RegistrationApi.class);
    }

    public static RegistrationApi getInstance(){
        if(registrationApi == null) registrationApi = create();
        return registrationApi;
    }
}
