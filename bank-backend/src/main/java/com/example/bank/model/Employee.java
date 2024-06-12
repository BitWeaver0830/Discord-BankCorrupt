package com.example.bank.model;

import jakarta.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String designation;
    private double ctc;

    @Column(unique = true)
    private String email;

    public String getName() {
        return name;
    }

    public String getDesignation() {
        return designation;
    }

    public double getCtc() {
        return ctc;
    }

    // Getters and setters
}