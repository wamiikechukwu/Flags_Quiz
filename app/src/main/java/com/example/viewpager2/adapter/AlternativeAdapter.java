package com.example.viewpager2.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.viewpager2.ui.ItemClickListener;
import com.example.viewpager2.R;

public class AlternativeAdapter extends ListAdapter<String, AlternativeAdapter.AlternativeVH> {

    private ItemClickListener<String> itemClickListener;

    AlternativeAdapter() {
        super(new AlternativeDiff());
    }

    void setItemClickListener(ItemClickListener<String> itemClickListener) {
        this.itemClickListener = itemClickListener;
    }


    @NonNull
    @Override
    public AlternativeVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AlternativeVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_buttons, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AlternativeVH holder, int position) {
        holder.bind(getItem(position), itemClickListener);

    }

    static class AlternativeVH extends RecyclerView.ViewHolder {
        private Button mButton;

        AlternativeVH(@NonNull View itemView) {
            super(itemView);
            mButton = itemView.findViewById(R.id.btn_title);
        }

        void bind(String item, ItemClickListener<String> itemClickListener) {
            mButton.setText(item);
            mButton.setOnClickListener(view -> itemClickListener.onItemClick(item));
        }
    }


}
