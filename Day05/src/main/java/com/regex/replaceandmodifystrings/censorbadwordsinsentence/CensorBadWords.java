package com.regex.replaceandmodifystrings.censorbadwordsinsentence;

import java.util.Arrays;
import java.util.List;

public class CensorBadWords {
    public static void main(String[] args) {
        String text = "This is a damn bad example with some stupid words.";

        List<String> badWords = Arrays.asList("damn", "stupid");

        String censoredText = censorText(text, badWords);

        // Print the censored text
        System.out.println(censoredText);
    }

    public static String censorText(String text, List<String> badWords) {
        for (String word : badWords) {
            text = text.replaceAll("(?i)\\b" + word + "\\b", "****");
        }
        return text;
    }
}
