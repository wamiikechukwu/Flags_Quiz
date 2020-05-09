package com.example.viewpager2.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.viewpager2.ui.ItemClickListener;
import com.example.viewpager2.R;
import com.example.viewpager2.model.Flag;

public class FlagAdapter extends ListAdapter<Flag, FlagAdapter.FlagVH> {
    private ItemClickListener<Integer> itemClickListener;

    public void setItemClickListener(ItemClickListener<Integer> callBack) {
        this.itemClickListener = callBack;
    }

    public FlagAdapter() {
        super(new FlagDiff());
    }

    @NonNull
    @Override
    public FlagVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FlagVH(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_flags, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull FlagVH holder, int position) {
        holder.bind(getItem(position), position, itemClickListener);

    }

    static class FlagVH extends RecyclerView.ViewHolder {

        FlagVH(@NonNull View itemView) {
            super(itemView);
        }

        void bind(final Flag item, int position, final ItemClickListener<Integer> itemClickListener) {
            ImageView mImgFlag = itemView.findViewById(R.id.img_flag);
            Glide.with(itemView.getContext()).load(item.getImageRef()).centerCrop().into(mImgFlag);
            itemView.setOnClickListener(view -> itemClickListener.onItemClick(position));
        }
    }
}
