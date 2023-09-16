package com.example.edusphere.feature.sign_process.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.edusphere.R;
import com.example.edusphere.databinding.FragmentSignProccesBinding;


public class SignProccesFragment extends Fragment {
    private FragmentSignProccesBinding binding;
    private SharedPreferences sp;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //viewModel = new ViewModelProvider(this).get(ItemsViewModel.class);

        binding = FragmentSignProccesBinding.inflate(inflater);
        return binding.getRoot();
    }



    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}