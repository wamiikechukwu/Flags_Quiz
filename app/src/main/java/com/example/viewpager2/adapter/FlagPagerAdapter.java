package com.example.viewpager2.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.viewpager2.ui.ItemClickListener;
import com.example.viewpager2.R;
import com.example.viewpager2.model.Flag;

public class FlagPagerAdapter extends ListAdapter<Flag, FlagPagerAdapter.ViewPageVH> {

    private ItemClickListener<String> itemClickListener;

    public FlagPagerAdapter() {
        super(new FlagDiff());
    }

    public void setItemClickListener(ItemClickListener<String> itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public ViewPageVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewPageVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_alternatives, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewPageVH holder, int position) {
        holder.bind(getItem(position), itemClickListener);
    }


    static class ViewPageVH extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private RecyclerView recyclerView;
        private AlternativeAdapter adapter;


        ViewPageVH(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.img_flag);
            recyclerView = itemView.findViewById(R.id.recycler_view);
            recyclerView.hasFixedSize();
            int spanCount = 6;
            recyclerView.setLayoutManager(new GridLayoutManager(itemView.getContext(), spanCount));
            adapter = new AlternativeAdapter();
            adapter.setItemClickListener(data -> Toast.makeText(itemView.getContext(), data, Toast.LENGTH_SHORT).show());

        }


        void bind(Flag item, ItemClickListener<String> itemClickListener) {
            Glide.with(itemView.getContext()).load(item.getImageRef()).centerCrop().into(imageView);
            adapter.submitList(item.shuffleStringList());
            recyclerView.setAdapter(adapter);
            itemView.setOnClickListener(view -> itemClickListener.onItemClick(item.getCountryName()));
        }
    }
}
