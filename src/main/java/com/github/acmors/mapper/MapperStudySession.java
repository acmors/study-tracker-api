package com.github.acmors.mapper;

import com.github.acmors.dto.ResponseStudySession;
import com.github.acmors.model.StudySession;

public class MapperStudySession {

    public static ResponseStudySession toDTO(StudySession studySession){
        return new ResponseStudySession(
                studySession.getId(),
                studySession.getTitle(),
                studySession.getTopic(),
                studySession.getDescription(),
                studySession.getDurationMinutes(),
                studySession.getStudiedAt(),
                studySession.getStatus()
        );
    }
}
