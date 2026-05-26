package com.github.acmors.service;

import com.github.acmors.dto.user.RequestUser;
import com.github.acmors.dto.user.ResponseUser;
import com.github.acmors.dto.user.UpdateUserPassword;
import com.github.acmors.dto.user.UpdateUserProfile;
import com.github.acmors.entities.UserAccount;
import com.github.acmors.exceptions.MethodArgumentNotValidException;
import com.github.acmors.exceptions.ResourceAlreadyExistsException;
import com.github.acmors.repository.UserAccountRepository;
import com.github.acmors.validations.UserAccountValidation;
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
class UserAccountServiceTest {

    @Mock
    private UserAccountRepository repository;

    @Mock
    private UserAccountValidation validation;

    @InjectMocks
    private UserAccountService service;

    private UserAccount user;
    private ResponseUser response;
    private RequestUser request;
    private UpdateUserProfile userProfile;
    private UpdateUserPassword password;

    @BeforeEach
    void setup(){
        user = new UserAccount(
                15L,
                "Flavio",
                "flavioalves@gmail.com",
                "123456789"
        );

        request = new RequestUser(
                "Flavio",
                "flavioalves@gmail.com",
                "123456789"
        );

        response = new ResponseUser(
                15L,
                "Flavio",
                "flavioalves@gmail.com",
                LocalDateTime.now()
        );

        userProfile = new UpdateUserProfile(
                "Flavioo",
                "flavio100atualizado@gmail.com"
        );

        password = new UpdateUserPassword(
                "123456789",
                "50505050",
                "50505050"
        );
    }


    @DisplayName("Should create user successfully.")
    @Test
    void shouldCreateUserSuccessfully(){
        when(repository.save(any(UserAccount.class))).thenReturn(user);
        doNothing().when(validation).validateCreate(any());

        var response = service.createUser(request);

        assertNotNull(response);
        assertEquals(request.getName(), response.getName());
        assertEquals(request.getEmail(), response.getEmail());
    }

    @DisplayName("Should return user already exists.")
    @Test
    void shouldReturnUserAlreadyExists(){
        doThrow(new ResourceAlreadyExistsException("Email already exists."))
                .when(validation).validateCreate(request);

        assertThrows(
                ResourceAlreadyExistsException.class,
                () -> service.createUser(request)
        );
    }

    @DisplayName("Should update user profile successfully")
    @Test
    void shouldUpdateUserProfileSuccessfully(){
        when(repository.findById(15L))
                .thenReturn(Optional.of(user));

        when(repository.save(user))
                .thenReturn(user);

        ResponseUser result = service.updateUserProfile(15L, userProfile);
        assertEquals("Flavioo", result.getName());
        assertEquals("flavio100atualizado@gmail.com", result.getEmail());
    }

    @DisplayName("Should update user password successfully.")
    @Test
    void shouldUpdateUserPasswordSuccessfully(){
        when(repository.findById(15L))
                .thenReturn(Optional.of(user));

        when(repository.save(user))
                .thenReturn(user);

        ResponseUser result = service.updateUserPassword(15L, password);

        assertNotNull(result);
    }





}