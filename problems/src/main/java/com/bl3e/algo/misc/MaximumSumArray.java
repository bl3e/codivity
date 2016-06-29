package com.bl3e.algo.misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by kumarrak on 20/06/16.
 */
public class MaximumSumArray {
    private static final java.lang.String SEPARATOR ="," ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numCases = Integer.parseInt(br.readLine());
        while (numCases-- > 0) {
            int[] arr = readInput();
            int maxContigSum = getMaxContigSum(arr);
            int maxNonConticSum=getNonContigSum(arr);
            System.out.println(maxContigSum+" "+maxNonConticSum);
        }
    }

    private static int getNonContigSum(int[] arr) {
       int sum=0;
        for (int i = 0; i <arr.length ; i++) {
            if(arr[i]>0){
                sum+=arr[i];
            }
        }
        return sum;
    }

    private static int getMaxContigSum(int[] arr) {
        int maxSum = 0;
        int sumSoFar = 0;

        for (int i = 0; i <arr.length ; i++) {
            sumSoFar  = sumSoFar + arr[i];
            if(sumSoFar > maxSum){
                maxSum = sumSoFar;
            }
            if(sumSoFar < 0){
                sumSoFar = 0;
            }
        }
        return maxSum;
    }

    private static int[] readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int COLS = Integer.parseInt(br.readLine());
        int[] arr = new int[COLS];
            String rowLine = br.readLine();
            String[] numbers = rowLine.split(SEPARATOR);
        int j=0,k=0;
        while (j < COLS) {
            String number = numbers[k].trim();
            if(!number.isEmpty()) {
                arr[j] = Integer.parseInt(number);
                j++;
            }
            k++;
            }
        return arr;
    }
}
