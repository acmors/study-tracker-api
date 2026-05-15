package com.github.acmors.controller;

import com.github.acmors.dto.topic.RequestTopic;
import com.github.acmors.dto.topic.ResponseTopic;
import com.github.acmors.dto.topic.UpdateTopic;
import com.github.acmors.dto.topic.UpdateTopicStatus;
import com.github.acmors.service.TopicService;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/topic")
public class TopicController {

    private final TopicService service;
    public TopicController(TopicService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ResponseTopic> createStudySession(@RequestBody RequestTopic request) throws BadRequestException {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createTopic(request));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<ResponseTopic> updateStudySession(@PathVariable Long id,@RequestBody UpdateTopic update) throws BadRequestException {
        return ResponseEntity.ok().body(service.updateTopic(id, update));
    }

    @PatchMapping("updateStatus/{id}")
    public ResponseEntity<ResponseTopic> updateStudySessionStatus(@PathVariable Long id, @RequestBody UpdateTopicStatus updateStatus){
        return ResponseEntity.ok().body(service.updateTopicStatus(id, updateStatus));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseTopic> getById(@PathVariable Long id){
        return ResponseEntity.ok().body(service.findById(id));
    }
}
