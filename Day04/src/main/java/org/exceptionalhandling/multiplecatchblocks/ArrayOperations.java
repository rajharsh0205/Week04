package org.exceptionalhandling.multiplecatchblocks;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayOperations {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Initializing array as null
        int[] array = null;

        try {
            // Asking user to input array size
            System.out.println("Enter the size of the array: ");
            int size = input.nextInt();

            // Creating the array with the given size
            array = new int[size];

            // Filling the array with user input
            System.out.println("Enter " + size + " elements:");
            for (int i = 0; i < size; i++) {
                array[i] = input.nextInt();
            }

            // Asking for the index to retrieve the value
            System.out.println("Enter the index to retrieve the value: ");
            int index = input.nextInt();

            // Retrieving and printing the value at the specified index
            int value = getValueAtIndex(array, index);
            System.out.println("Value at index " + index + ": " + array[index]);

        } catch (ArrayIndexOutOfBoundsException e) {
            // Handling case when index is out of bounds
            System.out.println("Invalid index!");
        } catch (NullPointerException e) {
            // Handling case when the array is null
            System.out.println("Array is not initialized!");
        } catch (Exception e) {
            // Handling any other unexpected exceptions
            System.out.println("An unexpected error occurred.");
        } finally {
            // Closing the Scanner
            input.close();
            System.out.println("Program execution completed.");
        }
    }
    // Method to retrieve a value from the array at the specified index
    public static int getValueAtIndex(int[] array, int index) throws ArrayIndexOutOfBoundsException, NullPointerException {
        return array[index];
    }
}