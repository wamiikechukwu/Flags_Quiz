package com.example.viewpager2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class OverView extends AppCompatActivity implements RecyclerViewAdapter.onClickListener {
    RecyclerView recyclerView;

    RecyclerView.LayoutManager layoutManager;

    private ViewPager2 viewPager2;

    @Override
    public void onItemClick(int position) {
        Toast.makeText(this, "item index click is " +position, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra("INDEX",position);
        startActivity(intent);
//
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_over_view);

        recyclerView = findViewById(R.id.recycler_view);
        layoutManager = new GridLayoutManager(this,3);
        recyclerView.setAdapter(new RecyclerViewAdapter(getApplicationContext(),this));
        recyclerView.setLayoutManager(layoutManager);

    }
}
