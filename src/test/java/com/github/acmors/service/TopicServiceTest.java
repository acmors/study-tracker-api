package com.github.acmors.service;
import com.github.acmors.dto.topic.RequestTopic;
import com.github.acmors.dto.topic.UpdateTopic;
import com.github.acmors.dto.topic.UpdateTopicStatus;
import com.github.acmors.entities.Topic;
import com.github.acmors.entities.UserAccount;
import com.github.acmors.exceptions.MethodArgumentNotValidException;
import com.github.acmors.repository.TopicRepository;
import com.github.acmors.validations.TopicValidation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TopicServiceTest {

    @Mock
    private TopicRepository repository;
    @Mock
    private UserAccountService userService;
    @Mock
    private TopicValidation validation;

    @InjectMocks
    private TopicService service;

    private UserAccount user;
    private Topic topic;
    private RequestTopic request;
    private RequestTopic requestForError;
    private UpdateTopic updateTopic;
    private UpdateTopic updateTopicError;
    private UpdateTopicStatus updateTopicStatus;

    @BeforeEach
    void setup(){
        user = new UserAccount(
                15L,
                "Flavio",
                "flaviodiferente@gmail.com",
                "123456789"
        );

        request = new RequestTopic(
                "React",
                "Blue"
        );

        requestForError = new RequestTopic(
                "",
                ""
        );

        topic = new Topic();

        updateTopic = new UpdateTopic(
                "Laravel",
                "Purple",
                false
        );

        updateTopicError = new UpdateTopic(
                "",
                "",
                false
        );
    }

    @DisplayName("Should create topic successfully.")
    @Test
    void shouldCreateTopicSuccessfully(){
        //Arrange
        topic.setId(1L);
        topic.setName(request.getName());
        topic.setColor(request.getColor());
        topic.setActive(true);
        topic.setCreatedAt(LocalDateTime.now());
        topic.setUser(user);

        when(userService.findByIdEntity(1L)).thenReturn(user);
        when(repository.save(any(Topic.class))).thenReturn(topic);

        var response = service.createTopic(request);

        assertNotNull(response);
        assertEquals(1L, response.getId());
        assertEquals("React", response.getName());
        assertEquals("Blue", response.getColor());
    }

    @DisplayName("Should return error Exception when topic fields are invalid.")
    @Test
    void shouldReturnErrorExceptionWhenTopicFieldsAreInvalid_Create(){

        doThrow(new MethodArgumentNotValidException("The name must have at least 3 characters")).when(validation).validateCreate(requestForError);

        assertThrows(MethodArgumentNotValidException.class, () -> service.createTopic(requestForError));
        verify(repository, never()).save(any());
    }

    @DisplayName("Should update topic successfully.")
    @Test
    void shouldUpdateTopicSuccessfully(){
        //Arrange
        topic.setName(updateTopic.getName());
        topic.setColor(updateTopic.getColor());
        topic.setActive(updateTopic.isActive());

        when(repository.findById(1L)).thenReturn(Optional.of(topic));
        when(repository.save(any(Topic.class))).thenReturn(topic);

        var response = service.updateTopic(1L, updateTopic);

        assertNotNull(response);
        assertEquals("Laravel", response.getName());
        assertEquals("Purple", response.getColor());
    }


    @DisplayName("Should update topic successfully.")
    @Test
    void shouldReturnExceptionWhenTopicFieldsAreInvalid_Update(){
        when(repository.findById(1L)).thenReturn(Optional.of(topic));
        doThrow(new MethodArgumentNotValidException("Topic color cannot be null")).when(validation).validateUpdate(updateTopicError);

        assertThrows(MethodArgumentNotValidException.class, ()-> service.updateTopic(1L, updateTopicError));
        verify(repository, never()).save(any());
    }

}