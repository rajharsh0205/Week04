package com.regex.extractionproblems.extractallemailaddressesfromtext;

import java.util.regex.*;
import java.util.*;

public class ExtractEmail {
    public static void main(String[] args) {
        String text = "Contact us at support@example.com and info@company.org";

        List<String> emails = extractEmails(text);

        // Print extracted emails
        for (String email : emails) {
            System.out.println(email);
        }
    }

    public static List<String> extractEmails(String text) {
        List<String> emails = new ArrayList<>();
        String regex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            emails.add(matcher.group());
        }

        return emails;
    }
}
