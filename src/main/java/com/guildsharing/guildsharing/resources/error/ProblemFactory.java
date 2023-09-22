package com.guildsharing.guildsharing.resources.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.mediatype.problem.Problem;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;

import java.util.List;

@Component
@Slf4j
public class ProblemFactory {
    public final ResponseEntity<Problem> createError(
            ICustomException customException, HttpStatus status) {
        final Problem problem;
        log.error(customException.getLogMessage(), customException);
        problem =
                new Problem(
                        null,
                        customException.getTitle(),
                        status.value(),
                        customException.getDetail(),
                        null);
        return buildResponseEntity(problem, status);
    }

    public final ResponseEntity<CustomProblem> createCustomError(
            ICustomException customException, HttpStatus status, List<FieldError> fieldErrors) {
        final CustomProblem problem;
        log.error(customException.getLogMessage(), customException);
        problem =
                new CustomProblem(
                        null,
                        customException.getTitle(),
                        status.value(),
                        customException.getDetail(),
                        null, fieldErrors);
        return buildResponseEntity(problem, status);
    }

    private ResponseEntity<Problem> buildResponseEntity(
            final Problem problem, final HttpStatus status) {
        return ResponseEntity.status(status).contentType(MediaType.APPLICATION_JSON).body(problem);
    }

    private ResponseEntity<CustomProblem> buildResponseEntity(
            final CustomProblem problem, final HttpStatus status) {
        return ResponseEntity.status(status).contentType(MediaType.APPLICATION_JSON).body(problem);
    }
}
