package com.example.viewpager2.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlagTest {


    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void Equality() {
        Flag flag = new Flag(1,"any_country",2);
        Flag flag2 = new Flag(1,"any_country",2);
        assertEquals(flag,flag2);
    }

    @Test
    public void ShuffleTest() {
        Flag flag = new Flag(1,"any_country",2);
        System.out.println("sh: "+flag.shuffleStringList());
    }
}