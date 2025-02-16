package org.exceptionalhandling.throwvsthrows;

public class InterestCalculator {

    // Defining a method that throws IllegalArgumentException if the input is invalid
    public static double calculateInterest(double amount, double rate, int years) throws IllegalArgumentException {
        // Checking if amount or rate is negative and throwing an exception
        if (amount < 0 || rate < 0) {
            throw new IllegalArgumentException("Amount and rate must be positive.");
        }

        // Calculating the interest
        return amount * rate * years / 100;
    }

    public static void main(String[] args) {
        try {
            // Calling the calculateInterest method with sample values
            double interest = calculateInterest(1000, -5, 2);
            System.out.println("Calculated Interest: " + interest);
        } catch (IllegalArgumentException e) {
            // Handling the propagated exception and printing a user-friendly message
            System.out.println("Invalid input: Amount and rate must be positive.");
        }
    }
}