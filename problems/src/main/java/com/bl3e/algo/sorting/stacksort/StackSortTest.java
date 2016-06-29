package com.bl3e.algo.sorting.stacksort;

import org.junit.Test;

/**
 * Created by kumarrak on 29/05/16.
 */
public class StackSortTest {

    @Test
    public void sortAscending(){
        BasicStack<Integer> stack=new BasicStack<Integer>();
        stack.push(8);
        stack.push(6);
        stack.push(9);
        stack.push(14);
        stack.push(25);
        System.out.println(stack);
        StackSort.sort(stack, StackSort.SortOrder.ASCENDING);
        System.out.println(stack);
    }

    @Test
    public void sortDescending(){
        BasicStack<Integer> stack=new BasicStack<Integer>();
        stack.push(8);
        stack.push(6);
        stack.push(9);
        stack.push(14);
        stack.push(25);
        System.out.println(stack);
        StackSort.sort(stack, StackSort.SortOrder.DECENDING);
        System.out.println(stack);
    }

@Test
public void test(){
    int a='0';
    int i='1';
    int j='2';
    int k='3';
    int m='9';
    System.out.println(a);
    System.out.println(i);
    System.out.println(j);
    System.out.println(k);
    System.out.println(m);
}
    @Test
    public void sort2Ascending(){
        BasicStack<Integer> stack=new BasicStack<Integer>();
        stack.push(80);
        stack.push(55);
        stack.push(90);
        stack.push(14);
        stack.push(25);
        System.out.println(stack);
        StackSort.sort(stack, StackSort.SortOrder.ASCENDING);
        System.out.println(stack);
    }

    @Test
    public void sort2Descending(){
        BasicStack<Integer> stack=new BasicStack<Integer>();
        stack.push(80);
        stack.push(55);
        stack.push(90);
        stack.push(14);
        stack.push(25);
        System.out.println(stack);
        StackSort.sort(stack, StackSort.SortOrder.DECENDING);
        System.out.println(stack);
    }

    @Test
   public void recursiveRebuildStack(){
        BasicStack<Integer> stack=new BasicStack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.top());
        StackSort.recursiveRebuildStack(stack);
        System.out.println(stack.top());
    }
}
