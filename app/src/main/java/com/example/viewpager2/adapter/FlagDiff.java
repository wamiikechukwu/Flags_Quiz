package com.example.viewpager2.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.example.viewpager2.model.Flag;

/**
 * FlagDiff
 * Calculate object difference
 * in the background for the Recyclerview
 */
public class FlagDiff extends DiffUtil.ItemCallback<Flag> {
    @Override
    public boolean areItemsTheSame(@NonNull Flag oldItem, @NonNull Flag newItem) {
        return oldItem.getId() == newItem.getId();
    }

    @Override
    public boolean areContentsTheSame(@NonNull Flag oldItem, @NonNull Flag newItem) {
        return oldItem.equals(newItem);
    }
}
