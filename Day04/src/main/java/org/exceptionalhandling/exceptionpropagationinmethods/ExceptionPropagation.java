package org.exceptionalhandling.exceptionpropagationinmethods;

public class ExceptionPropagation {

    // method1() throws an ArithmeticException (10 / 0)
    static void method1() {
        System.out.println("Inside method1");
        // Throws ArithmeticException
        int result = 10 / 0;
    }

    // method2() calls method1()
    public static void method2() {
        System.out.println("Inside method2");
        // Exception propagates to method2()
        method1();
    }

    // main() calls method2() and handles the exception
    public static void main(String[] args) {
        try {
            System.out.println("Inside main");
            // Exception propagates to main()
            method2();
        } catch (ArithmeticException e) {
            System.out.println("Handled exception in main: " + e);
        }
        System.out.println("Program continues...");
    }
}
