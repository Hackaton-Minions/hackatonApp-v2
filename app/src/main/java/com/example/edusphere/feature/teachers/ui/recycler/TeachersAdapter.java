package com.example.edusphere.feature.teachers.ui.recycler;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import com.example.edusphere.databinding.ItemSignsBinding;
import com.example.edusphere.databinding.ItemTeacherBinding;
import com.example.edusphere.domain.model.events.Sign;
import com.example.edusphere.domain.model.teachers.Teacher2;

import java.util.ArrayList;
import java.util.List;

public class TeachersAdapter extends Adapter<TeachersViewHolder> {

    private final TeachersClickListener listener;
    private List<Teacher2> teachers = new ArrayList<>();

    public TeachersAdapter(TeachersClickListener listener) {
        this.listener = listener;
    }


    @NonNull
    @Override
    public TeachersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemTeacherBinding binding = ItemTeacherBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
//        return new SignViewHolder(binding, listener);
        return new TeachersViewHolder(binding, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull TeachersViewHolder holder, int position) {
        holder.bind(teachers.get(position));
    }

    @Override
    public int getItemCount() {
        return teachers.size();
    }

    public void setItems(List<Teacher2> teachers) {
        int count = getItemCount();
         this.teachers = new ArrayList<>(teachers);
         notifyItemRangeChanged(0, Math.max(count, getItemCount()));

    }
}
