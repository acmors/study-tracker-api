package com.github.acmors.dto;

import com.github.acmors.model.StudySession;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class UpdateStudySessionStatus {

    @Enumerated(EnumType.STRING)
    private StudySession.Status status;

    public UpdateStudySessionStatus(StudySession.Status status) {
        this.status = status;
    }

    public UpdateStudySessionStatus() {
    }

    public StudySession.Status getStatus() {
        return status;
    }

    public void setStatus(StudySession.Status status) {
        this.status = status;
    }
}
