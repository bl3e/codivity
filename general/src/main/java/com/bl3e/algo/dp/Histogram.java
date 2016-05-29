package com.bl3e.algo.dp;

/**
 * Created by kumarrak on 20/05/16.
 */
public class Histogram {
int[] bars;

    public Histogram(int[] bars) {
        this.bars = bars;
    }

    int getMaximumArea(){
        final int length=bars.length;
        int numberOfHigherTowersOnLeft=0;
        int maxArea[]=new int[bars.length];
        int minimumSettlingHeight=bars[0];
        maxArea[0]=bars[0];
        int includedArea=bars[0];
        for (int i = 1; i < length; i++) {

            if(bars[i]<bars[i-1]){
                minimumSettlingHeight=bars[i];
                numberOfHigherTowersOnLeft++;
                includedArea=(numberOfHigherTowersOnLeft+1)*minimumSettlingHeight;
            }else
            {
                numberOfHigherTowersOnLeft=0;
                includedArea+=minimumSettlingHeight;
            }


            maxArea[i]=Math.max(maxArea[i-1],includedArea);
        }
        return maxArea[length-1];
    }
}
