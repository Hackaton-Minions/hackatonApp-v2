package com.example.edusphere.feature.sign.ui.recycler;

import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.example.edusphere.databinding.ItemSignsBinding;
import com.example.edusphere.domain.model.sign.Sign;

public class SignViewHolder extends ViewHolder  {

    private final ItemSignsBinding binding;
    private final SignClickListener listener;


    public SignViewHolder(ItemSignsBinding binding, SignClickListener listener) {
        super(binding.getRoot());
        this.binding = binding;
        this.listener = listener;
    }

    public void bind(Sign item) {

    }

}
