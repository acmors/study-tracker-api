package com.github.acmors.dto;

import com.github.acmors.model.StudySession;

import java.time.LocalDateTime;

public class ResponseStudySession {

    private Long id;
    private String title;
    private String topic;
    private String description;
    private Integer durationMinutes;
    private LocalDateTime studiedAt;
    private StudySession.Status Status;

    public ResponseStudySession(Long id, String title, String topic, String description, Integer durationMinutes, LocalDateTime studiedAt, StudySession.Status status) {
        this.id = id;
        this.title = title;
        this.topic = topic;
        this.description = description;
        this.durationMinutes = durationMinutes;
        this.studiedAt = studiedAt;
        Status = status;
    }

    public ResponseStudySession() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
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
