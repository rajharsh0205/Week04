package com.streams.countwordsinfile;

import java.io.*;
import java.util.*;

public class WordCounter {
    public static void main(String[] args) {
        // Path to the input text file
        String fileName = "C:\\Users\\rajha\\OneDrive\\Desktop\\CG_Java\\Week04\\Day03\\src\\com\\streams\\countwordsinfile\\wordcount.txt";

        // Map to store words and their corresponding frequencies
        Map<String, Integer> wordCount = new HashMap<>();

        // Try-with-resources to ensure BufferedReader is closed automatically
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;

            // Read the file line by line
            while ((line = reader.readLine()) != null) {
                // Convert line to lowercase, remove special characters, and split into words
                String[] words = line.toLowerCase().replaceAll("[^a-zA-Z ]", "").split("\\s+");

                // Iterate over words and update their count in the map
                for (String word : words) {
                    if (!word.isEmpty()) { // Ensure word is not empty
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            // Handle file reading errors
            System.out.println("Error reading file: " + e.getMessage());
        }

        // Convert map entries to a list for sorting
        List<Map.Entry<String, Integer>> sortedWords = new ArrayList<>(wordCount.entrySet());

        // Sort words in descending order based on their frequency
        sortedWords.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        // Display the top 5 most frequent words
        System.out.println("Top 5 most frequent words:");
        for (int i = 0; i < Math.min(5, sortedWords.size()); i++) {
            System.out.println(sortedWords.get(i).getKey() + ": " + sortedWords.get(i).getValue());
        }
    }
}