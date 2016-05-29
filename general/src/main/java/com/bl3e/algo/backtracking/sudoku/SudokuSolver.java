package com.bl3e.algo.backtracking.sudoku;

/**
 * Created by kumarrak on 09/05/16.
 */
public class SudokuSolver {
private int[][] board;
final int BLANK=0;

    public SudokuSolver(int[][] board) {
        this.board = board;
    }

    boolean solve(){
    return solve(0,0);
    }

    private boolean solve(int row, int col) {
        if(row>=board.length||col>=board[0].length){
            return true;
        }
        if(board[row][col]!=BLANK){
            int[] nextUnsolvedPostion = getNextUnsolvedPostion(row, col);
            if(nextUnsolvedPostion==null){
                return true;
            }
            return solve(nextUnsolvedPostion[0],nextUnsolvedPostion[1]) ;
        }
            for (int num = 1; num <= board.length; num++) {
                if (isValidFill(row, col, num)) {
                    board[row][col] = num;
                     if(solve(row, col)) {
                           return true;
                     }
                }
            }

           board[row][col]=0;
        return false;
    }

    private boolean isValidFill(int x, int y, int i) {
        for (int j = 0; j <board.length ; j++) {
            if(board[x][j]==i || board[j][y]==i ){
                return false;
            }
        }
        return true;
    }

    private int[] getNextUnsolvedPostion(int row,int col){
        for (int i = row; i <board.length ; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j]==0){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }


    public void printSolution() {
        for (int i = 0; i < board.length ; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(String.format("%2d",board[i][j]));
            }
            System.out.println();
        }
    }
}
