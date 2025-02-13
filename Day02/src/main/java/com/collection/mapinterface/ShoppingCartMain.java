package com.collection.mapinterface;

import java.util.*;

class ShoppingCart {
    private Map<String, Double> productPrices = new HashMap<>(); // Stores product prices
    private LinkedHashMap<String, Integer> cart = new LinkedHashMap<>(); // Maintains item order
    private TreeMap<Double, String> sortedByPrice = new TreeMap<>(); // Sorts items by price

    // Add a product to the catalog
    public void addProduct(String product, double price) {
        productPrices.put(product, price);
    }

    // Add an item to the cart
    public void addToCart(String product, int quantity) {
        if (productPrices.containsKey(product)) {
            cart.put(product, cart.getOrDefault(product, 0) + quantity);
            sortedByPrice.put(productPrices.get(product), product);
        } else {
            System.out.println("Product not found: " + product);
        }
    }

    // Display items in the order they were added
    public void displayCartOrder() {
        System.out.println("\nCart Items (Order of Addition):");
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            System.out.println(entry.getKey() + " -> Quantity: " + entry.getValue() + " (₹" + productPrices.get(entry.getKey()) + " each)");
        }
    }

    // Display items sorted by price
    public void displayCartByPrice() {
        System.out.println("\nCart Items (Sorted by Price):");
        for (Map.Entry<Double, String> entry : sortedByPrice.entrySet()) {
            String product = entry.getValue();
            System.out.println(product + " -> ₹" + entry.getKey() + " each, Quantity: " + cart.get(product));
        }
    }

    // Calculate total price of the cart
    public void calculateTotal() {
        double total = 0;
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            total += productPrices.get(entry.getKey()) * entry.getValue();
        }
        System.out.println("\nTotal Cart Value: ₹" + total);
    }
}

public class ShoppingCartMain {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Adding products to the catalog
        cart.addProduct("Laptop", 55000);
        cart.addProduct("Headphones", 2000);
        cart.addProduct("Smartphone", 30000);
        cart.addProduct("Mouse", 1500);
        cart.addProduct("Keyboard", 2500);

        // Adding items to the cart
        cart.addToCart("Laptop", 1);
        cart.addToCart("Headphones", 2);
        cart.addToCart("Mouse", 1);
        cart.addToCart("Smartphone", 1);

        // Display items in the order they were added
        cart.displayCartOrder();

        // Display items sorted by price
        cart.displayCartByPrice();

        // Calculate total cart value
        cart.calculateTotal();
    }
}