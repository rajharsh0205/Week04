package com.collection.listinterface;

import java.util.*;

public class RemoveDuplicates {
    public static <T> List<T> removeDuplicates(List<T> list) {
        Set<T> seen = new HashSet<>();
        List<T> uniqueList = new ArrayList<>();
        for (T item : list) {
            if (seen.add(item)) {
                uniqueList.add(item);
            }
        }
        return uniqueList;
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 1, 2, 2, 3, 4);
        System.out.println("List after removing duplicates: " + removeDuplicates(numbers));
    }
}