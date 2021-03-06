package com.bl3e.algo.misc;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by kumarrak on 23/06/16.
 */
public class ConnectedCellsTest {

    @Test
    public void getLengthOfConnectedRegion() throws Exception {

        int[][] regionMatrix = {
                {1, 1, 0, 1},
                {0, 1, 0, 1},
                {1, 0, 0, 1},
                {1, 1, 0, 1}
        };
        assertThat(ConnectedCells.getLengthOfRegion(regionMatrix),is(6));
    }


    @Test
    public void getLengthOfConnectedRegion2() throws Exception {

        int[][] regionMatrix = {
                {1, 1, 0, 1},
                {0, 1, 0, 1},
                {0, 0, 0, 1},
                {1, 1, 0, 1}
        };
        assertThat(ConnectedCells.getLengthOfRegion(regionMatrix),is(4));
    }

    @Test
    public void getLengthOfConnectedRegion3() throws Exception {

        int[][] regionMatrix = {
                {1, 1, 1, 1},
                {0, 1, 0, 0},
                {0, 0, 0, 1},
                {1, 1, 0, 1}
        };
        assertThat(ConnectedCells.getLengthOfRegion(regionMatrix),is(5));
    }

}