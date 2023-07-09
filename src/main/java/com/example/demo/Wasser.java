package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Wasser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int amount;
    private int getrunken;

    public Wasser() {
    }

    public Wasser(int amount) {
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getGetrunken() {
        return getrunken;
    }

    public void setGetrunken(int getrunken) {
        this.getrunken += getrunken;
    }

    public String toString(){
        return "Wasser{id=" + id + ", amount=" + amount + ", getrunken=" + getrunken + "}";
    }
}


