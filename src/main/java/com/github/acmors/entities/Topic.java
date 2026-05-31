package com.github.acmors.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_topic")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String color;
    private boolean active;
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserAccount user;

    @OneToMany(mappedBy = "topic")
    private List<StudySession> studySessions = new ArrayList<>();

    public Topic(Long id, String name, String color, boolean active) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.active = active;
    }
}
