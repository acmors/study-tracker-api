package com.github.acmors.dto.topic;

import com.github.acmors.entities.UserAccount;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ResponseTopic {

    private Long id;
    private String name;
    private String color;
    private boolean active;
    private LocalDateTime createdAt;

}
