package com.spring.jpa.model;

import jakarta.persistence.*;

@Entity  // Marks this class as a database entity
@Table(name = "EMPLOYEE")  
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment ID
    private int id;

    @Column(name = "ENAME") // Maps to ename column
    private String ename;

    @Column(name = "role") // Maps to role column
    private String role;

    public Employee() {}

    public Employee(int id, String ename, String role) {
        this.id = id;
        this.ename = ename;
        this.role = role;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getEname() { return ename; }
    public void setEname(String ename) { this.ename = ename; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}
