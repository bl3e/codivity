package com.bl3e.algo.backtracking.wordsearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kumarrak on 07/05/16.
 */
public class WordGridSearch {


    char[][] wordGrid;
    int[][] solution;
    final int[] NO_MATCH={-1,-1};
    public WordGridSearch(char[][] wordGrid) {
        this.wordGrid = wordGrid;
        solution=new int[wordGrid.length][wordGrid[0].length];
    }

    public WordGridSearch(String[] wordRows) {
        final int rowSize=wordRows.length;
        this.wordGrid = new char[rowSize][];
        for(int i=0;i<rowSize;i++){
            wordGrid[i]=wordRows[i].toCharArray();
        }
        solution=new int[wordGrid.length][wordGrid[0].length];
    }

    boolean search(String word){
       return search(word.toCharArray());
    }

    private boolean search(char[] chars) {
        return search(0,0,chars);
    }
    private boolean search(int x, int y, char[] word) {
        for (int i = 0; i <wordGrid.length ; i++) {
            for (int j = 0; j < wordGrid[0].length; j++) {
                int foundChars=0;
                 if(search(i,j,word,foundChars))
                     return true;
            }

        }
        return false;
    }
    private boolean search(int x, int y, char[] word, int foundCharIndex) {
        if(foundCharIndex==word.length){
            return true;
        }
        if(!isValidNextPosition(x,y)||wordGrid[x][y]!=word[foundCharIndex]){
           return false;
       }

        solution[x][y]=foundCharIndex+1;

            foundCharIndex++;
            if(foundCharIndex==word.length){
                return true;
            }

           List<int[]> allNextMacth = getXYofNextMacth(x, y, word, foundCharIndex);
        for(int[] nextMacth:allNextMacth) {
            if (NO_MATCH != nextMacth) {
                if (search(nextMacth[0], nextMacth[1], word, foundCharIndex))
                    return true;
            }
        }

        solution[x][y]=0;
        return false;

    }

    private boolean isValidNextPosition(int x, int y) {
    final int maxrow=wordGrid.length;
    final int maxcol=wordGrid[0].length;
        return x>=0&&x<maxrow &&y>=0&& y<maxcol && solution[x][y]==0;
    }

    private List<int[]> getXYofNextMacth(int x, int y, char[] word, int foundCharIndex) {
        final List<int[]> allNextMatches=new ArrayList<>();
        if(isValidNextPosition(x+1,y+1) && wordGrid[x+1][y+1]==word[foundCharIndex]){
        allNextMatches.add(new int[]{x+1,y+1});
    }
        if(isValidNextPosition(x+1,y-1)&& wordGrid[x+1][y-1]==word[foundCharIndex]){
            allNextMatches.add(new int[]{x+1,y-1});
        }
        if(isValidNextPosition(x+1,y)&&wordGrid[x+1][y]==word[foundCharIndex]){
            allNextMatches.add(new int[]{x+1,y});
        }

        if(isValidNextPosition(x-1,y)&&wordGrid[x-1][y]==word[foundCharIndex]){
            allNextMatches.add(new int[]{x-1,y});
        }
        if(isValidNextPosition(x-1,y+1)&&wordGrid[x-1][y+1]==word[foundCharIndex]){
            allNextMatches.add(new int[]{x-1,y+1});
        }
        if(isValidNextPosition(x-1,y-1)&&wordGrid[x-1][y-1]==word[foundCharIndex]){
            allNextMatches.add(new int[]{x-1,y-1});
        }
        if(isValidNextPosition(x,y-1)&&wordGrid[x][y-1]==word[foundCharIndex]){
            allNextMatches.add(new int[]{x,y-1});
        }
        if(isValidNextPosition(x,y+1)&&wordGrid[x][y+1]==word[foundCharIndex]){
            allNextMatches.add(new int[]{x,y+1});
        }
    return allNextMatches;
    }

    void printSolution(){
        for (int i = 0; i <solution.length ; i++) {
            for (int j = 0; j <solution[0].length ; j++)
            {
                System.out.print(String.format("%2d",solution[i][j]));
            }
            System.out.println();
        }
    }
    void printGrid(){
        for (int i = 0; i <solution.length ; i++) {
            for (int j = 0; j <solution[0].length ; j++)
            {
                System.out.print(wordGrid[i][j]+" ");
            }
            System.out.println();
        }
    }

}
