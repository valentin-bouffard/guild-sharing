package com.guildsharing.guildsharing.resources.error;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@Component
@ControllerAdvice
@Slf4j
@AllArgsConstructor
public class RestControllerExceptionHandler {

    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<String> handleInternalServerError(
            ConstraintViolationException exception) {
        return ResponseEntity.badRequest().body(StringUtils.join(exception.getConstraintViolations().stream().map(ConstraintViolation::getMessageTemplate).collect(Collectors.toSet()), ','));
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<String> handleInternalServerError(
            MethodArgumentNotValidException exception) {
        BindingResult result = exception.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        return ResponseEntity.badRequest().body(StringUtils.join(fieldErrors.stream().map(FieldError::getDefaultMessage).collect(Collectors.toSet()), ','));
    }

}
