package org.exceptionalhandling.trywithresources;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileWithResources {
    public static void main(String[] args) {
        // Using try-with-resources to ensure resources are closed automatically
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\rajha\\OneDrive\\Desktop\\CG_Java\\Week04\\Day04\\src\\main\\java\\org\\exceptionalhandling\\trywithresources\\info.txt"))) {
            // Reading the first line of the file
            String firstLine = reader.readLine();

            // Checking if the file is empty
            if (firstLine != null) {
                System.out.println("First line: " + firstLine);
            } else {
                System.out.println("File is empty.");
            }
        } catch (IOException e) {
            // Handling IOException if the file does not exist or there is an error reading it
            System.out.println("Either file not found or Error in reading file.");
        }
    }
}
