package com.github.acmors.service;

import com.github.acmors.dto.topic.RequestTopic;
import com.github.acmors.dto.topic.ResponseTopic;
import com.github.acmors.dto.topic.UpdateTopic;
import com.github.acmors.dto.topic.UpdateTopicStatus;
import com.github.acmors.entities.Topic;
import com.github.acmors.mapper.MapperTopic;
import com.github.acmors.repository.TopicRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TopicService {

    private final TopicRepository repository;

    public TopicService(TopicRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public ResponseTopic createTopic(RequestTopic request){
        Topic topic = new Topic();

        topic.setName(request.getName());
        topic.setColor(request.getColor());
        topic.setActive(request.isActive());

        var saved = repository.save(topic);
        return MapperTopic.toDTO(saved);
    }

    @Transactional
    public ResponseTopic updateTopic(Long id, UpdateTopic update){
        Topic topic = findByIdEntity(id);

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
                .orElseThrow(() -> new EntityNotFoundException("Topic not found"));
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
