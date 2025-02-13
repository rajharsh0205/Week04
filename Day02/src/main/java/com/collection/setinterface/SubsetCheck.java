package com.collection.setinterface;

import java.util.Set;
import java.util.HashSet;

public class SubsetCheck {
    public static boolean isSubset(Set<Integer> subset, Set<Integer> superset) {
        return superset.containsAll(subset);
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Set.of(2, 3));
        Set<Integer> set2 = new HashSet<>(Set.of(1, 2, 3, 4));

        System.out.println("Is Set1 a subset of Set2? " + isSubset(set1, set2));
    }
}