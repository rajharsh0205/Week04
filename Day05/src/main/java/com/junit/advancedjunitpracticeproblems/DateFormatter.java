package com.junit.advancedjunitpracticeproblems;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateFormatter {

    public static String formatDate(String inputDate) {
        if (inputDate == null || inputDate.isEmpty()) {
            return null; // Return null for null or empty input
        }

        try {
            // Define the input date format (yyyy-MM-dd)
            DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            // Parse the input date
            LocalDate date = LocalDate.parse(inputDate, inputFormatter);

            // Define the output date format (dd-MM-yyyy)
            DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

            // Format and return the date
            return date.format(outputFormatter);
        } catch (DateTimeParseException e) {
            return null; // Return null (invalid date)
        }
    }

    public static void main(String[] args) {
        System.out.println(formatDate("2024-02-15"));
        System.out.println(formatDate("1999-12-31"));

    }
}