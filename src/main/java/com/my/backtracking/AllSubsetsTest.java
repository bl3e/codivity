package com.my.backtracking;

import org.junit.Test;

/**
 * Created by kumarrak on 24/04/16.
 */
public class AllSubsetsTest {
    @Test
    public void generateAllSubset(){
        int[] a={1,2,3};
        new AllSubsets().generateSubsets(4);
    }

    @Test
    public void generateAll(){
        int[] a={1,2,3};
        new AllSubsets().generateAll(4);
    }
}
