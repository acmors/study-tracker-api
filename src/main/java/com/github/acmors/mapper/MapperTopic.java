package com.github.acmors.mapper;

import com.github.acmors.dto.topic.ResponseTopic;
import com.github.acmors.entities.Topic;

public class MapperTopic {

    public static ResponseTopic toDTO(Topic topic){
        return new ResponseTopic(
                topic.getId(),
                topic.getName(),
                topic.getColor(),
                topic.isActive(),
                topic.getCreatedAt()
        );
    }
}
