package com.guildsharing.guildsharing.resources.error;

public class CustomRuntimeException extends RuntimeException implements ICustomException {

    private final String logMessage;
    private final String title;
    private final String translationKey;

    public CustomRuntimeException(String logMessage, String title, String translationKey, Throwable cause) {
        super(cause);
        this.logMessage = logMessage;
        this.title = title;
        this.translationKey = translationKey;
    }

    @Override
    public String getLogMessage() {
        return logMessage;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public String getTranslationKey() {
        return this.translationKey;
    }

}
