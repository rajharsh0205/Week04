package com.junit.basicjunittest;

import java.util.*;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Taking user input
        System.out.print("Enter first number: ");
        int a = sc.nextInt();

        System.out.print("Enter second number: ");
        int b = sc.nextInt();

        System.out.println("Addition of two numbers a and b are: "+add(a,b));
        System.out.println("Subtraction of two numbers a and b are: "+ subtract(a,b));
        System.out.println("Multiplication of two numbers a and b are: "+multiply(a,b));
        System.out.println("Division of two numbers a and b are: "+divide(a,b));
        sc.close();
    }

    //Method to perform addition
    public static int add(int a, int b){
        return a+b;
    }

    //Method to perform subtraction
    public static int subtract(int a, int b){
        return a-b;
    }

    //Method to perform multiplication
    public static int multiply(int a, int b){
        return a*b;
    }

    //Method to perform division
    public static int divide(int a, int b){
        return a/b;
    }

}
