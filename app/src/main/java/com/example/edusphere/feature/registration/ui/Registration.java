package com.example.edusphere.feature.registration.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.edusphere.databinding.ActivityRegistrationBinding;
import com.example.edusphere.domain.model.registration.Parent;
import com.example.edusphere.domain.model.registration.Student;
import com.example.edusphere.domain.model.registration.Teacher;
import com.example.edusphere.domain.model.registration.UserResponse;
import com.example.edusphere.feature.registration.presentation.RegistrationViewModel;

import java.util.ArrayList;
import java.util.List;


public class Registration extends AppCompatActivity {
    private ActivityRegistrationBinding binding;
    private RegistrationViewModel viewModel;
    private List<String> userTypes;
    private ArrayAdapter<String> adapter;
    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegistrationBinding.inflate(getLayoutInflater());

        viewModel = new ViewModelProvider(this).get(RegistrationViewModel.class);

        userTypes = new ArrayList<>();
        userTypes.add("Студент");
        userTypes.add("Учитель");
        userTypes.add("Родитель");

        adapter =new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, userTypes);

        binding.typesList.setPrompt("Выберите помещение");
        binding.typesList.setAdapter(adapter);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        binding.typesList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                renderFields(adapter.getItem(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        binding.registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("TAGG", binding.typesList.getSelectedItem().toString());
                regUser(binding.typesList.getSelectedItem().toString());
            }
        });

        setContentView(binding.getRoot());
    }

    private void saveUser(UserResponse user){
//        sharedPreferences = getSharedPreferences("mysettings", Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//
//        editor.putString("id", String.valueOf(user.getId()));

    }

    private void regUser(String user){
        switch (user){
            case "Студент":
                viewModel.user.observe(this, this::saveUser);
                viewModel.register_student(new Student(
                        binding.login.getText().toString(),
                        binding.password.getText().toString(),
                        binding.name.getText().toString()
                    ), binding.parentLogin.getText().toString(),
                        binding.groupForStudent.getText().toString()
                );
                break;
            case "Учитель":
                List<String> g = new ArrayList<>();
                g.add("11-4");
                viewModel.user.observe(this, this::saveUser);
                viewModel.register_teacher(new Teacher(
                        binding.name.getText().toString(),
                        binding.login.getText().toString(),
                        binding.password.getText().toString(),
                        g));
                break;
            case "Родитель":
                //viewModel.user.observe(this, this::saveUser);
                Parent p = new Parent(
                    binding.name.getText().toString(),
                    binding.login.getText().toString(),
                    binding.password.getText().toString()
                );
                Log.d("TAGG", p.getLogin() + p.getPassword() + p.getName());
                viewModel.register_parent(p);
                break;
        }
    }




    private void renderFields(String user){
        switch (user){
            case "Студент":
                binding.parentLogin.setVisibility(View.VISIBLE);
                binding.groupForStudent.setVisibility(View.VISIBLE);

                binding.subject.setVisibility(View.GONE);
                binding.schoolCode.setVisibility(View.GONE);
                break;
            case "Учитель":
                binding.parentLogin.setVisibility(View.GONE);
                binding.groupForStudent.setVisibility(View.GONE);

                binding.subject.setVisibility(View.VISIBLE);
                binding.schoolCode.setVisibility(View.VISIBLE);
                break;
            case "Родитель":
                binding.parentLogin.setVisibility(View.GONE);
                binding.groupForStudent.setVisibility(View.GONE);

                binding.subject.setVisibility(View.GONE);
                binding.schoolCode.setVisibility(View.GONE);
                break;
        }
    }
}