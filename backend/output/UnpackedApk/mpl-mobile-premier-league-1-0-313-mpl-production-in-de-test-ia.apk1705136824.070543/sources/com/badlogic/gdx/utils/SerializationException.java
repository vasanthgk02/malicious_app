package com.badlogic.gdx.utils;

public class SerializationException extends RuntimeException {
    public StringBuilder trace;

    public SerializationException() {
    }

    public void addTrace(String str) {
        if (str != null) {
            if (this.trace == null) {
                this.trace = new StringBuilder(512);
            }
            this.trace.append0(10);
            this.trace.append0(str);
            return;
        }
        throw new IllegalArgumentException("info cannot be null.");
    }

    public String getMessage() {
        if (this.trace == null) {
            return super.getMessage();
        }
        StringBuilder stringBuilder = new StringBuilder(512);
        stringBuilder.append0(super.getMessage());
        if (stringBuilder.length > 0) {
            stringBuilder.append0(10);
        }
        stringBuilder.append0((String) "Serialization trace:");
        StringBuilder stringBuilder2 = this.trace;
        if (stringBuilder2 == null) {
            stringBuilder.appendNull();
        } else {
            stringBuilder.append0(stringBuilder2.chars, 0, stringBuilder2.length);
        }
        return stringBuilder.toString();
    }

    public SerializationException(String str, Throwable th) {
        super(str, th);
    }

    public SerializationException(String str) {
        super(str);
    }

    public SerializationException(Throwable th) {
        super("", th);
    }
}
