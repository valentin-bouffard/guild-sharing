package com.guildsharing.guildsharing.resources.error;

public class InvalidInputException extends RuntimeException implements ICustomException {

    private static final ErrorLabel LABEL = ErrorLabel.INVALID_INPUT;

    private final String logMessage;

    public InvalidInputException(String logMessage, Throwable cause) {
        super(cause);
        this.logMessage = logMessage;
    }
    @Override
    public String getLogMessage() {
        return logMessage;
    }

    @Override
    public String getDetail() {
        return LABEL.getMessage();
    }

    @Override
    public String getTitle() {
        return LABEL.getErrorKey();
    }
}
