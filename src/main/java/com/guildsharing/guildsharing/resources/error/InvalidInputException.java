package com.guildsharing.guildsharing.resources.error;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;
import java.util.Set;

public class InvalidInputException extends RuntimeException implements ICustomException {
    private final String message;
    private final String detail;

    public InvalidInputException(String message, String detail, Throwable cause) {
        super(cause);
        this.detail = detail;
        this.message = message;
    }
    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String getDetail() {
        return detail;
    }
}
