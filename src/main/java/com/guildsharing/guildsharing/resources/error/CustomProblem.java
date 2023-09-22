package com.guildsharing.guildsharing.resources.error;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.hateoas.mediatype.problem.Problem;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

import java.net.URI;
import java.util.List;

@Data
public class CustomProblem extends Problem {
    @JsonIgnoreProperties({"codes", "arguments", "objectName", "rejectedValue", "bindingFailure", "code"})
    private List<FieldError> fieldErrors;

    public CustomProblem(URI type, String title, int status, String detail, URI instance, List<FieldError> fieldErrors) {
        super(type, title, status, detail, instance);
        this.fieldErrors = fieldErrors;
    }
}
