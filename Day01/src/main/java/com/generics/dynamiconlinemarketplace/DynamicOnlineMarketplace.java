package com.generics.dynamiconlinemarketplace;

// Class representing a Book Category
class BookCategory {
    private String category;

    public BookCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return category;
    }
}

// Class representing a Clothing Category
class ClothingCategory {
    private String category;

    public ClothingCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return category;
    }
}

// Class representing a Gadget Category
class GadgetCategory {
    private String category;

    public GadgetCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return category;
    }
}

// Generic Product Class
class Product<T> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public T getCategory() {
        return category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", category=" + category +
                '}';
    }
}

// Class for Product Catalog
class ProductCatalog {
    // Generic method to apply discount
    public <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double discountAmount = product.getPrice() * (percentage / 100);
        double newPrice = product.getPrice() - discountAmount;
        product.setPrice(newPrice);
        System.out.println("Discount applied! New price of " + product.getName()  + newPrice);
    }
}

// Main Class to Test the Implementation
public class DynamicOnlineMarketplace {
    public static void main(String[] args) {
        // Create products
        Product<BookCategory> book = new Product<>("Concept of Physics", 1000, new BookCategory("Fiction"));
        Product<ClothingCategory> shirt = new Product<>("T-Shirt", 700, new ClothingCategory("Men"));
        Product<GadgetCategory> phone = new Product<>("Smartphone", 12000, new GadgetCategory("Phone"));

        // Create a product catalog
        ProductCatalog catalog = new ProductCatalog();

        // Display original prices
        System.out.println(book);
        System.out.println(shirt);
        System.out.println(phone);

        // Apply discounts
        catalog.applyDiscount(book, 10); // 10% discount
        catalog.applyDiscount(shirt, 20); // 20% discount
        catalog.applyDiscount(phone, 15); // 15% discount

        // Display updated prices
        System.out.println(book);
        System.out.println(shirt);
        System.out.println(phone);
    }
}
