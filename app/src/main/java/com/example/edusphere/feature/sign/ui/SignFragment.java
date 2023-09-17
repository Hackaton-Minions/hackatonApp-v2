package com.example.edusphere.feature.sign.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.edusphere.R;
import com.example.edusphere.databinding.FragmentSignBinding;
import com.example.edusphere.domain.model.events.Sign;
import com.example.edusphere.feature.sign.presentation.SignViewModel;
import com.example.edusphere.feature.sign.ui.recycler.SignAdapter;
import com.example.edusphere.feature.sign_process.ui.SignProccesFragment;

import java.util.ArrayList;
import java.util.List;

public class SignFragment extends Fragment {
    private FragmentSignBinding binding;
    private ArrayList<Sign> signs;
    private SignAdapter adapter;
    private SignViewModel viewModel;
    private SharedPreferences sharedPreferences;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSignBinding.inflate(inflater);

        viewModel = new ViewModelProvider(this).get(SignViewModel.class);

        adapter = new SignAdapter();
        binding.recycler.setAdapter(adapter);
        viewModel.signs.observe(getViewLifecycleOwner(), this::renderItems);

        sharedPreferences = getActivity().getSharedPreferences("mysettings", Context.MODE_PRIVATE);
        String type = sharedPreferences.getString("user_type", "none");
        if(type.equals("Родитель")){
            viewModel.load_data(sharedPreferences.getLong("id", 0), "parent");
        }else{
            viewModel.load_data(sharedPreferences.getLong("id", 0), "student");
        }

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

    private void renderItems(List<Sign> signs){
        if(!signs.isEmpty()){
            adapter.setItems(signs);
        }else{
            signs.add(new Sign("Monday", "19", "Yupi", "math"));
            adapter.setItems(signs);
        }
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}