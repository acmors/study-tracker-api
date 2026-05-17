package com.github.acmors.dto.study;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.acmors.entities.StudySession;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RequestStudySession {

    private String title;
    private Long topicId;
    private String description;
    private Integer durationMinutes;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime studiedAt;

    @Enumerated(EnumType.STRING)
    private StudySession.Status Status;
}
