package com.example.edusphere.feature.teachers.ui.recycler;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.example.edusphere.databinding.ItemTeacherBinding;
import com.example.edusphere.domain.model.teachers.Teacher2;

public class TeachersViewHolder extends ViewHolder {

    private final ItemTeacherBinding binding;
    private final TeachersClickListener listener;


    public TeachersViewHolder(ItemTeacherBinding binding, TeachersClickListener listener) {
        super(binding.getRoot());
        this.binding = binding;
        this.listener = listener;
    }
//    public TeachersViewHolder(ItemTeacherBinding binding) {
//        super(binding.getRoot());
//        this.binding = binding;
//    }

    public void bind(Teacher2 teacher) {
        //add bin properties
        binding.name.setText(teacher.getName());
        binding.subject.setText(teacher.getSubject());
        binding.getRoot().setOnClickListener(v -> {
listener.onClick(teacher.getId());
        });
    }

}
