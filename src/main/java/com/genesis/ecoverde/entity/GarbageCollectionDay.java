package com.genesis.ecoverde.entity;

import jakarta.persistence.*;

@Entity
public class GarbageCollectionDay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String timezone;
    private String zone;
    private String day;

    // Constructors
    public GarbageCollectionDay() {}

    public GarbageCollectionDay(String timezone, String zone, String day) {
        this.timezone = timezone;
        this.zone = zone;
        this.day = day;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public String getTimezone() {
        return timezone;
    }

    public String getZone() {
        return zone;
    }

    public String getDay() {
        return day;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public void setDay(String day) {
        this.day = day;
    }
}
