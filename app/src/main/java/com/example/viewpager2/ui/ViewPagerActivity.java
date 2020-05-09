package com.example.viewpager2.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.viewpager2.data.Constants;
import com.example.viewpager2.R;
import com.example.viewpager2.adapter.FlagPagerAdapter;
import com.example.viewpager2.ui.viewmodel.FlagViewModel;

public class ViewPagerActivity extends AppCompatActivity {
    private int flagId;
    private FlagViewModel viewModel;
    private ViewPager2 viewPager;
    private FlagPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        initViewPager();
        configViewModel();
        checkForFlagExtras(getIntent());
    }

    private void initViewPager() {
        viewPager = findViewById(R.id.view_pager);
        adapter = new FlagPagerAdapter();
        adapter.setItemClickListener(data -> Toast.makeText(this, data, Toast.LENGTH_SHORT).show());

    }

    private void configViewModel() {
        viewModel = new ViewModelProvider(this).get(FlagViewModel.class);
        viewModel.init();
        subscribeObserver();
    }

    private void subscribeObserver() {
        viewModel.flagData.observe(this,flags -> {
            adapter.submitList(flags);
            viewPager.setAdapter(adapter);
            if (flagId > 0){
                viewPager.setCurrentItem(flagId);
            }
        });
    }

    private void checkForFlagExtras(Intent intent) {
        if (intent.hasExtra(Constants.FLAG_ID_EXTRA)) {
            flagId = intent.getIntExtra(Constants.FLAG_ID_EXTRA, 0);

        }
    }
}
