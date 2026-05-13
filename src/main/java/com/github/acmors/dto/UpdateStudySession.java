package com.github.acmors.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.acmors.model.StudySession;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDateTime;

public class UpdateStudySession {

    private String title;
    private String topic;
    private String description;
    private Integer durationMinutes;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime studiedAt;

    @Enumerated(EnumType.STRING)
    private StudySession.Status Status;

    public UpdateStudySession() {
    }

    public UpdateStudySession(String title, String topic, String description, Integer durationMinutes, LocalDateTime studiedAt, StudySession.Status status) {
        this.title = title;
        this.topic = topic;
        this.description = description;
        this.durationMinutes = durationMinutes;
        this.studiedAt = studiedAt;
        Status = status;
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

    public StudySession.Status getStatus() {
        return Status;
    }

    public void setStatus(StudySession.Status status) {
        Status = status;
    }
}
