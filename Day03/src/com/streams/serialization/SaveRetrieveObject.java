package com.streams.serialization;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Employee class implementing Serializable
class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    int id;
    String name;
    String department;
    double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }


    @Override
    public String toString() {
        return "Employee [ID=" + id + ", Name=" + name + ", Department=" + department + ", Salary=" + salary + "]";
    }
}

public class SaveRetrieveObject {
    public static void main(String[] args) {
        // Creating a list of employees with sample data
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1, "Raj", "IT", 60000));
        employeeList.add(new Employee(2, "Gagan", "HR", 55000));
        employeeList.add(new Employee(3, "Shubham", "Finance", 50000));

        // File path for serialization
        String fileName = "employees.ser";

        // Serializing the employee list to a file
        serializeEmployeeList(employeeList, fileName);

        // Deserializing the employee list from the file
        List<Employee> deserializedList = deserializeEmployeeList(fileName);

        // Displaying the deserialized employee list
        System.out.println("\nDeserialized Employee List:");
        if (deserializedList != null) {
            for (Employee employee : deserializedList) {
                System.out.println(employee);
            }
        } else {
            System.out.println("Failed to deserialize employees.");
        }
    }

    // Method to serialize the list of employees
    private static void serializeEmployeeList(List<Employee> employeeList, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(employeeList);
            System.out.println("Employee list has been serialized to " + fileName);
        } catch (IOException e) {
            System.out.println("Error during serialization: " + e.getMessage());
        }
    }

    // Method to deserialize the list of employees from the file
    private static List<Employee> deserializeEmployeeList(String fileName) {
        List<Employee> employeeList = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            employeeList = (List<Employee>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error during deserialization: " + e.getMessage());
        }
        return (employeeList != null) ? employeeList : new ArrayList<>();
    }
}