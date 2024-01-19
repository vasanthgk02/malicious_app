package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.core.JsonProcessingException;

public class JsonMappingException extends JsonProcessingException {
    public static final long serialVersionUID = 1;

    public String getLocalizedMessage() {
        return super.getMessage();
    }

    public String getMessage() {
        return super.getMessage();
    }

    public String toString() {
        return getClass().getName() + ": " + getMessage();
    }
}
