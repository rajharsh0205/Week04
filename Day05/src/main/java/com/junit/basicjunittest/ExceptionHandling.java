package com.junit.basicjunittest;

import java.util.*;

public class ExceptionHandling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //taking input
        System.out.print("Enter first number a: ");
        int a = sc.nextInt();

        System.out.print("Enter second number b: ");
        int b = sc.nextInt();

        int result = divide(a,b); //call divide method
        System.out.println("a divided by b equals: " + result);

    }
    public static int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero"); //throw exception
        }
        return a / b;
    }
}
