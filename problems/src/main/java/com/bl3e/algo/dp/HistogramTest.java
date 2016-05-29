package com.bl3e.algo.dp;

import org.junit.Test;

/**
 * Created by kumarrak on 20/05/16.
 */
public class HistogramTest {

    @Test
    public void getMaximumArea(){
        int[] bars={6,2,5,4,5,1,6};
        Histogram histogram=new Histogram(bars);
       int maxArea= histogram.getMaximumArea();
        System.out.println(maxArea);
    }
}
