package com.github.acmors.model;

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
}
