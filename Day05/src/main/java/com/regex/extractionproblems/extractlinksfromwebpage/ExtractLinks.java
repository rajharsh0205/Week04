package com.regex.extractionproblems.extractlinksfromwebpage;

import java.util.regex.*;
import java.util.*;

public class ExtractLinks {
    public static void main(String[] args) {
        String text = "Visit https://www.google.com and http://example.org for more info.";

        List<String> links = extractURLs(text);

        // Print extracted links
        System.out.println(String.join(", ", links));
    }

    public static List<String> extractURLs(String text) {
        List<String> links = new ArrayList<>();
        String regex = "\\bhttps?://[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}\\S*\\b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            links.add(matcher.group());
        }

        return links;
    }
}
