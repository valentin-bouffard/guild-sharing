package com.guildsharing.guildsharing.resources.error;

import jakarta.validation.ConstraintViolationException;

public class InvalidInputException extends RuntimeException implements ICustomException {
    private final String message;

    public InvalidInputException(String message, Throwable cause) {
        super(cause);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
