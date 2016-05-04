package com.my.backtracking.knight;

/**
 * Created by kumarrak on 04/05/16.
 */
public class KnightTour {
boolean board[][];
    private int startX;
    private int startY;

    public KnightTour(int boardSize){
        board=new boolean[boardSize][boardSize];

    }
    public  boolean startTour(int x,int y){

    }
private boolean startTour(int x,int y,int remaining){
    if(x>=board.length || y>=board.length){
        return false;
    }
    if(remaining==0 && startX==x && startY==y){
        return true;
    }
    if(!startTour(x+2,y+1,remaining-1)){ //
        board[x][y]=false;
    }
    if(!startTour(x+2,y-1,remaining-1)){
        board[x][y]=false;
    }

    if(!startTour(x-2,y+1,remaining-1)){ //
        board[x][y]=false;
    }
    if(!startTour(x-2,y-1,remaining-1)){
        board[x][y]=false;
    }

    if(!startTour(x-1,y+2,remaining-1)){ //
        board[x][y]=false;
    }
    if(!startTour(x-1,y-2,remaining-1)){ //
        board[x][y]=false;
    }
    if(!startTour(x+1,y+2,remaining-1)){
        board[x][y]=false;
    }
    return false;
}
}
