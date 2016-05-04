package com.my.backtracking;

import org.junit.Test;

/**
 * Created by kumarrak on 30/04/16.
 */
public class PermutationsTest {
    @Test
    public void generate(){
        new Permutations().generatePermutations(3);
    }

    @Test
    public void permute(){
        int[] a={1,2,3};
        new Permutations().permute(a);
    }
}

