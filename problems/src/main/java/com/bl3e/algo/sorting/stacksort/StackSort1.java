package com.bl3e.algo.sorting.stacksort;

import java.util.Stack;

/**
 * Created by kumarrak on 01/06/16.
 */class SortStack1{

    public static void main(String[] args) {
        Stack<Integer> s = new Stack();
       /* s.push(3);
        s.push(2);
        s.push(-1);
        s.push(0);
        s.push(4);
        s.push(-3);*/

        s.push(80);
        s.push(55);
        s.push(90);
        s.push(14);
        s.push(25);
        sortStack(s);
        System.out.println("stack after sort:  "+s.toString());
    }
    private static void sortStack(Stack<Integer> st){
        if (!st.isEmpty()){
            int temp = st.pop();
            sortStack(st);
            sortedInsert(st, temp);
        }
    }

    private static void sortedInsert(Stack<Integer> st, int elm) {
        if (st.isEmpty() || elm < st.peek()){
            st.addElement(elm);
            return;
        }
        int temp = st.pop();
        sortedInsert(st, elm);
        st.push(temp);
        System.out.println("+++++++++ "+st);
    }


}