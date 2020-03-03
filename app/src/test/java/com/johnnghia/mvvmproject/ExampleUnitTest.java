package com.johnnghia.mvvmproject;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void swap(){assertEquals(4,test());}


    public int test(){
        int a = 4, b =5;
        swa(a,b);
        return a;
    }
    public void swa(int a, int b){
        a = b;
    }
}