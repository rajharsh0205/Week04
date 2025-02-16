package com.junit.advancedjunitpracticeproblems;

import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Taking temperature in °C as user input
        System.out.print("Enter temperature in Celcius: ");
        double celcius = sc.nextDouble();

        //Taking temperature in °F as user input
        System.out.print("Enter temperature in Fahrenheit: ");
        double fahrenheit = sc.nextDouble();

        System.out.println(celcius + "°C = " + celciusToFahrenheit(celcius) + "°F");
        System.out.println(fahrenheit + "°F = " + fahrenheitToCelcius(fahrenheit) + "°C");

        sc.close();
    }

    //Method to convert temperature from °C to °F
    public static double celciusToFahrenheit(double celcius){
        return (celcius * 9/5) + 32;
    }

    //Method to convert temperature from °F to °c
    public static double fahrenheitToCelcius(double fahrenheit){
        return (fahrenheit -32)* 5/9;
    }
}
