package com.guildsharing.guildsharing.resources.error.business;

import com.guildsharing.guildsharing.resources.error.ErrorLabel;
import com.guildsharing.guildsharing.resources.error.ICustomException;

public class InvalidInputException extends CustomBusinessException {

    private static final ErrorLabel LABEL = ErrorLabel.INVALID_INPUT;

    public InvalidInputException(String logMessage, Throwable cause) {
        super(logMessage, LABEL.getMessage(),LABEL.getErrorKey(), cause);
    }
}
