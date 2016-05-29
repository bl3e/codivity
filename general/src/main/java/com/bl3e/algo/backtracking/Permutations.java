package com.bl3e.algo.backtracking;

/**
 * Created by kumarrak on 30/04/16.
 */
public class Permutations {

    void permute(int[] a){
       permute(a,a.length);
    }

    private void permute(int[] a, int length) {
    if(length==1){
        printSolution(a);
    return;
    }
        for (int i = 0; i < length; i++) {
            permute(a, length - 1);
            int j;
            if (length % 2 == 1) {
                j = 0;
            } else {
                j = i;
            }
            swap(a, j, length - 1);

        }
    }


    private void swap(int[] a, int j, int length) {
        int temp=a[length];
        a[length]=a[j];
        a[j]=temp;
    }

    private void printSolution(int[] a) {
    for (int i:a){
    System.out.print(i+" ");
    }
        System.out.println();
    }


    /* */
    void generatePermutations(int n){
        int a[]=new int[n];
        backtrackSubset(a,-1,a.length);
    }

    void backtrackSubset(int[] a, int k, int candidateNum) {
        int[] candidateSolution = new int[a.length];
        if (isSolution(a, k, candidateNum)) {
            processSolution(a, k, candidateNum);
        } else {
            k = k + 1;
            candidateNum= constructNextCandidate(a, k, candidateSolution, candidateNum);
            for (int i = 0; i < candidateNum; i++) {
                if(k<a.length)
                    a[k] = candidateSolution[i];
                backtrackSubset(a, k, candidateNum);
            }
        }
    }

    private boolean isSolution(int[] a, int k, int candidateNum) {
        if(k==a.length)
            return true;
        return false;
    }

    private void processSolution(int[] a, int k, int candidateNum) {
        System.out.print("{");
        for (int i = 0; i <k ; i++) {
                int num=a[i];
                System.out.print(num+" ");

        }
        System.out.print("}");
        System.out.println();

    }

    private int constructNextCandidate(int[] a, int k, int[] candidateSolution, int candidateNum) {
        int counter;
        boolean inPerm[]=new boolean[a.length];
        for (int i = 0; i < inPerm.length; i++) {
        inPerm[i]=false;
        }

        for (int i = 0; i <k ; i++) {
            if(a[i]<a.length)
            if(inPerm[a[i]]==false){
                candidateSolution[candidateNum]=i;
                candidateNum++;
            }
            return  candidateNum;
        }

        return  candidateNum;
    }
}
