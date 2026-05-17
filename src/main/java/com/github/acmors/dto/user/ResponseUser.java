package com.github.acmors.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ResponseUser {

    private Long id;
    private String name;
    private String email;
    private LocalDateTime createdAt;

}
