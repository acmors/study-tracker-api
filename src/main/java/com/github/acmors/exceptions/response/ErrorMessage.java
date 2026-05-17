package com.github.acmors.exceptions.response;

import jakarta.servlet.http.HttpServletRequest;
import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@ToString
public class ErrorMessage {

    private String path;
    private String method;
    private int status;
    private Object message;

    public ErrorMessage(){};
    public ErrorMessage(HttpServletRequest request, HttpStatus status, Object message) {
        this.path = request.getRequestURI();
        this.method = request.getMethod();
        this.status = status.value();
        this.message = message;
    }
}
