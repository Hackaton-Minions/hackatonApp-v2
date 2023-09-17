package com.example.edusphere.feature.login.ui;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.edusphere.databinding.ActivityLoginBinding;
import com.example.edusphere.domain.model.ResponseEntity;
import com.example.edusphere.feature.login.presentation.LoginViewModel;
import com.example.edusphere.feature.main.ui.MainActivity;
import com.example.edusphere.feature.main_teacher.ui.MainTeacherActivity;
import com.example.edusphere.feature.registration.ui.Registration;
import com.example.edusphere.feature.teachers.presentation.TeacherViewModel;

import java.util.Objects;


public class Login extends AppCompatActivity {
    private ActivityLoginBinding binding;
    private LoginViewModel viewModel;
    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());

        viewModel = new ViewModelProvider(this).get(LoginViewModel.class);



        binding.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.entity.observe(Login.this, Login.this::processing);
                viewModel.authorize_person(binding.loginEditText.getText().toString(),
                        binding.passwordEditText.getText().toString());
            }
        });
        binding.signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), Registration.class));
            }
        });
        setContentView(binding.getRoot());
    }

    private void processing(ResponseEntity entity){
        if(entity.getId() == -1){
            Toast.makeText(this, "Что-то пошло не так", Toast.LENGTH_SHORT);
        }else{
            sharedPreferences = getSharedPreferences("mysettings", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();

            editor.putLong("id", entity.getId());
            editor.putString("user_type", entity.getUser_type());

            editor.apply();

            if(Objects.equals(entity.getUser_type(), "student") || Objects.equals(entity.getUser_type(), "parent")){
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            }else{
                Intent intent = new Intent(this, MainTeacherActivity.class);
                startActivity(intent);
            }
        }
    }
}