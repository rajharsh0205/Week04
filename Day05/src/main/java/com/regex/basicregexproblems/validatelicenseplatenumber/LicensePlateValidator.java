package com.regex.basicregexproblems.validatelicenseplatenumber;

import java.util.Scanner;

public class LicensePlateValidator {
    public static boolean isValidLicensePlate(String plate) {
        // Regex pattern: Two uppercase letters followed by four digits
        String regex = "^[A-Z]{2}[0-9]{4}$";
        return plate.matches(regex);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a license plate number: ");
        String plate = scanner.nextLine();

        if (isValidLicensePlate(plate)) {
            System.out.println("Valid license plate!");
        } else {
            System.out.println("Invalid license plate!");
        }

        scanner.close();
    }
}
