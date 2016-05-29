package com.bl3e.algo.misc;

import java.util.Arrays;

/**
 * Created by kumarrak on 23/05/16.
 */
public class SeggregateSigns {
    public static void main(String[] args){
        int[] a={-2,3,4,-1};
        new SeggregateSigns().seggregate(a);
        System.out.println(Arrays.toString(a));
    }

    void seggregate(int[] arr){
        int consecutiveSignIndex=-1;
        int nextPositiveIndex=-1;
        int nextNegativeIndex=-1;

        for (int i = 1; i <arr.length ; i++) {
            if (arr[i]*arr[i-1]>0){
                if(arr[i]>0){
                    nextNegativeIndex=getNextNegativeIndex(arr,i);
                    swap(arr,i,nextNegativeIndex);
                }else {
                    nextPositiveIndex=getNextPositiveIndex(arr,i);
                    swap(arr,i,nextPositiveIndex);
                }
            }
        }
    }

    private int getNextPositiveIndex(int[] a,int i) {
        for(int index=i+1;index<a.length;index++){
            if(a[index]>0){
                return index;
            }
        }
        return i;
    }

    private int getNextNegativeIndex(int[]a ,int i) {
        for(int index=i+1;index<a.length;index++){
            if(a[index]<0){
                return index;
            }
        }
        return i;
    }

    private void swap(int[] arr, int i, int j) {
 int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;

    }
}
