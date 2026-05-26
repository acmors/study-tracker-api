package com.github.acmors.validations;

import com.github.acmors.dto.user.RequestUser;
import com.github.acmors.dto.user.UpdateUserPassword;
import com.github.acmors.dto.user.UpdateUserProfile;
import com.github.acmors.exceptions.MethodArgumentNotValidException;
import com.github.acmors.exceptions.ResourceAlreadyExistsException;
import com.github.acmors.repository.UserAccountRepository;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserAccountValidation {
    private final UserAccountRepository repository;

    public void validateCreate(RequestUser request){
        if (nullOrBlank(request.getName()) || request.getName().trim().length() < 3) throw new MethodArgumentNotValidException("Name must be at least 3 characters.");
        if (nullOrBlank(request.getEmail()) || request.getEmail().trim().length() < 6) throw new MethodArgumentNotValidException("Email must be at least 6 characters.");
        if (nullOrBlank(request.getPassword()) || request.getPassword().trim().length() < 6) throw new MethodArgumentNotValidException("Password must be at least 6 characters.");
        if (repository.existsByEmail(request.getEmail())) throw new ResourceAlreadyExistsException("Email already exists.");
    }

    public void validateUpdate(UpdateUserProfile request){
        if (nullOrBlank(request.getName()) || request.getName().trim().length() < 3) throw new MethodArgumentNotValidException("Name must be at least 3 characters.");
        if (nullOrBlank(request.getEmail()) || request.getEmail().trim().length() < 6) throw new MethodArgumentNotValidException("Email must be at least 6 characters.");
    }

    public void validatePassword(UpdateUserPassword update, String passwordDB) throws MethodArgumentNotValidException {
        if (!passwordDB.equals(update.getCurrentPassword())) throw new MethodArgumentNotValidException("Current password is incorrect.");
        if (nullOrBlank(update.getCurrentPassword()) || nullOrBlank(update.getUpdatedPassword()) || nullOrBlank(update.getConfirmPassword())) throw new MethodArgumentNotValidException("Password fields cannot be null or blank.");
        if (!update.getUpdatedPassword().equals(update.getConfirmPassword())) throw new MethodArgumentNotValidException("Password do not match");
    }

    private boolean nullOrBlank(String s) {
        return s == null || s.isBlank();
    }
}
