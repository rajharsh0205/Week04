package org.exceptionalhandling.checkedexception;

import java.io.*;

public class CheckedException {
    public static void main(String[] args) {
        // Defining the file to be read
        File file = new File("C:\\Users\\rajha\\OneDrive\\Desktop\\CG_Java\\Week04\\Day04\\src\\main\\java\\org\\exceptionalhandling\\checkedexception\\data.txt");

        try {
            // Creating a FileReader and BufferedReader to read the file
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            // Reading and printing the file contents line by line
            String line;
            System.out.println("File contents:");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            // Closing the BufferedReader
            br.close();

        } catch (IOException e) {
            // Handling IOException if the file does not exist or cannot be read
            System.out.println("File not found. Please check the file name and try again.");
        }
    }
}
