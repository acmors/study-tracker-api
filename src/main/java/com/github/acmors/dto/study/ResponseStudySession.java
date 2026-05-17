package com.github.acmors.dto.study;

import com.github.acmors.entities.StudySession;
import com.github.acmors.entities.Topic;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ResponseStudySession {

    private Long id;
    private String title;
    private Long topicId;
    private String description;
    private Integer durationMinutes;
    private LocalDateTime studiedAt;
    private StudySession.Status Status;
}
