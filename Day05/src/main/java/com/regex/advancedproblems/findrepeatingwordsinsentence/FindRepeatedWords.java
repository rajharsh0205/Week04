package com.regex.advancedproblems.findrepeatingwordsinsentence;

import java.util.*;
import java.util.regex.*;

public class FindRepeatedWords  {
    public static void main(String[] args) {
        String text = "This is is a repeated repeated word test.";

        List<String> repeatingWords = findRepeatingWords(text);

        // Print the repeating words
        System.out.println(String.join(", ", repeatingWords));
    }

    public static List<String> findRepeatingWords(String text) {
        List<String> repeatingWords = new ArrayList<>();
        Map<String, Integer> wordCount = new HashMap<>();

        // Regex to match words (ignoring punctuation)
        String regex = "\\b\\w+\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text.toLowerCase());

        // Count occurrences of each word
        while (matcher.find()) {
            String word = matcher.group();
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Collect words that appear more than once
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() > 1) {
                repeatingWords.add(entry.getKey());
            }
        }

        return repeatingWords;
    }
}
