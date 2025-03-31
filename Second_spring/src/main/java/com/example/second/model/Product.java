// Product.java
package com.example.second.model;

public class Product {

    private int id;       // Product ID
    private String name;  // Product Name
    private double price; // Product Price

    // Default Constructor
    public Product() {}

    // Parameterized Constructor
    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}
