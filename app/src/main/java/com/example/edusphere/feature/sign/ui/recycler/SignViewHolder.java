package com.example.edusphere.feature.sign.ui.recycler;

import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.example.edusphere.databinding.ItemSignsBinding;
import com.example.edusphere.domain.model.events.Sign;

public class SignViewHolder extends ViewHolder  {

    private final ItemSignsBinding binding;
    //private final SignClickListener listener;


//    public SignViewHolder(ItemSignsBinding binding, SignClickListener listener) {
//        super(binding.getRoot());
//        this.binding = binding;
//        this.listener = listener;
//    }
    public SignViewHolder(ItemSignsBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(Sign item) {
        binding.name.setText(item.getName_teacher());
        binding.subject.setText(item.getSubject());
        binding.time.setText(item.getDay() + ": " + item.getTime());
    }

}
