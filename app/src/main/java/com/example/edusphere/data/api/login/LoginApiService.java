package com.example.edusphere.data.api.login;

import com.example.edusphere.data.api.RetrofitService;

public class LoginApiService {

    private static LoginApi loginApi;

    private static LoginApi create(){
        return RetrofitService.getInstance().create(LoginApi.class);
    }

    public static LoginApi getInstance(){
        if(loginApi == null) loginApi = create();
        return loginApi;
    }
}
