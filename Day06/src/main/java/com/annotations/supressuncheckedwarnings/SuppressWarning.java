package com.annotations.supressuncheckedwarnings;

import java.util.ArrayList;
import java.lang.SuppressWarnings;

public class SuppressWarning {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        // Creating an ArrayList without generics
        ArrayList list = new ArrayList();

        // Adding elements of different types
        list.add("Hello");
        list.add(100);
        list.add(3.14);

        // Printing the list
        System.out.println(list);
    }
}