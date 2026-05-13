package com.github.acmors.service;

import com.github.acmors.dto.RequestStudySession;
import com.github.acmors.dto.ResponseStudySession;
import com.github.acmors.dto.UpdateStudySession;
import com.github.acmors.dto.UpdateStudySessionStatus;
import com.github.acmors.mapper.MapperStudySession;
import com.github.acmors.model.StudySession;
import com.github.acmors.repository.StudySessionRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudySessionService {

    private final StudySessionRepository repository;

    public StudySessionService(StudySessionRepository repository) {
        this.repository = repository;
    }


    @Transactional
    public ResponseStudySession createStudySession(RequestStudySession request){
        StudySession entity = new StudySession();

        entity.setTitle(request.getTitle());
        entity.setTopic(request.getTopic());
        entity.setDescription(request.getDescription());
        entity.setDurationMinutes(request.getDurationMinutes());
        entity.setStudiedAt(request.getStudiedAt());
        entity.setStatus(request.getStatus());

        var saved = repository.save(entity);
        return MapperStudySession.toDTO(saved);
    }

    @Transactional(readOnly = true)
    public ResponseStudySession findById(Long id){
        var entity = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Tarefa nao encontrada"));

        return MapperStudySession.toDTO(entity);
    }

    @Transactional(readOnly = true)
    public StudySession findByIdEntity(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tarefa nao encontrada"));
    }

    @Transactional
    public ResponseStudySession updateStudySession(Long id, UpdateStudySession update){
        StudySession entity = findByIdEntity(id);

        entity.setTitle(update.getTitle());
        entity.setTopic(update.getTopic());
        entity.setDescription(update.getDescription());
        entity.setDurationMinutes(update.getDurationMinutes());
        entity.setStudiedAt(update.getStudiedAt());
        entity.setStatus(update.getStatus());

        var saved = repository.save(entity);
        return MapperStudySession.toDTO(saved);
    }

    @Transactional
    public ResponseStudySession updateStudySessionStatus(Long id, UpdateStudySessionStatus finish){
        StudySession entity = findByIdEntity(id);
        entity.setStatus(finish.getStatus());

        var saved = repository.save(entity);
        return MapperStudySession.toDTO(saved);
    }

    @Transactional
    public void deleteStudySession(Long id){
        StudySession entity = findByIdEntity(id);
        repository.delete(entity);
    }
}
