package com.collection.mapinterface;

import java.util.*;

public class InvertMap {
    public static <K, V> Map<V, List<K>> invertMap(Map<K, V> map) {
        Map<V, List<K>> invertedMap = new HashMap<>();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            invertedMap.computeIfAbsent(entry.getValue(), k -> new ArrayList<>()).add(entry.getKey());
        }
        return invertedMap;
    }

    public static void main(String[] args) {
        Map<String, Integer> input = Map.of("A", 1, "B", 2, "C", 1);
        System.out.println("Inverted Map: " + invertMap(input));
    }
}