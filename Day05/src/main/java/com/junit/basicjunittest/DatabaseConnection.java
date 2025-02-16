package com.junit.basicjunittest;

public class DatabaseConnection {
    boolean isConnected;
    //method connect to database
    public void connect() {
        isConnected = true;
        System.out.println("Database connected.");
    }

    //method disconnect to database
    public void disconnect() {
        isConnected = false;
        System.out.println("Database disconnected.");
    }
    //return status
    public boolean isConnected() {
        return isConnected;
    }

    public static void main(String[] args) {
        DatabaseConnection dbConnection = new DatabaseConnection();

        System.out.println("Initial Connection Status: " + dbConnection.isConnected());

        dbConnection.connect(); // calling connect method
        System.out.println("Connection Status after connect(): " + dbConnection.isConnected());

        dbConnection.disconnect(); // calling connect method
        System.out.println("Connection Status after disconnect(): " + dbConnection.isConnected());
    }
}