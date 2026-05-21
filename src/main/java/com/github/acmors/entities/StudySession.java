package com.github.acmors.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_study_session")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudySession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;
    private String description;
    private Integer durationMinutes;
    private LocalDateTime studiedAt;
    private Status Status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserAccount user;

    public enum Status{
        PLANNED, DONE
    }
}
