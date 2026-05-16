package com.github.acmors.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String color;
    private String userAccount;
    private boolean active;
    private LocalDateTime createdAt;

    public Topic(String name, String color, String userAccount, boolean active, LocalDateTime createdAt) {
        this.name = name;
        this.color = color;
        this.userAccount = userAccount;
        this.active = active;
        this.createdAt = createdAt;
    }

    public Topic() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getUser() {
        return userAccount;
    }

    public void setUser(String userAccount) {
        this.userAccount = userAccount;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
