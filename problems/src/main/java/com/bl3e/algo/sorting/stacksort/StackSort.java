package com.bl3e.algo.sorting.stacksort;

/**
 * Created by kumarrak on 29/05/16.
 */
public class StackSort {
    public enum SortOrder {
        ASCENDING(1),
        DECENDING(-1);
        int order;

        SortOrder(int order) {
            this.order = order;
        }
        int getOrder(){
            return order;
        }
    }

    public static <T extends Comparable> void sort(BasicStack<T> basicStack,SortOrder sortOrder) {
        if (basicStack.is_empty()) {
            return;
        }
        T poppedElem = basicStack.pop();
        sort(basicStack, poppedElem, sortOrder);
    }

    /**
     * @param basicStack
     * @param outElement
     * @param <T>
     */
    private static <T extends Comparable> void sort(BasicStack<T> basicStack, T outElement,final SortOrder sortOrder) {
        if (basicStack.is_empty()) {
            if (outElement != null) {
                basicStack.push(outElement);
            }
            return;
        }

        T poppedElement = basicStack.pop();

        if (outElement.compareTo(poppedElement)* sortOrder.getOrder() > 0) {
            isPushed = false;
            pushAtSortedPosition(basicStack, outElement, sortOrder);
            sort(basicStack, poppedElement, sortOrder);
        } else {
            sort(basicStack, outElement, sortOrder);
            isPushed = false;
            pushAtSortedPosition(basicStack, poppedElement, sortOrder);
        }
    }

    static boolean isPushed = false;

    static <T extends Comparable> void pushAtSortedPosition(BasicStack<T> stack, T element,final SortOrder sortOrder) {
        if (stack.is_empty())
            return;
        T elem = stack.top();
        if (elem.compareTo(element)* sortOrder.getOrder() > 0) {
            T popped = stack.pop();
            pushAtSortedPosition(stack, element, sortOrder);
            if (!isPushed) {
                stack.push(element);
                isPushed = true;
            }
            stack.push(popped);
        } else {
            if (!isPushed) {
                stack.push(element);
                isPushed = true;
            }
        }

    }

    public static <T> void recursiveRebuildStack(BasicStack<T> basicStack) {

        if (basicStack.is_empty()) {
            return;
        }
        T element = basicStack.pop();
        recursiveRebuildStack(basicStack);
        basicStack.push(element);
    }
}
