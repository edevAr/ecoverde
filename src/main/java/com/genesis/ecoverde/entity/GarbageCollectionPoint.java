package com.genesis.ecoverde.entity;

import jakarta.persistence.*;

@Entity
public class GarbageCollectionPoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;

    // Constructors
    public GarbageCollectionPoint() {}

    public GarbageCollectionPoint(String address) {
        this.address = address;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
