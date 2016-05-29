package com.bl3e.algo.dp.lis;

import org.junit.Test;

/**
 * Created by kumarrak on 24/05/16.
 */
public class LongestIncreasingSequenceTest {
    @Test
    public void lengthOfLIS_incorrect(){
        //int[] a ={10, 22, 9, 33, 21, 50, 41, 60, 80};
      //  int[] a ={1,2,9,4,8,10};
      //  int[] a ={2,5,3};
        int[] a ={2,50,30,70,3,5,7,9};
        int len=LongestIncreasingSequence.lengthofLIS_incorrect(a);
        System.out.println();
        System.out.println(len);
    }


    @Test
    public void lengthOfLIS(){
        int[] a ={10, 22, 9, 33, 21, 50, 41, 60, 80};
        //  int[] a ={1,2,9,4,8,10};
        //  int[] a ={2,5,3};
       // int[] a ={2,50,30,70,3,5,7,9};
        int len=LongestIncreasingSequence.lengthOfLIS(a);
        System.out.println();
        System.out.println(len);
    }
}
