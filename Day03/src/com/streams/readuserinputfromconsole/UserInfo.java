package com.streams.readuserinputfromconsole;

import java.io.*;

public class UserInfo {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = "", language = "";
        int age = 0;

        try {
            System.out.print("Enter your name: ");
            name = reader.readLine();

            System.out.print("Enter your age: ");
            age = Integer.parseInt(reader.readLine());

            System.out.print("Enter your favorite programming language: ");
            language = reader.readLine();

            // Writing to a file
            try (FileWriter writer = new FileWriter("C:\\Users\\rajha\\OneDrive\\Desktop\\CG_Java\\Week04\\Day03\\src\\com\\streams\\readuserinputfromconsole\\userinformation.txt" +
                    "")) {
                writer.write("Name: " + name + "\n");
                writer.write("Age: " + age + "\n");
                writer.write("Favorite Programming Language: " + language + "\n");
                System.out.println("Information saved to userinformation.txt");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading input or writing to file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input for age. Please enter a valid number.");
        }
    }
}