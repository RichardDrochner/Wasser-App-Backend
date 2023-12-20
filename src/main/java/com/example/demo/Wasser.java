package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
public class Wasser extends Benutzer {

    private String owner;
    private LocalDate date;
    private double tagesziel;
    private double getrunken;
    @Id
    private Long id;

    public Wasser(String owner, LocalDate date, double tagesziel, double getrunken) {
        this.owner = owner;
        this.tagesziel = tagesziel;
        this.getrunken = getrunken;
        this.date = date;
    }

    public Wasser() {
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getTagesziel() {
        return tagesziel;
    }

    public void setTagesziel(double tagesziel) {
        this.tagesziel = tagesziel;
    }

    public double getGetrunken() {
        return getrunken;
    }

    public void setGetrunken(double getrunken) {
        this.getrunken = getrunken;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
