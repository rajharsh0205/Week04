package com.junit.advancedjunitpracticeproblems;

import java.util.regex.Pattern;

public class UserRegistration {
    public static void registerUser(String username, String email, String password) {
        // Validate username
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty.");
        }

        // Validate email using regex
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        if (email == null || !Pattern.matches(emailRegex, email)) {
            throw new IllegalArgumentException("Invalid email format.");
        }

        // Validate password
        String passwordRegex = "^(?=.*[A-Z])(?=.*\\d).{8,}$";
        if (password == null || !Pattern.matches(passwordRegex, password)) {
            throw new IllegalArgumentException("Password must be at least 8 characters long, contain one uppercase letter and one digit.");
        }
    }

    public static void main(String[] args) {
        try {
            registerUser("Rahul", "rahul.kumar@example.com", "Sarrg123");
            System.out.println("User registered successfully.");
        } catch (IllegalArgumentException e) {
            System.out.println("Registration failed: " + e.getMessage());
        }

        try {
            registerUser("", "invalid-email", "weakpass");
        } catch (IllegalArgumentException e) {
            System.out.println("Registration failed: " + e.getMessage());
        }
    }
}