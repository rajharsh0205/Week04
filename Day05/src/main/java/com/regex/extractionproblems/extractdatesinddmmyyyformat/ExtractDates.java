package com.regex.extractionproblems.extractdatesinddmmyyyformat;

import java.util.regex.*;
import java.util.*;

public class ExtractDates {
    public static void main(String[] args) {
        String text = "The events are scheduled for 12/05/2023, 15/08/2024, and 29/02/2020.";

        List<String> dates = extractDates(text);

        // Print extracted dates
        System.out.println(String.join(", ", dates));
    }

    public static List<String> extractDates(String text) {
        List<String> dates = new ArrayList<>();
        String regex = "\\b(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}\\b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            dates.add(matcher.group());
        }

        return dates;
    }
}
