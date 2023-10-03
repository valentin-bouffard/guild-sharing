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
                    "Invalid input");


    public static final String PIKACHU_NOT_FOUND_KEY = "pikachu-not-found";
    public static final ErrorLabel PIKACHU_NOT_FOUND =
            new ErrorLabel(
                    PIKACHU_NOT_FOUND_KEY,
                    "Pikachu has not been found");


}

