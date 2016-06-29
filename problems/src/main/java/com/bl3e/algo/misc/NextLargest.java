package com.bl3e.algo.misc;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by kumarrak on 05/06/16.
 */
public class NextLargest {

    public static<T extends Comparable<? super T>> void printLargest(T[] arr){
        Map<T, T> nextLargestMap = getNextLargest(arr);
        for (T elem:arr){
            T nextHighest = nextLargestMap.get(elem);
            if(nextHighest!=null){
                System.out.println(elem+" "+nextHighest);
            }else {
                System.out.println(elem+" "+-1);
            }
        }
    }
   private static <T extends Comparable<? super T>> Map<T, T> getNextLargest(T[] arr) {
        Stack<T> stack = new Stack<>();
        Map<T,T> nextMap=new LinkedHashMap<>();

        for (int i = 0; i <arr.length ; i++) {
           if(stack.isEmpty()){
               stack.add(arr[i]);
               continue;
           }
            T next=arr[i];
            T top = stack.peek();
            if(next.compareTo(top)<0){
                stack.push(next);
                continue;
            }
            do{
                nextMap.put(top,next);
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(next);
                    break;
                }else{
                    top=stack.peek();
                }
            }while (next.compareTo(top)>0);

        }
        return nextMap;
    }
}
