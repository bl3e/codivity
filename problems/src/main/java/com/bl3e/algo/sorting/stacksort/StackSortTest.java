package com.bl3e.algo.sorting.stacksort;

import org.junit.Test;

/**
 * Created by kumarrak on 29/05/16.
 */
public class StackSortTest {

    @Test
   public void reverse(){
        BasicStack<Integer> stack=new BasicStack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.top());
        StackSort.reverse(stack);
        System.out.println(stack.top());
    }
}
