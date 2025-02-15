package com.regex.basicregexproblem.validatehexcolorcode;

import java.util.Scanner;

public class ValidateHexColorCode {
    public static boolean isValidHexColor(String color) {
        // Regex pattern: Starts with #, followed by exactly 6 hex digits (case insensitive)
        String regex = "^#([A-Fa-f0-9]{6})$";
        return color.matches(regex);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a hex color code: ");
        String color = scanner.nextLine();

        if (isValidHexColor(color)) {
            System.out.println("Valid hex color code!");
        } else {
            System.out.println("Invalid hex color code!");
        }

        scanner.close();
    }
}
