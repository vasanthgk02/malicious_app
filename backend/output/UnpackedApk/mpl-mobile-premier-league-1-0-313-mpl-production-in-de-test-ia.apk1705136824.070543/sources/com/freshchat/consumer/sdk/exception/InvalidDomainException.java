package com.freshchat.consumer.sdk.exception;

public class InvalidDomainException extends Exception {
    public InvalidDomainException() {
        super("Invalid Freshchat Domain. Please check logs for more details");
    }
}
