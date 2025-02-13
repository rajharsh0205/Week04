package com.collection.setinterface;

import java.util.Set;
import java.util.HashSet;

public class SetEquality {
    public static boolean areSetsEqual(Set<Integer> set1, Set<Integer> set2) {
        return set1.equals(set2);
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Set.of(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Set.of(3, 2, 1));

        System.out.println("Are sets equal? " + areSetsEqual(set1, set2)); // Output:true
    }
}