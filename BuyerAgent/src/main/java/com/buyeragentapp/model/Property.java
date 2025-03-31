package com.buyeragentapp.model;

public class Property {
    private int id;
    private String title;
    private String description;
    private double price;
    private int agentId;
    private String ownerName;
    private String ownerContact;

    public Property() {}

    public Property(int id, String title, String description, double price, int agentId, String ownerName, String ownerContact) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.agentId = agentId;
        this.ownerName = ownerName;
        this.ownerContact = ownerContact;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getAgentId() { return agentId; }
    public void setAgentId(int agentId) { this.agentId = agentId; }

    public String getOwnerName() { return ownerName; }
    public void setOwnerName(String ownerName) { this.ownerName = ownerName; }

    public String getOwnerContact() { return ownerContact; }
    public void setOwnerContact(String ownerContact) { this.ownerContact = ownerContact; }
}
