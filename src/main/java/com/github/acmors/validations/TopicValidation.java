package com.github.acmors.validations;

import com.github.acmors.dto.topic.RequestTopic;
import com.github.acmors.dto.topic.UpdateTopic;
import com.github.acmors.exceptions.MethodArgumentNotValidException;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Component;

@Component
public class TopicValidation {

    public void validateCreate(RequestTopic requestTopic) throws MethodArgumentNotValidException {
        if(nullOrBlank(requestTopic.getName()) || requestTopic.getName().trim().length() < 3) throw new MethodArgumentNotValidException("The name must have at least 3 characters");
        if(nullOrBlank(requestTopic.getColor())) throw new MethodArgumentNotValidException("Topic color cannot be null");
    }

    public void validateUpdate(UpdateTopic update) throws MethodArgumentNotValidException {
        if(nullOrBlank(update.getName()) || update.getName().trim().length() < 3) throw new MethodArgumentNotValidException("The name must have at least 3 characters");
        if(nullOrBlank(update.getColor())) throw new MethodArgumentNotValidException("Topic color cannot be null");
    }

    private boolean nullOrBlank(String s) {
        return s == null || s.isBlank();
    }
}
