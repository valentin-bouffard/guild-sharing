package com.guildsharing.guildsharing.resources.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.mediatype.problem.Problem;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProblemFactory {
    public final ResponseEntity<Problem> createError(
            ICustomException linqueoException, HttpStatus status) {
        final Problem problem;
        log.error(linqueoException.getMessage(), linqueoException);
        problem =
                new Problem(
                        null,
                        linqueoException.getMessage(),
                        status.value(),
                        linqueoException.getMessage(),
                        null);
        return buildResponseEntity(problem, status);
    }

    private ResponseEntity<Problem> buildResponseEntity(
            final Problem problem, final HttpStatus status) {
        return ResponseEntity.status(status).contentType(MediaType.APPLICATION_JSON).body(problem);
    }
}
