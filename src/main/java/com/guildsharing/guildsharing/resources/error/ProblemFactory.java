package com.guildsharing.guildsharing.resources.error;

import jakarta.validation.ConstraintViolation;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.hateoas.mediatype.problem.Problem;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@Slf4j
public class ProblemFactory {
    public final ResponseEntity<Problem> createError(
            ICustomException customException, HttpStatus status, Set<ConstraintViolation<?>> constraintViolations) {
        final Problem problem;
        log.error(customException.getLogMessage(), customException);
        problem =
                new CustomProblem(
                        null,
                        customException.getTitle(),
                        status.value(),
                        String.format(StringUtils.join(constraintViolations.stream().map(ConstraintViolation::getMessage).collect(Collectors.toSet()), ',')),
                        null, customException.getTranslationKey());
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
                        String.format("%s for fields: %s",customException.getTitle(), StringUtils.join(fieldErrors.stream().map(FieldError::getField).collect(Collectors.toSet()), ',')),
                        null, customException.getTranslationKey(), fieldErrors);
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
