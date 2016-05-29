package com.bl3e.algo.backtracking.knight;

/**
 * Created by kumarrak on 04/05/16.
 */
public class KnightTour {
int board[][];
    private int startX;
    private int startY;
    private int path=0;

    public KnightTour(int boardSize){
        board=new int[boardSize][boardSize];

    }
    public  void startTour(int x, int y){
        int numSquares=board.length*board.length;
        moveKnightTo(x,y,0);
        printBoard(board);
    }

    private void printBoard(int[][] board) {
        final int size=board.length;
        for (int i = 0; i < size; i++) {
            {
                for (int j = 0; j <size ; j++) {
                    System.out.print(String.format("%2d",board[i][j])+" ");
                }

            }
            System.out.println();
        }
    }

    private boolean moveKnightTo(int x, int y, int visitedCount){
    if(board[x][y]!=0){
    return false;
}
        board[x][y]=visitedCount;
        if(visitedCount==63 ){
        return true;
    }


        if(isValidMove(x+2, y+1) && moveKnightTo(x+2,y+1,visitedCount+1)){
        return true;
        }

        if(isValidMove(x+1, y+2) &&moveKnightTo(x+1,y+2,visitedCount+1)){
            return true;
        }

        if(isValidMove(x-1, y+2)&&moveKnightTo(x-1,y+2,visitedCount+1)){ //
            return true;
        }

        if(isValidMove(x-2, y+1) && moveKnightTo(x-2,y+1,visitedCount+1)){ //
            return true;
        }



    if(isValidMove(x-2, y-1)&& moveKnightTo(x-2,y-1,visitedCount+1)){
     return true;
    }


    if(isValidMove(x-1, y-2)&&moveKnightTo(x-1,y-2,visitedCount+1)){ //
       return true;
    }
        if(isValidMove(x+1, y-2)&&moveKnightTo(x+1,y-2,visitedCount+1)){ //
            return true;
        }
        if(isValidMove(x+2, y-1) && moveKnightTo(x+2,y-1,visitedCount+1)){
            return true;
        }

        board[x][y]=0;
    return false;
}

    private boolean isValidMove(int x, int y) {
        if(x>=0 &&x<board.length &&y>=0 &&y<board.length && board[x][y]==0){
            return true;
        }
        return false;
    }
}
