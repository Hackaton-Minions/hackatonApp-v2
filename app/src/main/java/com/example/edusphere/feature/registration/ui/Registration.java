package com.example.edusphere.feature.registration.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.edusphere.databinding.ActivityRegistrationBinding;
import com.example.edusphere.domain.model.registration.Parent;
import com.example.edusphere.domain.model.registration.Student;
import com.example.edusphere.domain.model.registration.Teacher;
import com.example.edusphere.domain.model.registration.UserResponse;
import com.example.edusphere.feature.login.ui.Login;
import com.example.edusphere.feature.main.ui.MainActivity;
import com.example.edusphere.feature.main_teacher.ui.MainTeacherActivity;
import com.example.edusphere.feature.registration.presentation.RegistrationViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


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
        userTypes.add("Ученик");
        userTypes.add("Учитель");
        userTypes.add("Родитель");

        adapter =new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, userTypes);

        binding.typesList.setPrompt("Выберите помещение");
        binding.typesList.setAdapter(adapter);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        binding.enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), Login.class));
            }
        });

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

        if(user.getId() == -1){
            Toast.makeText(this, "Что-то пошло не так", Toast.LENGTH_SHORT).show();
        }else{
            sharedPreferences = getSharedPreferences("mysettings", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();

            editor.putLong("id", user.getId());
            editor.putString("user_type", binding.typesList.getSelectedItem().toString());

            editor.apply();
            if(Objects.equals(binding.typesList.getSelectedItem().toString(), "Ученик") || Objects.equals(binding.typesList.getSelectedItem().toString(), "Родитель")){
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            }else{
                Intent intent = new Intent(this, MainTeacherActivity.class);
                startActivity(intent);
            }
        }
    }

    private void regUser(String user){
        switch (user){
            case "Ученик":
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
                viewModel.user.observe(this, this::saveUser);
                Parent p = new Parent(
                    binding.name.getText().toString(),
                    binding.login.getText().toString(),
                    binding.password.getText().toString()
                );
                viewModel.register_parent(p);
                break;
        }
    }




    private void renderFields(String user){
        switch (user){
            case "Ученик":
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