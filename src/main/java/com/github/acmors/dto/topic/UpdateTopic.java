package com.github.acmors.dto.topic;

public class UpdateTopic {

    private String name;
    private String color;
    private boolean active;

    public UpdateTopic() {
    }

    public UpdateTopic(String name, String color, boolean active) {
        this.name = name;
        this.color = color;
        this.active = active;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
