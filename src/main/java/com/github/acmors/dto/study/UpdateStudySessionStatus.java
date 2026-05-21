package com.github.acmors.dto.study;

import com.github.acmors.entities.StudySession;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UpdateStudySessionStatus {

    @Enumerated(EnumType.STRING)
    private StudySession.Status status;

}
