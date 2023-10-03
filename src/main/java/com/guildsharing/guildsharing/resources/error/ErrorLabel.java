package com.guildsharing.guildsharing.resources.error;

import lombok.Getter;

@Getter
public class ErrorLabel {
    private final String errorKey;
    private final String message;

    private ErrorLabel(final String errorKey, final String message) {
        this.errorKey = errorKey;
        this.message = message;
    }

    private static final String INVALID_INPUT_KEY =
            "invalid-input-exception";
    public static final ErrorLabel INVALID_INPUT =
            new ErrorLabel(
                    INVALID_INPUT_KEY,
                    "Input is invalid");
}

