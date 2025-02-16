package com.junit.basicjunittest;

import java.util.Scanner;

public class StringUtility  {

    // Method to reverse a string
    public static String reverse(String str) {
        if (str == null) return null;
        char[] chars = str.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }

    // Method to check if a string is a palindrome
    public static boolean isPalindrome(String str) {
        if (str == null) return false;
        int left = 0, right = str.length() - 1;
        while (left < right) {
            char leftChar = toLowerCaseForComparison(str.charAt(left));
            char rightChar = toLowerCaseForComparison(str.charAt(right));
            if (leftChar != rightChar) return false;
            left++;
            right--;
        }
        return true;
    }

    // Method to convert a string to uppercase
    public static String toUpperCase(String str) {
        if (str == null) return null;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'a' && chars[i] <= 'z') {
                chars[i] = (char) (chars[i] - ('a' - 'A'));
            }
        }
        return new String(chars);
    }

    // method to convert an uppercase character to lowercase for case-insensitive comparison
    private static char toLowerCaseForComparison(char c) {
        if (c >= 'A' && c <= 'Z') {
            return (char) (c + ('a' - 'A'));
        }
        return c;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        System.out.println("Reversed: " + reverse(str));
        System.out.println("Is Palindrome? " + isPalindrome(str));
        System.out.println("Uppercase: " + toUpperCase(str));

        sc.close();
    }
}
