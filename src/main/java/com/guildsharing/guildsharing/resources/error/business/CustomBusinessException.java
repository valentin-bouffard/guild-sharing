package com.guildsharing.guildsharing.resources.error.business;

import com.guildsharing.guildsharing.resources.error.CustomRuntimeException;
import com.guildsharing.guildsharing.resources.error.ErrorLabel;

public abstract class CustomBusinessException extends CustomRuntimeException {

    public CustomBusinessException(String logMessage, String title, String translationKey, Throwable cause) {
        super(logMessage, title, translationKey, cause);
    }

}
