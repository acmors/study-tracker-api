package com.github.acmors.dto.topic;

public class UpdateTopicStatus {

    private boolean active;

    public UpdateTopicStatus() {
    }

    public UpdateTopicStatus(boolean active) {
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
