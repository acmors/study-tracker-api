package com.github.acmors.exceptions;

public class GlobalErrorException extends RuntimeException {
    public GlobalErrorException() {
        super("An unexpected error has occurred. Please contact the IT team as soon as possible.");
    }
}
