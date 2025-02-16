package com.regex.advancedproblems.validatesocialsecuritynumber;


public class ValidateSSN {
    public static void main(String[] args) {
        String[] testSSNs = {
                "123-45-6789", // Valid
                "123456789",   // Invalid (No dashes)
                "000-12-3456", // Invalid (First part can't be 000)
                "666-45-6789", // Invalid (First part can't be 666)
                "900-45-6789", // Invalid (900-999 are invalid)
                "123-4-6789",  // Invalid (Middle part must be 2 digits)
                "123-45-678"   // Invalid (Last part must be 4 digits)
        };

        for (String ssn : testSSNs) {
            System.out.println(ssn + " -> " + (isValidSSN(ssn) ? "Valid" : "Invalid"));
        }
    }

    public static boolean isValidSSN(String ssn) {
        String regex = "^(?!000|666|9\\d{2})\\d{3}-"
                + "(?!00)\\d{2}-"
                + "(?!0000)\\d{4}$";

        return ssn.matches(regex);
    }
}
