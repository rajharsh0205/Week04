package com.junit.basicjunittest;

import java.io.*;

public class FileProcessor {

    // Writes content to a file
    public static void writeToFile(String filename, String content) throws IOException {
        FileWriter writer = new FileWriter(filename);
        writer.write(content);
        writer.close();
    }

    // Reads content from a file
    public static String readFromFile(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        StringBuilder content = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            content.append(line).append("\n");
        }
        reader.close();
        return content.toString().trim(); // Trim to remove the last newline
    }
}
