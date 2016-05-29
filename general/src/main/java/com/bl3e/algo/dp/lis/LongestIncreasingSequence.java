package com.bl3e.algo.dp.lis;

/**
 * Created by kumarrak on 24/05/16.
 */
public class LongestIncreasingSequence {
//LIS for { 10, 22, 9, 33, 21, 50, 41, 60, 80 } is 6 and LIS is {10, 22, 33, 50, 60, 80}.

    static int lengthofLIS_incorrect(int[] arr) {
        return lengthofLIS_incorrect(arr, 0, arr.length - 1);
    }

    //an incorrect recursive equation
    private static int lengthofLIS_incorrect(int[] arr, int start, int end) {
        if (end == start) {
            System.out.print(arr[end] + " ");
            return 1;
        }
        if (arr[end] > arr[end - 1]) {

            int len = lengthofLIS_incorrect(arr, start, end - 1) + 1;
            System.out.print(arr[end] + " ");
            return len;
        } else
            return lengthofLIS_incorrect(arr, start, end - 1);
    }

    static int lengthOfLIS(int[] arr) {
        return getLengthofLIS(arr, arr.length - 1);
    }

    static int maxInSubSequence = Integer.MIN_VALUE;
    static int lengthOfLIS = -1;

    private static int getLengthofLIS(int[] arr, int lastIndex) {
        if (lastIndex == 0) {
            maxInSubSequence = arr[0];
            return 1;
        }

        for (int i = 1; i <= lastIndex; i++) {
            if (arr[i] > maxInSubSequence) {
                int len = getLengthofLIS(arr, i - 1) + 1;
                maxInSubSequence = arr[i];
                if (len > lengthOfLIS) {
                    lengthOfLIS = len;
                }
            }
        }
        return lengthOfLIS;
    }

}
