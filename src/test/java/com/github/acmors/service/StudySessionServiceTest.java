package com.github.acmors.service;

import com.github.acmors.dto.study.RequestStudySession;
import com.github.acmors.dto.study.ResponseStudySession;
import com.github.acmors.entities.StudySession;
import com.github.acmors.entities.Topic;
import com.github.acmors.entities.UserAccount;
import com.github.acmors.repository.StudySessionRepository;
import com.github.acmors.validations.StudySessionValidation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudySessionServiceTest {

    @Mock
    private StudySessionRepository repository;
    @Mock
    private StudySessionValidation validation;
    @Mock
    private TopicService topicService;
    @Mock
    private UserAccountService userAccountService;

    @InjectMocks
    private StudySessionService service;

    private UserAccount user;
    private Topic topic;
    private RequestStudySession request;
    private StudySession studySession;

    @BeforeEach
    void setup(){
        user = new UserAccount(
                15L,
                "Flavio",
                "flavioalves@gmail.com",
                "123456789"
        );

        topic = new Topic(
                1L,
                "Eng de Software",
                "Cinza",
                true
        );

        request = new RequestStudySession(
                "Estudar Testes",
                topic.getId(),
                user.getId(),
                "Estudar os fundamentos dos testes",
                2,
                LocalDateTime.now(),
                StudySession.Status.DONE);

        studySession = new StudySession();
        studySession.setId(1L);
        studySession.setTitle(request.getTitle());
        studySession.setTopic(topic);
        studySession.setUser(user);
        studySession.setDescription(request.getDescription());
        studySession.setDurationMinutes(request.getDurationMinutes());
        studySession.setStudiedAt(request.getStudiedAt());
        studySession.setStatus(request.getStatus());
    }


    @Test
    @DisplayName("Should create a StudySession successfully")
    void shouldCreateStudySessionSuccessfully(){

        when(topicService.findByIdEntity(any())).thenReturn(topic);
        when(userAccountService.findByIdEntity(any())).thenReturn(user);
        when(repository.save(any())).thenReturn(studySession);

        var sessionCreated = service.createStudySession(request);

        assertNotNull(sessionCreated);
    }
}