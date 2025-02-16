package com.regex.extractionproblems.extractallcapitalizedwordsfromsentence;

import java.util.regex.*;
import java.util.*;

public class CapitalWordsExtractor {
    public static void main(String[] args) {
        String text = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";

        List<String> capitalizedWords = extractCapitalizedWords(text);

        // Print extracted capitalized words
        System.out.println(String.join(", ", capitalizedWords));
    }

    public static List<String> extractCapitalizedWords(String text) {
        List<String> capitalizedWords = new ArrayList<>();
        String regex = "\\b[A-Z][a-z]*\\b"; // Matches words starting with an uppercase letter

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            capitalizedWords.add(matcher.group());
        }

        return capitalizedWords;
    }
}
