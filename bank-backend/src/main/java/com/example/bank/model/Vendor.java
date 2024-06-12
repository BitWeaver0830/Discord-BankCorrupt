package com.example.bank.model;

import jakarta.persistence.*;

@Entity
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;
    private String upi;

    public String getEmail() {
        return email;
    }

    public String getUpi() {
        return upi;
    }

    public String getName() {
        return name;
    }

    // Getters and setters
}