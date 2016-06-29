package com.bl3e.algo.graph;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by kumarrak on 23/06/16.
 */
public class LargestConnectedComponenet {
    final Map<Integer, Integer> matrixIndexToRegionIndexMap = new HashMap<>();
     final TreeMap<Integer, Integer> regionIndexToRegionCountMap = new TreeMap<>();

    public int getLengthOfLargestRegion(int[][] matrix) {

        final int ROW = matrix.length;
        final int COL = matrix[0].length;

        int lengthOfRegion = 0;

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (matrix[i][j] == 1) {
                    Integer connectedRegionIndex = getIndexOfConnectedRegion(matrix, i, j);
                    if (connectedRegionIndex == null) { //part of new region
                        Integer highestRegionIndex = regionIndexToRegionCountMap.size();
                        connectedRegionIndex = highestRegionIndex + 1;
                        matrixIndexToRegionIndexMap.put(getKey(matrix, i, j),connectedRegionIndex);
                        regionIndexToRegionCountMap.put(connectedRegionIndex, 1);
                        if (lengthOfRegion == 0) {
                            lengthOfRegion = 1;
                        }
                    } else { //part of exisitng region
                         matrixIndexToRegionIndexMap.put(getKey(matrix, i, j),connectedRegionIndex);
                        int regionCount = regionIndexToRegionCountMap.get(connectedRegionIndex);
                        regionIndexToRegionCountMap.put(connectedRegionIndex, regionCount + 1);
                        if (lengthOfRegion < regionCount + 1) {
                            lengthOfRegion = regionCount + 1;
                        }
                    }
                }
            }

        }
        return lengthOfRegion;
    }

    private  Integer getIndexOfConnectedRegion(int[][] matrix, int i, int j) {
        if (j > 0 && matrix[i][j - 1] == 1) // left elem
        {
            Integer regionIndex = matrixIndexToRegionIndexMap.get(getKey(matrix, i, j-1));
            if (regionIndex != null) {
                return regionIndex;
            }
        }
        if (i > 0 && matrix[i - 1][j] == 1) // \ diagonal
        {
            Integer regionIndex = matrixIndexToRegionIndexMap.get(getKey(matrix, i-1, j));
            if (regionIndex != null) {
                return regionIndex;
            }
        }
        if (i > 0 && (j < matrix.length - 1) && matrix[i - 1][j + 1] == 1) // / diagonal
        {
            Integer regionIndex = matrixIndexToRegionIndexMap.get(getKey(matrix, i-1, j+1));
            if (regionIndex != null) {
                return regionIndex;
            }
        }
        if (i > 0 && j > 0 && matrix[i - 1][j - 1] == 1) // | up
        {
            Integer regionIndex = matrixIndexToRegionIndexMap.get(getKey(matrix, i-1, j-1));
            if (regionIndex != null) {
                return regionIndex;
            }
        }
        if (i == 0 && j == 0 && matrix[i][j] == 1) {
            Integer regionIndex = matrixIndexToRegionIndexMap.get(getKey(matrix, i, j));
            if (regionIndex != null) {
                return regionIndex;
            }
        }
        return null;
    }

    private static Integer getKey(int[][] matrix, int i, int j) {
        return i * matrix[0].length + j;
    }

}
