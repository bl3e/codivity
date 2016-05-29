package com.bl3e.algo.sorting.stacksort;

import java.util.Stack;

/**
 * Created by kumarrak on 29/05/16.
 */
public class BasicStack<T> {
    private Stack<T> stack;

    BasicStack(){
        stack=new Stack<>();
    }
    public boolean is_empty() {
        return stack.empty();
    }

    public void push(T element){
        stack.add(element);
    }
    public T pop(){
        return stack.pop();
    }

    public T top(){
        return stack.peek();
    }

    @Override
    public String toString(){
        return stack.toString();
    }
}
