package com.bl3e.algo.sorting.stacksort;
import java.util.Stack;
/**
 * Created by kumarrak on 29/05/16.
 */public class ReverseStack {

    public static void main(String[] args) {
        Stack<Integer> s = new Stack();
        s.push(10);
        s.push(5);
        s.push(15);
        s.push(20);
        s.push(1);
        reverseUtil(s);
        System.out.println(s);
    }

    private static void reverseUtil(Stack<Integer> s) {
       final int size=s.size();
        for (int i = 0; i < size; i++) {   // for(int i = s.size();i>=0;--i) <for this condition it worked>
            if (!s.isEmpty()){
                System.out.println(i +"= "+s.pop());
            }
        }
    }
}