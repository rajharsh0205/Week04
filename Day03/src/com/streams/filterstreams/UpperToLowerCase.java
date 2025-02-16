package com.streams.filterstreams;

import java.io.*;

public class UpperToLowerCase {
    public static void main(String[] args) {
        try {
            // Reading from the input file
            FileReader fr = new FileReader("C:\\Users\\rajha\\OneDrive\\Desktop\\CG_Java\\Week04\\Day03\\src\\com\\streams\\filterstreams\\fileread.txt");
            BufferedReader br = new BufferedReader(fr); // Using BufferedReader

            // Writing to the output file
            FileWriter fw = new FileWriter("C:\\Users\\rajha\\OneDrive\\Desktop\\CG_Java\\Week04\\Day03\\src\\com\\streams\\filterstreams\\filewrite.txt");
            BufferedWriter bw = new BufferedWriter(fw); // Using BufferedWriter

            String line;
            // Reading each line from input file
            while ((line = br.readLine()) != null) {
                // Convert the line to lowercase and write to output file
                bw.write(line.toLowerCase());
                bw.newLine();
            }

            bw.close();
            fw.close();
            br.close();
            fr.close();

            System.out.println("File conversion completed successfully.");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}