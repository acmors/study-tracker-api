package com.github.acmors.service;

import com.github.acmors.dto.user.RequestUser;
import com.github.acmors.dto.user.ResponseUser;
import com.github.acmors.dto.user.UpdateUserPassword;
import com.github.acmors.dto.user.UpdateUserProfile;
import com.github.acmors.entities.UserAccount;
import com.github.acmors.mapper.MapperUser;
import com.github.acmors.repository.UserAccountRepository;
import com.github.acmors.validations.UserAccountValidation;
import jakarta.persistence.EntityNotFoundException;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class UserAccountService {

    private final UserAccountRepository repository;
    private final UserAccountValidation validation;

    public UserAccountService(UserAccountRepository repository, UserAccountValidation validation) {
        this.repository = repository;
        this.validation = validation;
    }

    @Transactional
    public ResponseUser createUser(RequestUser request){
        UserAccount user = new UserAccount();

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setCreatedAt(LocalDateTime.now());

        var saved = repository.save(user);
        return MapperUser.toDTO(saved);
    }

    @Transactional
    public ResponseUser updateUserProfile(Long id, UpdateUserProfile update){
        UserAccount user = findByIdEntity(id);

        user.setName(update.getName());
        user.setEmail(update.getEmail());

        var updated = repository.save(user);
        return MapperUser.toDTO(updated);
    }

    @Transactional
    public ResponseUser updateUserPassword(Long id, UpdateUserPassword update) throws BadRequestException {
        UserAccount user = findByIdEntity(id);
        validation.validatePassword(update, user.getPassword());

        user.setPassword(update.getUpdatedPassword());

        var saved = repository.save(user);
        return MapperUser.toDTO(saved);
    }

    @Transactional(readOnly = true)
    public UserAccount findByIdEntity(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found."));
    }

    @Transactional(readOnly = true)
    public ResponseUser findById(Long id){
        UserAccount user = findByIdEntity(id);
        return MapperUser.toDTO(user);
    }

    @Transactional
    public void deleteUser(Long id){
        UserAccount user = findByIdEntity(id);
        repository.delete(user);
    }
}
