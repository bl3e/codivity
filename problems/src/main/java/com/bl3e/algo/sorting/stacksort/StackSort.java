package com.bl3e.algo.sorting.stacksort;

/**
 * Created by kumarrak on 29/05/16.
 */
public class StackSort {

    public static <T extends Comparable> void sort(BasicStack<T> basicStack, T top) {
        if (basicStack.is_empty()) {
            return;
        }
        T elementOut = basicStack.pop();
        T topElement = basicStack.top();
        if (elementOut.compareTo(topElement) < 0) {
            sort(basicStack, topElement);
            basicStack.push(elementOut);
        } else {
            sort(basicStack, elementOut);
            basicStack.push(topElement);
        }

    }

    public static <T> void reverse(BasicStack<T> basicStack) {

        if (basicStack.is_empty()) {
            return;
        }
        T element = basicStack.pop();
        reverse(basicStack);
        basicStack.push(element);
    }
}
