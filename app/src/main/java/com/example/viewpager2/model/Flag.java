package com.example.viewpager2.model;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Flag {
    private int id;
    private int imageRef;
    private String countryName;

    public Flag(int id, String countryName, int imageRef) {
        this.id = id;
        this.imageRef = imageRef;
        this.countryName = countryName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImageRef() {
        return imageRef;
    }

    public void setImageRef(int imageRef) {
        this.imageRef = imageRef;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    /**
     * Randomize string to a list
     *
     * @return List<string>
     */
    public List<String> shuffleStringList() {
        ArrayList<String> stringArrayList = new ArrayList<>();
        char[] titleArr = getCountryName().toCharArray();
        for (Character character : titleArr) {
            stringArrayList.add(character.toString());
        }
        Collections.shuffle(stringArrayList);
        return stringArrayList;
    }

    //Needed only when you want to compare object instance in memory
    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Flag) {
            Flag f = (Flag) obj;
            return Objects.equals(f.id, this.id) && Objects.equals(f.imageRef, this.imageRef) && Objects.equals(f.imageRef, this.imageRef);
        }
        return false;
    }
}
