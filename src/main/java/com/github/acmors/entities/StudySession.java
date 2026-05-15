package com.github.acmors.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class StudySession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String topic;
    private String description;
    private Integer durationMinutes;
    private LocalDateTime studiedAt;
    private Status Status;

    public enum Status{
        PLANNED, DONE
    }

    public StudySession() {
    }

    public StudySession(String title, String topic, String description, Integer durationMinutes, LocalDateTime studiedAt, Status status) {
        this.title = title;
        this.topic = topic;
        this.description = description;
        this.durationMinutes = durationMinutes;
        this.studiedAt = studiedAt;
        Status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(Integer durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public LocalDateTime getStudiedAt() {
        return studiedAt;
    }

    public void setStudiedAt(LocalDateTime studiedAt) {
        this.studiedAt = studiedAt;
    }

    public Status getStatus() {
        return Status;
    }

    public void setStatus(Status status) {
        Status = status;
    }
}
