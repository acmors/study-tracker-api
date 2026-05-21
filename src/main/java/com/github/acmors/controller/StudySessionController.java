package com.github.acmors.controller;

import com.github.acmors.dto.study.RequestStudySession;
import com.github.acmors.dto.study.ResponseStudySession;
import com.github.acmors.dto.study.UpdateStudySession;
import com.github.acmors.dto.study.UpdateStudySessionStatus;
import com.github.acmors.service.StudySessionService;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/study-session")
public class StudySessionController {

    private final StudySessionService service;

    public StudySessionController(StudySessionService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ResponseStudySession> createStudySession(@RequestBody RequestStudySession request) throws BadRequestException {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createStudySession(request));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<ResponseStudySession> updateStudySession(@PathVariable Long id,@RequestBody UpdateStudySession update) throws BadRequestException {
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
