package com.example.edusphere.feature.sign.ui.recycler;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import com.example.edusphere.databinding.ItemSignsBinding;
import com.example.edusphere.domain.model.events.Sign;

import java.util.ArrayList;
import java.util.List;

public class SignAdapter extends Adapter<SignViewHolder> {

//    private final SignClickListener listener;
    private List<Sign> items = new ArrayList<>();

//    public SignAdapter(SignClickListener listener) {
//        this.listener = listener;
//    }


    @NonNull
    @Override
    public SignViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemSignsBinding binding = ItemSignsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
//        return new SignViewHolder(binding, listener);
        return new SignViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull SignViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(List<Sign> items) {
        int count = getItemCount();
         this.items = new ArrayList<>(items);
         notifyItemRangeChanged(0, Math.max(count, getItemCount()));

    }
}
