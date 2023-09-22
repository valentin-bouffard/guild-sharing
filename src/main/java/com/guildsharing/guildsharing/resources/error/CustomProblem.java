package com.guildsharing.guildsharing.resources.error;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.hateoas.mediatype.problem.Problem;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

import java.net.URI;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CustomProblem extends Problem {
    @JsonIgnoreProperties({"codes", "arguments", "objectName", "rejectedValue", "bindingFailure", "code"})
    private List<FieldError> fieldErrors;
    private String translationKey;

    public CustomProblem(String title, int status, String detail, String translationKey) {
        super(URI.create(""), title, status, detail, URI.create(""));
        this.translationKey = translationKey;
    }
    public CustomProblem(String title, int status, String detail, String translationKey, List<FieldError> fieldErrors) {
        super(URI.create(""), title, status, detail, URI.create(""));
        this.fieldErrors = fieldErrors;
        this.translationKey = translationKey;
    }
}
