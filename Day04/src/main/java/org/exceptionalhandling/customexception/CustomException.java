package org.exceptionalhandling.customexception;

import java.util.Scanner;

public class CustomException {
    // Method to validate age
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            // Throwing custom exception if age is below 18
            throw new InvalidAgeException("Age must be 18 or above.");
        } else {
            // Printing access granted message if age is valid
            System.out.println("Access granted!");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            // Asking the user to enter their age
            System.out.println("Enter your age: ");
            int age = input.nextInt();

            // Calling the validateAge method
            validateAge(age);

        } catch (InvalidAgeException e) {
            // Handling the custom exception and displaying the message
            System.out.println("Exception caught: " + e.getMessage());
        } catch (Exception e) {
            // Handling other exceptions
            System.out.println("Error: Invalid input.");
        } finally {
            // Closing the Scanner
            input.close();
            System.out.println("Program execution completed.");
        }
    }
}
