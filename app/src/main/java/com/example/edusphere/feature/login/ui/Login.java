package com.example.edusphere.feature.login.ui;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.edusphere.databinding.ActivityLoginBinding;
import com.example.edusphere.feature.registration.ui.Registration;


public class Login extends AppCompatActivity {
    private ActivityLoginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());

        binding.signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), Registration.class));
            }
        });
        setContentView(binding.getRoot());
    }
}