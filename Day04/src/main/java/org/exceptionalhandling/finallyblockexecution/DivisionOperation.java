package org.exceptionalhandling.finallyblockexecution;

import java.util.InputMismatchException;
import java.util.Scanner;


public class DivisionOperation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            // Taking two integers from the user
            System.out.print("Enter the first integer: ");
            int num1 = input.nextInt();

            System.out.print("Enter the second integer: ");
            int num2 = input.nextInt();

            // Performing division
            int result = divide(num1, num2);
            System.out.println("Result: " + result);

        } catch (ArithmeticException e) {
            // Handling division by zero exception
            System.out.println("Error: Division by zero is not allowed.");

        } catch (InputMismatchException e) {
            // Handling non-integer input
            System.out.println("Error: Please enter valid integers.");

        } finally {

            input.close();
            // Ensuring this block always executes
            System.out.println("Operation completed.");
        }
    }

    //method to divide
    public static int divide(int num1, int num2) throws ArithmeticException {
        // Performing division
        int result = num1 / num2;
        return result;
    }
}
