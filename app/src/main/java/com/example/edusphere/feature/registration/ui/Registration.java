package com.example.edusphere.feature.registration.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.edusphere.R;
import com.example.edusphere.databinding.ActivityRegistrationBinding;
import com.example.edusphere.feature.registration.presentation.RegistrationViewModel;

import java.util.ArrayList;
import java.util.List;


public class Registration extends AppCompatActivity {
    private ActivityRegistrationBinding binding;
    private RegistrationViewModel viewModel;
    private List<String> userTypes;
    private ArrayAdapter<String> adapter;
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

        setContentView(binding.getRoot());
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