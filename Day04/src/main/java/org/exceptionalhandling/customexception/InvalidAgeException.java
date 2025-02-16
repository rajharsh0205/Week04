package org.exceptionalhandling.customexception;

// Defining the custom exception class
public class InvalidAgeException extends Exception {
    // Constructor for custom exception
    public InvalidAgeException(String message) {
        super(message);
    }
}