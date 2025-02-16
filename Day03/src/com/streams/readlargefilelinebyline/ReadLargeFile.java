package com.streams.readlargefilelinebyline;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadLargeFile {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("C:\\Users\\rajha\\OneDrive\\Desktop\\CG_Java\\Week04\\Day03\\src\\com\\streams\\readlargefilelinebyline\\file500.txt");

            // Using BufferedReader
            BufferedReader br = new BufferedReader(fr);

            String line;
            // Read the file line by line
            while ((line = br.readLine()) != null) {
                // Convert the line to lowercase and check if it contains the word "error"
                if (line.toLowerCase().contains("error")) {
                    System.out.println(line);
                }
            }

            br.close();
            fr.close();

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}