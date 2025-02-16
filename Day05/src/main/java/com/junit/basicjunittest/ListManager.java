package com.junit.basicjunittest;

import java.util.ArrayList;
import java.util.List;

public class ListManager {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        System.out.println("Original list: " + list);
        System.out.println("Initial size of list: " + getSize(list));

        addElement(list); // add element in list
        System.out.println("List after adding 5:" + list);
        System.out.println("Size of list after adding 5: " + getSize(list));

        removeElement(list); //remove element from list
        System.out.println("List after removing elememt at index 4:" + list);
        System.out.println("Size of list after removing elememt at index 4: " + getSize(list));
    }
    public static void addElement(List<Integer> list){
        list.add(5);
    }

    public static void removeElement(List<Integer> list){
        list.remove(4);
    }

    public static int getSize(List<Integer> list){
        return list.size();
    }
}