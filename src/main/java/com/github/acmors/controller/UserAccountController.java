package com.github.acmors.controller;

import com.github.acmors.dto.user.RequestUser;
import com.github.acmors.dto.user.ResponseUser;
import com.github.acmors.dto.user.UpdateUserPassword;
import com.github.acmors.dto.user.UpdateUserProfile;
import com.github.acmors.service.UserAccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserAccountController {

    private final UserAccountService service;

    public UserAccountController(UserAccountService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ResponseUser> createUser(@RequestBody RequestUser request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createUser(request));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<ResponseUser> updateUserProfile(@PathVariable Long id,@RequestBody UpdateUserProfile update){
        return ResponseEntity.ok().body(service.updateUserProfile(id, update));
    }

    @PatchMapping("updateStatus/{id}")
    public ResponseEntity<ResponseUser> updateUserPassword(@PathVariable Long id, @RequestBody UpdateUserPassword updateStatus){
        return ResponseEntity.ok().body(service.updateUserPassword(id, updateStatus));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseUser> getById(@PathVariable Long id){
        return ResponseEntity.ok().body(service.findById(id));
    }
}
