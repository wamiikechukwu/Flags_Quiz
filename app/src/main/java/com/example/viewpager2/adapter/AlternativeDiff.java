package com.example.viewpager2.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class AlternativeDiff extends DiffUtil.ItemCallback<String> {
    @Override
    public boolean areItemsTheSame(@NonNull String oldItem, @NonNull String newItem) {
        return oldItem.equals(newItem);
    }

    @Override
    public boolean areContentsTheSame(@NonNull String oldItem, @NonNull String newItem) {
        return oldItem.equals(newItem);
    }
}
