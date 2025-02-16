package com.streams.filehandling;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReadAndWriteTextFile {
    public static void main(String[] args) {
        try {
            // Create a FileInputStream to read from the input file
            FileInputStream fis = new FileInputStream("C:\\Users\\rajha\\OneDrive\\Desktop\\CG_Java\\Week04\\Day03\\src\\com\\streams\\filehandling\\readfile.txt");

            // Create a FileOutputStream to write to the output file
            FileOutputStream fos = new FileOutputStream("C:\\Users\\rajha\\OneDrive\\Desktop\\CG_Java\\Week04\\Day03\\src\\com\\streams\\filehandling\\writefile.txt");

            int byteData; // Variable to store each byte read from the file

            // Read bytes from the input file and write them to the output file
            while ((byteData = fis.read()) != -1) {  // Read until end of file (-1)
                fos.write(byteData);  // Write the read byte to the output file
            }

            fis.close();
            fos.close();

            System.out.println("File copied successfully!");

        } catch (IOException e) {
            // Handle any IOException
            System.out.println("Error: " + e.getMessage());
        }
    }
}