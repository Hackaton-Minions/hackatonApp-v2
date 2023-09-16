package com.example.edusphere.feature.sign.ui;

import android.app.FragmentManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.edusphere.R;
import com.example.edusphere.databinding.FragmentSignBinding;
import com.example.edusphere.domain.model.sign.Sign;
import com.example.edusphere.feature.sign.ui.recycler.SignAdapter;
import com.example.edusphere.feature.sign.ui.recycler.SignClickListener;
import com.example.edusphere.feature.sign_process.ui.SignProccesFragment;
import com.example.edusphere.feature.teachers.ui.TeachersFragment;

import java.util.ArrayList;

public class SignFragment extends Fragment {
    private FragmentSignBinding binding;
    private ArrayList<Sign> signs;
    private SignAdapter adapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSignBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.nav_host_fragment_activity_main, new SignProccesFragment(), "NewFragmentTag");
                ft.commit();
            }
        });


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}