package org.exceptionalhandling.nestedtrycatchblock;

import java.util.Scanner;

public class NestedTryCatch {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};
        Scanner input = new Scanner(System.in);

        try {
            // Taking user input for index and divisor
            System.out.print("Enter the index of the element you want to access: ");
            int index = input.nextInt();

            try {
                System.out.print("Enter the divisor: ");
                int divisor = input.nextInt();

                try {
                    // Performing division
                    int result = divideElement(numbers, index, divisor);
                    System.out.println("Result of division: " + result);
                } catch (ArithmeticException e) {
                    // Handling division by zero
                    System.out.println("Cannot divide by zero!");
                }

            } catch (ArrayIndexOutOfBoundsException e) {
                // Handling invalid array index
                System.out.println("Invalid array index!");
            }

        } catch (Exception e) {
            // Handling other unexpected exceptions
            System.out.println("An unexpected error occurred: " + e);
        } finally {
            input.close();
            System.out.println("Operation completed.");
        }
    }
    // Method to perform division with an element from the array
    public static int divideElement(int[] array, int index, int divisor) {
        if (array == null) {
            throw new NullPointerException("Array is not initialized!");
        }
        int element = array[index];
        return element / divisor;
    }
}