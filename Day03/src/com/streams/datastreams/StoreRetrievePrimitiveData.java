package com.streams.datastreams;

import java.io.*;

public class StoreRetrievePrimitiveData {
    public static void main(String[] args) {
        String filePath = "students.data"; // Binary file to store student details

        // Writing student data to file
        writeStudentData(filePath);

        // Reading and displaying student data from file
        readStudentData(filePath);
    }

    // Method to write student details using DataOutputStream
    private static void writeStudentData(String filePath) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filePath))) {
            // Writing student records (roll number, name, GPA)
            dos.writeInt(101);
            dos.writeUTF("Harsh");
            dos.writeDouble(7.8);

            dos.writeInt(102);
            dos.writeUTF("Om");
            dos.writeDouble(8.6);

            dos.writeInt(103);
            dos.writeUTF("Raj");
            dos.writeDouble(7.9);

            System.out.println("Student data written successfully.");
        } catch (IOException e) {
            System.out.println("Error writing student data: " + e.getMessage());
        }
    }

    // Method to read student details using DataInputStream
    private static void readStudentData(String filePath) {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(filePath))) {
            System.out.println("\nRetrieved Student Data:");
            while (dis.available() > 0) { // Ensuring there's data left to read
                int rollNo = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();
                System.out.println("Roll No: " + rollNo + ", Name: " + name + ", GPA: " + gpa);
            }
        } catch (IOException e) {
            System.out.println("Error reading student data: " + e.getMessage());
        }
    }
}