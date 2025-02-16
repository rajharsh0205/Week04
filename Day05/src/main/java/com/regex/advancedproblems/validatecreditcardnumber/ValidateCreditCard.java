package com.regex.advancedproblems.validatecreditcardnumber;

public class ValidateCreditCard {
    public static void main(String[] args) {
        String[] testCards = {
                "4111111111111111", // Valid Visa
                "5500000000000004", // Valid MasterCard
                "1234567812345678", // Invalid (Doesn't start with 4 or 5)
                "4111-1111-1111-1111", // Invalid (Has dashes)
                "5105105105105100", // Valid MasterCard
                "4111111111111" // Invalid (Visa must have 16 digits)
        };

        for (String card : testCards) {
            System.out.println(card + " -> " + isValidCreditCard(card));
        }
    }

    public static boolean isValidCreditCard(String cardNumber) {
        String regex = "^(4\\d{15}|5[1-5]\\d{14})$";

        return cardNumber.matches(regex);
    }
}

