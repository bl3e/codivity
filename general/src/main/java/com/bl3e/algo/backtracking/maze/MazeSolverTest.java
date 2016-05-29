package com.bl3e.algo.backtracking.maze;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by kumarrak on 08/05/16.
 */
public class MazeSolverTest {

    @Test
    public void solve() {
        int[][] maze = {{1, 0, 1, 1, 1},
                        {1, 1, 1, 0, 1},
                        {0, 0, 0, 1, 1},
                        {0, 0, 0, 1, 0},
                        {0, 0, 0, 1, 1}};
        MazeSolver mazeSolver=new MazeSolver(maze);
       assertThat(mazeSolver.solve(),is(true));
        mazeSolver.printSolution();
    }
}
