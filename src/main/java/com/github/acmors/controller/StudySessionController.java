package com.github.acmors.controller;

import com.github.acmors.dto.RequestStudySession;
import com.github.acmors.dto.ResponseStudySession;
import com.github.acmors.dto.UpdateStudySession;
import com.github.acmors.dto.UpdateStudySessionStatus;
import com.github.acmors.service.StudySessionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
public class StudySessionController {

    private final StudySessionService service;

    public StudySessionController(StudySessionService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ResponseStudySession> createStudySession(@RequestBody RequestStudySession request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createStudySession(request));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<ResponseStudySession> updateStudySession(@PathVariable Long id,@RequestBody UpdateStudySession update){
        return ResponseEntity.ok().body(service.updateStudySession(id, update));
    }

    @PatchMapping("updateStatus/{id}")
    public ResponseEntity<ResponseStudySession> updateStudySessionStatus(@PathVariable Long id, @RequestBody UpdateStudySessionStatus updateStatus){
        return ResponseEntity.ok().body(service.updateStudySessionStatus(id, updateStatus));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseStudySession> getById(@PathVariable Long id){
        return ResponseEntity.ok().body(service.findById(id));
    }


}
