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
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.edusphere.R;
import com.example.edusphere.databinding.FragmentSignProccesBinding;
import com.example.edusphere.domain.model.events.MyEvent;
import com.example.edusphere.feature.sign_process.presentation.SignProcessViewModel;

import java.util.ArrayList;
import java.util.List;


public class SignProccesFragment extends Fragment {
    private FragmentSignProccesBinding binding;
    private ArrayAdapter<String> scheduleAdapter;
    private SignProcessViewModel viewModel;
    private SharedPreferences sp;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(SignProcessViewModel.class);

        binding = FragmentSignProccesBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel.events.observe(getViewLifecycleOwner(), this::setAdapter);
        viewModel.load_events(1);
    }

    private void setAdapter(@NonNull List<MyEvent> lst){
        List<String> events = new ArrayList<>();
        for(int i = 0; i< 60;i+=10){
            events.add("16:" + String.valueOf(i));
        }
        if(!lst.isEmpty()){
            for(int i =0;i<lst.size();i++){
                String time = lst.get(i).getTime();
                events.remove(time);
            }
        }
        scheduleAdapter = new ArrayAdapter<String>
                (getContext(), android.R.layout.simple_list_item_single_choice, events);

        binding.schedule.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        binding.schedule.setAdapter(scheduleAdapter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}