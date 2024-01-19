package com.fasterxml.jackson.databind.exc;

public abstract class PropertyBindingException extends MismatchedInputException {
    public transient String _propertiesAsString;

    public String getMessageSuffix() {
        return this._propertiesAsString;
    }
}
