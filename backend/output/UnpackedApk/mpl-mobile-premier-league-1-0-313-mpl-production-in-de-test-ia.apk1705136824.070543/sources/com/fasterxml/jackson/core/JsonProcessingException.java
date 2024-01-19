package com.fasterxml.jackson.core;

import java.io.IOException;

public class JsonProcessingException extends IOException {
    public static final long serialVersionUID = 123;

    public String getMessage() {
        String message = super.getMessage();
        if (message == null) {
            message = "N/A";
        }
        String messageSuffix = getMessageSuffix();
        if (messageSuffix == null) {
            return message;
        }
        StringBuilder sb = new StringBuilder(100);
        sb.append(message);
        if (messageSuffix != null) {
            sb.append(messageSuffix);
        }
        return sb.toString();
    }

    public String getMessageSuffix() {
        return null;
    }

    public String toString() {
        return getClass().getName() + ": " + getMessage();
    }
}
