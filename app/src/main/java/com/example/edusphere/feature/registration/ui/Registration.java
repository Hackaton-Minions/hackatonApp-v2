package com.example.edusphere.feature.registration.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.edusphere.R;
import com.example.edusphere.databinding.ActivityRegistrationBinding;
import com.example.edusphere.feature.registration.presentation.RegistrationViewModel;


public class Registration extends AppCompatActivity {
    private ActivityRegistrationBinding binding;
    private RegistrationViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegistrationBinding.inflate(getLayoutInflater());

        viewModel = new ViewModelProvider(this).get(RegistrationViewModel.class);

        setContentView(binding.getRoot());
    }
}