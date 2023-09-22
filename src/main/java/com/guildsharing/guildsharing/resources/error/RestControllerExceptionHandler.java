package com.guildsharing.guildsharing.resources.error;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.hateoas.mediatype.problem.Problem;
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

    private final ProblemFactory problemFactory;

    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<Problem> handleInternalServerError(
            ConstraintViolationException exception) {
        InvalidInputException invalidInputException = new InvalidInputException(exception.getMessage(), exception);
       return problemFactory.createError(invalidInputException, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<CustomProblem> handleInternalServerError(
            MethodArgumentNotValidException exception) {
        BindingResult result = exception.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();

        InvalidInputException invalidInputException = new InvalidInputException(exception.getMessage(), exception);
        return problemFactory.createCustomError(invalidInputException, HttpStatus.BAD_REQUEST, fieldErrors);

    }
}
