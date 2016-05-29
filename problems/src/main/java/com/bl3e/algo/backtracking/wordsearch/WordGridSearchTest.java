package com.bl3e.algo.backtracking.wordsearch;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by kumarrak on 07/05/16.
 */
public class WordGridSearchTest {
    WordGridSearch grid;
    @Before
    public void setup(){
        char[][] matrix = { { 't', 'z', 'x', 'c', 'd' },
                            { 'a', 'h', 'n', 'z', 'x' },
                            { 'h', 'w', 'o', 'i', 'o' },
                            { 'o', 'r', 'n', 'r', 'n' },
                            { 'a', 'b', 'r', 'i', 'n' } };
        grid=new WordGridSearch(matrix);
    }

    @Test
    public void search(){
     assertThat(grid.search("horizon"),is(true));
        grid.printGrid();
        System.out.println();
        grid.printSolution();
    }
}
