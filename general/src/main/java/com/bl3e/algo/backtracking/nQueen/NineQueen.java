package com.bl3e.algo.backtracking.nQueen;

/**
 * Created by kumarrak on 02/05/16.
 */
public class NineQueen {
    public static void main(String[] args){
    new NineQueen().getNonAttackingQueenPositions(8,8) ;
    }

    boolean[][] getNonAttackingQueenPositions(int boardSize,int numQueens){
        boolean[][] board=new boolean[boardSize][boardSize];
        placeQueensInNonAttackingPositions(board,0,numQueens);
        return board;
    }

    private boolean placeQueensInNonAttackingPositions(boolean[][] board,int rowNum, int numQueens) {
       final int size=board.length;

        if(numQueens==0){
            printBoard(board);
            System.out.println();
            return true;
        }
              for (int j = 0; j <size ; j++) {
                    if(isNonAttacking(board,rowNum,j)){
                        board[rowNum][j]=true; //make a choice
                       if(!placeQueensInNonAttackingPositions(board,rowNum+1,numQueens-1)) {
                           board[rowNum][j] = false; //undo the previous choice
                       }
                    }

                }

return false;
            }


    private boolean isNonAttacking(boolean[][] board, int i, int j) {

        final boolean isColumnEmpty = isColumnEmpty(board, j);
        final boolean isRowEmpty = isRowEmpty(board, i);
        final boolean isDiagonalEmpty = isDiagonalEmpty(board, i, j);
        return isColumnEmpty && isRowEmpty && isDiagonalEmpty;
    }
    private boolean isDiagonalEmpty(boolean[][] board, int i, int j) {
        return isLeftDiagonalBottomEmpty(board,i,j) && isLeftDiagonalTopEmpty(board,i,j)
                && isRightDiagonalBottomEmpty(board,i,j)&&isRightDiagonalTopEmpty(board,i,j);
    }
    private boolean isLeftDiagonalTopEmpty(boolean[][] board, int i, int j) {
     if(i<0||j<0||i>=board.length||j>=board.length){
         return true;
     }
        
            if(board[i][j]==true){
                return false;
            }
        return isLeftDiagonalTopEmpty(board,i-1,j+1) ;
    }

    private boolean isLeftDiagonalBottomEmpty(boolean[][] board, int i, int j) {
        if(i<0||j<0||i>=board.length||j>=board.length){
            return true;
        }

        if(board[i][j]==true){
            return false;
        }
        return isLeftDiagonalBottomEmpty(board,i+1,j-1) ;
    }
    private boolean isRightDiagonalTopEmpty(boolean[][] board, int i, int j) {
        if(i<0||j<0||i>=board.length||j>=board.length){
            return true;
        }

        if(board[i][j]==true){
            return false;
        }
        return isRightDiagonalTopEmpty(board,i+1,j+1) ;
    }

    private boolean isRightDiagonalBottomEmpty(boolean[][] board, int i, int j) {
        if(i<0||j<0||i>=board.length||j>=board.length){
            return true;
        }

        if(board[i][j]==true){
            return false;
        }
        return isRightDiagonalBottomEmpty(board,i-1,j-1) ;
    }

    private boolean isRowEmpty(boolean[][] board, int row) {
        final int size=board.length;
        for (int i = 0; i < size; i++) {
            if (board[row][i]==true){
                return false;
            }
        }
        return true;
    }

    private boolean isColumnEmpty(boolean[][] board,int col) {
        final int size=board.length;
        for (int i = 0; i < size; i++) {
           if (board[i][col]==true){
               return false;
        }
    }
        return true;
}

    private void printBoard(boolean[][] board) {
        for (boolean[] aBoard : board) {
            {
                for (boolean boardPos:aBoard) {
                    if (boardPos == true)
                        System.out.print(" x ");
                    else
                        System.out.print(" o ");
                }
                System.out.println();
            }
        }
    }
    
}
