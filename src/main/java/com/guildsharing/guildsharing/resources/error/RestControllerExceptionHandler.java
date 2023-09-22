package com.guildsharing.guildsharing.resources.error;

import com.guildsharing.guildsharing.resources.error.business.InvalidInputException;
import jakarta.validation.ConstraintViolationException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
       return problemFactory.createError(invalidInputException, HttpStatus.BAD_REQUEST, exception.getConstraintViolations());
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
