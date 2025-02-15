package com.regex.basicregexproblems.validateusername;

import java.util.Scanner;

public class ValidateUsername {

    // Method to check if the username is valid
    public static boolean isValid(String str) {
        // Regular Expression:
        String regex = "^[a-zA-Z][a-zA-Z0-9_]{4,14}$";

        // Returns true if the username matches the regex, false otherwise
        return str.matches(regex);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Prompt user to enter a username
        System.out.println("Enter Username: ");
        String input = sc.nextLine();

        // Validate the username and display the result
        if (isValid(input)) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
        // Close Scanner
        sc.close();
    }
}
