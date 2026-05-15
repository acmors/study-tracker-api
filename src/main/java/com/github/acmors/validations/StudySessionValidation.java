package com.github.acmors.validations;

import com.github.acmors.dto.RequestStudySession;
import com.github.acmors.dto.UpdateStudySession;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class StudySessionValidation {

    public void validateCreateSession(RequestStudySession request) throws BadRequestException {
        validationDuration(request.getDurationMinutes());
        validateStudiedAt(request.getStudiedAt());
    }

    public void validateUpdateSession(UpdateStudySession request) throws BadRequestException {
        validationDuration(request.getDurationMinutes());
        validateStudiedAt(request.getStudiedAt());
    }

    private void validationDuration(Integer duration) throws BadRequestException {
        if(duration == null || duration <= 0){
            throw new BadRequestException("Duratation must be greater than zero.");
        }
    }

    private void validateStudiedAt(LocalDateTime studiedAt) throws BadRequestException {
        if (studiedAt == null || studiedAt.isAfter(LocalDateTime.now())){
            throw new BadRequestException("Study date cannot be in the future.");
        }
    }

}
