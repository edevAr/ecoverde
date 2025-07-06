package com.genesis.ecoverde.entity;

import jakarta.persistence.*;

@Entity
public class RecyclingTip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tip;

    // Constructors
    public RecyclingTip() {}

    public RecyclingTip(String tip) {
        this.tip = tip;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public String getTip() {
        return tip;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }
}
