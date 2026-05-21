package com.github.acmors.service;

import com.github.acmors.dto.topic.RequestTopic;
import com.github.acmors.dto.topic.ResponseTopic;
import com.github.acmors.dto.topic.UpdateTopic;
import com.github.acmors.dto.topic.UpdateTopicStatus;
import com.github.acmors.entities.Topic;
import com.github.acmors.entities.UserAccount;
import com.github.acmors.exceptions.GlobalErrorException;
import com.github.acmors.exceptions.ResourceNotFoundException;
import com.github.acmors.mapper.MapperTopic;
import com.github.acmors.repository.TopicRepository;
import com.github.acmors.validations.TopicValidation;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TopicService {

    private final TopicRepository repository;
    private final UserAccountService userService;
    private final TopicValidation validation;

    @Transactional
    public ResponseTopic createTopic(RequestTopic request){
        Topic topic = new Topic();
        UserAccount user = userService.findByIdEntity(1L);
        validation.validateCreate(request);

        topic.setName(request.getName());
        topic.setColor(request.getColor());
        topic.setActive(true);
        topic.setCreatedAt(LocalDateTime.now());
        topic.setUser(user);

        var saved = repository.save(topic);
        return MapperTopic.toDTO(saved);
    }

    @Transactional
    public ResponseTopic updateTopic(Long id, UpdateTopic update){
        Topic topic = findByIdEntity(id);
        validation.validateUpdate(update);
        topic.setName(update.getName());
        topic.setColor(update.getColor());
        topic.setActive(update.isActive());

        var saved = repository.save(topic);
        return MapperTopic.toDTO(saved);
    }

    @Transactional
    public ResponseTopic updateTopicStatus(Long id, UpdateTopicStatus update){
        Topic topic = findByIdEntity(id);
        topic.setActive(update.isActive());

        var saved = repository.save(topic);
        return MapperTopic.toDTO(saved);
    }

    @Transactional(readOnly = true)
    public Topic findByIdEntity(Long id){
        return repository.findById(id)
                .orElseThrow(GlobalErrorException::new);
    }

    @Transactional(readOnly = true)
    public ResponseTopic findById(Long id){
        Topic topic = findByIdEntity(id);
        return MapperTopic.toDTO(topic);
    }

    @Transactional
    public void delete(Long id){
        Topic topic = findByIdEntity(id);
        repository.delete(topic);
    }
}
