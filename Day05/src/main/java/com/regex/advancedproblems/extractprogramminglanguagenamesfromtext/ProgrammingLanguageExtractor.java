package com.regex.advancedproblems.extractprogramminglanguagenamesfromtext;

import java.util.regex.*;
import java.util.*;

public class ProgrammingLanguageExtractor {
    public static void main(String[] args) {
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";

        List<String> languages = extractLanguages(text);

        // Print extracted programming languages
        System.out.println(String.join(", ", languages));
    }

    public static List<String> extractLanguages(String text) {
        List<String> languages = new ArrayList<>();
        List<String> knownLanguages = Arrays.asList("Java", "Python", "JavaScript", "Go", "C", "C++", "Ruby", "Swift", "Kotlin", "PHP", "Rust", "Perl");

        for (String lang : knownLanguages) {
            String regex = "\\b" + lang + "\\b";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(text);
            if (matcher.find()) {
                languages.add(lang);
            }
        }

        return languages;
    }
}