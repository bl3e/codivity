package com.bl3e.algo.backtracking.maze;

/**
 * Created by kumarrak on 08/05/16.
 */
public class MazeSolver {
private int[][] maze;
    private int[][] solution;
    MazeSolver(int[][] maze){
        this.maze=maze;
        solution=new int[maze.length][maze[0].length];
    }

    boolean solve(){
       return solve(0,0,0);
    }

    private boolean solve(int x, int y,int index) {
        final int LASTROW=maze.length-1;
        final int LASTCOL=maze[0].length-1;
        if(x==LASTROW && y==LASTCOL){
            solution[x][y]=index+1;
            return true;
        }
        solution[x][y]=index+1;

        if(isValidNext(x+1, y) && solve(x + 1, y, index + 1)){ //right-->
         return true;
        }

        if(isValidNext(x-1,y) && solve(x-1,y,index+1)){ //left-->
            return true;
        }

        if(isValidNext(x,y+1) && solve(x,y+1,index+1)){ //up-->
            return true;
        }
        if(isValidNext(x,y-1) && solve(x,y-1,index+1)){ //down-->
            return true;
        }

       solution[x][y]=0;
        return false;
    }

    private boolean isValidNext(int x, int y) {
        final int LASTROW=maze.length-1;
        final int LASTCOL=maze[0].length-1;

        return x>=0 && x <= LASTROW && y>=0 && y <= LASTCOL && solution[x][y]==0 && maze[x][y]==1;
    }
    void printSolution(){
        for (int i = 0; i <solution.length ; i++) {
            for (int j = 0; j < solution[0].length; j++) {
                System.out.print(solution[i][j]+" ");
            }
            System.out.println();
        }
    }
}
