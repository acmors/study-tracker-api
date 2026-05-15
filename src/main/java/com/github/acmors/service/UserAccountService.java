package com.github.acmors.service;

import com.github.acmors.dto.user.RequestUser;
import com.github.acmors.dto.user.ResponseUser;
import com.github.acmors.dto.user.UpdateUserPassword;
import com.github.acmors.dto.user.UpdateUserProfile;
import com.github.acmors.entities.UserAccount;
import com.github.acmors.mapper.MapperUser;
import com.github.acmors.repository.UserAccountRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserAccountService {

    private final UserAccountRepository repository;

    public UserAccountService(UserAccountRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public ResponseUser createUser(RequestUser request){
        UserAccount user = new UserAccount();

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

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
    public ResponseUser updateUserPassword(Long id, UpdateUserPassword update){
        UserAccount user = findByIdEntity(id);

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
