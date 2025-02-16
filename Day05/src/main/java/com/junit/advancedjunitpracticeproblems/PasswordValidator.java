package com.junit.advancedjunitpracticeproblems;

import java.util.regex.Pattern;

public class PasswordValidator {

    public static boolean isValid(String password) {
        // regex pattern for password validation
        String regex = "^(?=.*[A-Z])(?=.*\\d).{8,}$";


        if (password == null) {
            return false;
        }

        // Use Pattern.matches() to check if the password follows the regex rules
        return Pattern.matches(regex, password);
    }

    public static void main(String[] args) {
        // Test cases for password validation
        System.out.println(isValid("Test1234"));
        System.out.println(isValid("test1234"));

    }
}
