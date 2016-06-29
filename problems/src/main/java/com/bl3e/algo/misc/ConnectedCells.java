package com.bl3e.algo.misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by kumarrak on 19/06/16.
 */
public class ConnectedCells {

    public static void main(String[] args) throws Exception {

        int[][] matrix = readInput();
        int length = getLengthOfRegion(matrix);
        System.out.println(length);
    }

    public static int getLengthOfRegion(int[][] matrix) {

        final int ROW = matrix.length;
        final int COL = matrix[0].length;
        int[][] max_till_now = new int[ROW][COL+1];
        max_till_now[0][0]=0;
        int maxLength=-1;
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (matrix[i][j] == 1 && isConnected(matrix, i, j)) {
                    max_till_now[i][j+1] = getPrevMax(max_till_now,i,j+1) + 1;
                }else {if(matrix[i][j]==1)
                    max_till_now[i][j+1]=1;
                    else
                    max_till_now[i][j+1]=0;
                }
                if(maxLength<max_till_now[i][j+1]){
                    maxLength=max_till_now[i][j+1];
                }
            }
        }
        return maxLength;
    }
private static int getPrevMax(int[][] lenghtMatrix,int i,int j){
    int max=0;
    if(j>0 && lenghtMatrix[i][j-1]>max)
        max=lenghtMatrix[i][j-1];

    if(i>0 && lenghtMatrix[i-1][j]>max)
        max=lenghtMatrix[i-1][j];

    if(i>0 && (j<lenghtMatrix.length-1) && lenghtMatrix[i-1][j+1]>max)
        max=lenghtMatrix[i-1][j+1];
    if(i>0 && j>0 && lenghtMatrix[i-1][j-1]>max)
        max=lenghtMatrix[i-1][j-1];

    return max;
}
    private static boolean isConnected(int[][] matrix, int i, int j) {

        if (j > 0 && matrix[i][j - 1] == 1) // left elem
            return true;
        if (i > 0 && matrix[i - 1][j] == 1) // \ diagonal
            return true;
        if (i > 0 && (j<matrix.length-1) && matrix[i - 1][j + 1] == 1) // / diagonal
            return true;
        if (i > 0 && j > 0 && matrix[i - 1][j - 1] == 1) // | up
            return true;
        if(i==0 && j==0 && matrix[i][j]==1)
            return true;
        return false;
    }

    private static int[][] readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ROWS = Integer.parseInt(br.readLine());
        int COLS = Integer.parseInt(br.readLine());
        int[][] matrix = new int[ROWS][COLS];
        for (int i = 0; i < ROWS; i++) {
            String rowLine = br.readLine();
            String[] numbers = rowLine.split(" ");
            for (int j = 0; j < COLS; j++) {
                matrix[i][j] = Integer.parseInt(numbers[j]);

            }

        }
        return matrix;
    }
}
