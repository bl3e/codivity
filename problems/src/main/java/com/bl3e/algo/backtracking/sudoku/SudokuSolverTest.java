package com.bl3e.algo.backtracking.sudoku;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by kumarrak on 10/05/16.
 */
public class SudokuSolverTest {
    @Test
    public void solve(){
        int[][] board = new int[][]
                {       { 5, 3, 0, 0, 7, 0, 0, 0, 0 },
                        { 6, 0, 0, 1, 9, 5, 0, 0, 0 },
                        { 0, 9, 8, 0, 0, 0, 0, 6, 0 },
                        { 8, 0, 0, 0, 6, 0, 0, 0, 3 },
                        { 4, 0, 0, 8, 0, 3, 0, 0, 1 },
                        { 7, 0, 0, 0, 2, 0, 0, 0, 6 },
                        { 0, 6, 0, 0, 0, 0, 2, 8, 0 },
                        { 0, 0, 0, 4, 1, 9, 0, 0, 5 },
                        { 0, 0, 0, 0, 8, 0, 0, 7, 9 } };
        SudokuSolver sudokuSolver=new SudokuSolver(board);
        assertTrue(sudokuSolver.solve());
        sudokuSolver.printSolution();
    }
}
