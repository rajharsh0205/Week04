package com.collection.listinterface;

import java.util.*;

public class NthElementFromEnd {
    public static <T> T findNthFromEnd(LinkedList<T> list, int n) {
        Iterator<T> first = list.iterator();
        Iterator<T> second = list.iterator();

        for (int i = 0; i < n; i++) {
            if (first.hasNext()) {
                first.next();
            } else {
                throw new IllegalArgumentException("N is larger than the list size");
            }
        }

        while (first.hasNext()) {
            first.next();
            second.next();
        }

        return second.next();
    }

    public static void main(String[] args) {
        LinkedList<String> items = new LinkedList<>(Arrays.asList("A", "B", "C", "D", "E"));
        int n = 2;
        System.out.println("Nth element from end: " + findNthFromEnd(items, n));
    }
}