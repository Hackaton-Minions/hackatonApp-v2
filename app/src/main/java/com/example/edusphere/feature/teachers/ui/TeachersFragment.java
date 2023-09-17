package com.example.edusphere.feature.teachers.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.edusphere.R;
import com.example.edusphere.databinding.FragmentSignProccesBinding;
import com.example.edusphere.databinding.FragmentTeachersBinding;
import com.example.edusphere.domain.model.teachers.Teacher2;
import com.example.edusphere.feature.sign_process.presentation.SignProcessViewModel;
import com.example.edusphere.feature.teachers.presentation.TeacherViewModel;
import com.example.edusphere.feature.teachers.ui.recycler.TeachersAdapter;

import java.util.List;

public class TeachersFragment extends Fragment {

    private FragmentTeachersBinding binding;
    private TeacherViewModel viewModel;
    private SharedPreferences sharedPreferences;
    private TeachersAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        viewModel = new ViewModelProvider(this).get(TeacherViewModel.class);
        binding = FragmentTeachersBinding.inflate(inflater);

        adapter = new TeachersAdapter(id -> Navigation.findNavController(binding.getRoot()).navigate(TeachersFragmentDirections.actionTeachersFragmentToSignProccesFragment(id)));
        binding.recycler.setAdapter(adapter);

        viewModel.teachers.observe(getViewLifecycleOwner(), this::renderItems);
        sharedPreferences = getActivity().getSharedPreferences("mysettings", Context.MODE_PRIVATE);
        if(sharedPreferences.getString("user_type", "none").equals("Ученик") || sharedPreferences.getString("user_type", "none").equals("student")){
            viewModel.load_teachers_student(Math.toIntExact(sharedPreferences.getLong("id", -1)));
        }else{
            viewModel.load_teachers_parent(Math.toIntExact(sharedPreferences.getLong("id", -1)));
        }

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    private void renderItems(List<Teacher2> teachers){
        adapter.setItems(teachers);
    }
}