package com.example.viewpager2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ViewPager2 viewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager2 = findViewById(R.id.pageview2);

        List<String> list = new ArrayList<>();
        list.add("First Screen");
        list.add("Second Screen");
        list.add("Third Screen");
        list.add("Fourth Screen");

        Intent intent = getIntent();
        int gettingTheIndexNumber = intent.getIntExtra("INDEX",0);


        viewPager2.setAdapter(new ViewPagerAdapter(this,viewPager2));
        viewPager2.setCurrentItem(gettingTheIndexNumber,true);

    }
}
