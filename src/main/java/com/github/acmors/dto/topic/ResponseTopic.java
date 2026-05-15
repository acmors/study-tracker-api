package com.github.acmors.dto.topic;

import com.github.acmors.entities.UserAccount;

import java.time.LocalDateTime;

public class ResponseTopic {

    private Long id;
    private String name;
    private String color;
    private UserAccount user;
    private boolean active;
    private LocalDateTime createdAt;

    public ResponseTopic() {
    }

    public ResponseTopic(Long id, String name, String color, UserAccount user, boolean active, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.user = user;
        this.active = active;
        this.createdAt = createdAt;
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

    public UserAccount getUser() {
        return user;
    }

    public void setUser(UserAccount user) {
        this.user = user;
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
