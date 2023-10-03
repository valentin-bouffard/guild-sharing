package com.guildsharing.guildsharing.resources.error.business;

import com.guildsharing.guildsharing.resources.error.ErrorLabel;

public class PikachuNotFoundException extends CustomBusinessException {

    private static final ErrorLabel LABEL = ErrorLabel.PIKACHU_NOT_FOUND;

    public PikachuNotFoundException(String logMessage, Throwable cause) {
        super(logMessage, LABEL.getMessage(),LABEL.getErrorKey(), cause);
    }
}
