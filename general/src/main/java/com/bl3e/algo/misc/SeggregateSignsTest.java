package com.bl3e.algo.misc;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertArrayEquals;

/**
 * Created by kumarrak on 23/05/16.
 */
public class SeggregateSignsTest {

    @Test
    public void seggregate(){
        int[] a={-2,3,4,-1};
        new SeggregateSigns().seggregate(a);
        assertArrayEquals(a,new int[]{-2, 3, -1, 4});
    }

    @Test
    public void seggregate2(){
        int[] a={-2,3,1};
        new SeggregateSigns().seggregate(a);
        System.out.println(Arrays.toString(a));
    }

    @Test
    public void seggregate3(){
        int[] a={-5,3,4,5,-6,-2,8,9,-1,-4};
        new SeggregateSigns().seggregate(a);
        System.out.println(Arrays.toString(a));
    }
}
