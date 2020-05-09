package com.example.viewpager2.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.viewpager2.data.Constants;
import com.example.viewpager2.R;
import com.example.viewpager2.adapter.FlagAdapter;
import com.example.viewpager2.model.Flag;
import com.example.viewpager2.ui.viewmodel.FlagViewModel;

import java.util.List;

/**
 * Main2Activity
 * Hope this suit your needs, modify for your algorithm structure
 */
public class Main2Activity extends AppCompatActivity {
    private FlagViewModel viewModel;
    private RecyclerView recyclerView;
    private FlagAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initRecyclerView();
        configViewModel();
    }

    private void configViewModel() {
        viewModel = new ViewModelProvider(this).get(FlagViewModel.class);
        viewModel.init();
        subscribeObserver();
    }

    private void subscribeObserver() {
        viewModel.flagData.observe(this, this::LoadData);
    }

    private void LoadData(List<Flag> flags) {
        adapter.submitList(flags);
        recyclerView.setAdapter(adapter);

    }


    /**
     * Initialize the recycler view with the flag adapter
     */
    private void initRecyclerView() {
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        int spanCount = 3;
        recyclerView.setLayoutManager(new GridLayoutManager(this.getBaseContext(), spanCount));

        adapter = new FlagAdapter();
        ItemClickListener<Integer> itemClickListener = this::startViewPagerIntent;

        adapter.setItemClickListener(itemClickListener);
        recyclerView.setAdapter(adapter);
    }

    private void startViewPagerIntent(Integer flagId) {
        Intent viewPagerActivity = new Intent(this.getBaseContext(), ViewPagerActivity.class);
        viewPagerActivity.putExtra(Constants.FLAG_ID_EXTRA, flagId);
        startActivity(viewPagerActivity);
    }

}
