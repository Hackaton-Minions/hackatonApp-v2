package com.example.edusphere.feature.login.ui;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.edusphere.databinding.ActivityLoginBinding;


public class Login extends AppCompatActivity {
    private ActivityLoginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());


        setContentView(binding.getRoot());
    }
}