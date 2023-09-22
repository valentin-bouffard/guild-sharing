package com.guildsharing.guildsharing.resources.error;

import com.guildsharing.guildsharing.resources.error.business.CustomBusinessException;
import com.guildsharing.guildsharing.resources.error.business.InvalidInputException;
import com.guildsharing.guildsharing.resources.error.business.PikachuNotFoundException;
import jakarta.validation.ConstraintViolationException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
    public ResponseEntity<CustomProblem> handleInternalServerError(
            ConstraintViolationException exception) {
        InvalidInputException invalidInputException = new InvalidInputException(exception.getMessage(), exception);
       return problemFactory.createCustomError(invalidInputException, HttpStatus.BAD_REQUEST, exception.getConstraintViolations());
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<CustomProblem> handleInternalServerError(
            MethodArgumentNotValidException exception) {
        BindingResult result = exception.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();

        InvalidInputException invalidInputException = new InvalidInputException(exception.getMessage(), exception);
        return problemFactory.createCustomError(invalidInputException, HttpStatus.BAD_REQUEST, fieldErrors);
    }

    @ExceptionHandler({CustomBusinessException.class, InvalidInputException.class})
    public <T extends ICustomException> ResponseEntity<CustomProblem> handleBadRequest(
            T exception) {
        return problemFactory.createCustomError(exception, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({PikachuNotFoundException.class})
    public <T extends ICustomException> ResponseEntity<CustomProblem> handleNotFound(
            T exception) {
        return problemFactory.createCustomError(exception, HttpStatus.NOT_FOUND);
    }
}
