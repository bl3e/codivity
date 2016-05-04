package com.my.backtracking;

/**
 * Created by kumarrak on 24/04/16.
 */
public class AllSubsets {

    public  void generateAll(int n){
        boolean a[]=new boolean[n];
        generateAll(a,0,a.length-1);
    }
    private  void generateAll(boolean a[],int startIndex,int endIndex){
        if(startIndex==endIndex){
            processSolution(a);
            return;
        }
        a[startIndex]=false;
        generateAll(a, startIndex+1, endIndex);
        a[startIndex]=true;
        generateAll(a, startIndex+1, endIndex);

    }

    private void processSolution(boolean[] a) {
        System.out.print(" { ");
        for(int i=0;i<a.length;i++){
            if(a[i]==true){
                int num=i+1;
               System.out.print(num+" ");
            }
        }
        System.out.println(" } ");
    }

    /* general backtracking demo ,ignore unused variables  */
    void generateSubsets(int n){
        int a[]=new int[n];
        backtrackSubset(a,-1,a.length);
    }

    void backtrackSubset(int[] a, int k, int candidateNum) {
        int[] candidateSolution = new int[2];
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
            if(a[i]==1){
            	int num=i+1;
                System.out.print(num+" ");
            }
        }
    	System.out.print("}");
        System.out.println();

    }

    private int constructNextCandidate(int[] a, int k, int[] candidateSolution, int candidateNum) {

        candidateSolution[0]=1;
        candidateSolution[1]=0;
        candidateNum=2;
        return  candidateNum;
    }
}
