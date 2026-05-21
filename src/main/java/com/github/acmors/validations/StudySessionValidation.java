package com.github.acmors.validations;

import com.github.acmors.dto.study.RequestStudySession;
import com.github.acmors.dto.study.UpdateStudySession;
import com.github.acmors.exceptions.MethodArgumentNotValidException;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class StudySessionValidation {

    public void validateCreateSession(RequestStudySession request) throws MethodArgumentNotValidException {
        validationDuration(request.getDurationMinutes());
        validateStudiedAt(request.getStudiedAt());
    }

    public void validateUpdateSession(UpdateStudySession request) throws MethodArgumentNotValidException {
        validationDuration(request.getDurationMinutes());
        validateStudiedAt(request.getStudiedAt());
    }

    private void validationDuration(Integer duration) throws MethodArgumentNotValidException {
        if(duration == null || duration <= 0){
            throw new MethodArgumentNotValidException("Duratation must be greater than zero.");
        }
    }

    private void validateStudiedAt(LocalDateTime studiedAt) throws MethodArgumentNotValidException {
        if (studiedAt == null || studiedAt.isAfter(LocalDateTime.now())){
            throw new MethodArgumentNotValidException("Study date cannot be in the future.");
        }
    }

}
