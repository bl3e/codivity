package com.bl3e.algo.hackerearth.easyjune;


import java.io.*;

/**
 * Created by kumarrak on 02/06/16.
 */
public class BennyShopping {
    final static char DOLLAR = '$';

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            String orderDesc = br.readLine();
            int dollarIndex = getIndexOfDollar(orderDesc);
             printPrice(orderDesc.toCharArray(), dollarIndex,pw);
        }
        pw.close();
    }

    private static int getIndexOfDollar(String orderDesc) {
        char[] arr = orderDesc.toCharArray();
        for (int i = 0; i < orderDesc.length(); i++) {
            if (arr[i] == DOLLAR)
                return i;
        }
        return -1;
    }

    private static void printPrice(char[] arr, int dollarIndex, PrintWriter pw) {
        pw.print("$");
        int highestIndex = 0;
        int count=0;
        int i=dollarIndex+1;
         while (i < arr.length-1) {
            if (arr[i] == '0' || arr[i] == ' ') {
               i++;
            }else
                break;
        }
        highestIndex = i;
            for (int j = highestIndex; j <arr.length; j++) {
                if(arr[j]==' '){
                    continue;
                }
                else if (arr[j]-48<=9&&arr[j]-48>=0){
                    pw.print(arr[j]);
                    count++;
                }
                else
                    break;

            }
        if(count==0)
            pw.print('0');
        pw.println();
    }

    static long sumPrice(char[] arr, int arrayIndex) {
        int position = -1;
        for (int i = arrayIndex; i < arr.length; i++) {
            if (Character.isDigit(arr[i])) {
                position++;
            } else if (!Character.isWhitespace(arr[i]))
                break;
        }
        int sum = 0;
        for (int i = arrayIndex; i < arr.length; i++) {
            if (Character.isDigit(arr[i])) {
                int placeValue = Character.getNumericValue(arr[i]);
                sum += placeValue * Math.pow(10, position);
                position--;
            }
        }
        return sum;
    }


    static int calculatePrice(char[] arr, int arrayIndex, int position) {
        if (arrayIndex >= arr.length || position >= arr.length)
            return position;
        if (arr[arrayIndex] == ' ') {
            return calculatePrice(arr, arrayIndex + 1, position);
        } else if (Character.isDigit(arr[arrayIndex])) {
            int placevalue = Character.getNumericValue(arr[arrayIndex]);
            int value = placevalue * (int) Math.pow(10, calculatePrice(arr, arrayIndex + 1, position + 1));

        } else {
            return 0;
        }
        return 0;
    }
}