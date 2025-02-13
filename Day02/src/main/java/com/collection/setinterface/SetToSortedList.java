package com.collection.setinterface;

import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class SetToSortedList {
    public static List<Integer> convertToSortedList(Set<Integer> set) {
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        return list;
    }

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>(Set.of(5, 3, 9, 1));

        System.out.println("Sorted List: " + convertToSortedList(set));
    }
}