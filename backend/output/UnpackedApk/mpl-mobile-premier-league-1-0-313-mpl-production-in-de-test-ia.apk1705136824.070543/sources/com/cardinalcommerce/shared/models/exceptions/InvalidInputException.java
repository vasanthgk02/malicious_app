package com.cardinalcommerce.shared.models.exceptions;

public class InvalidInputException extends RuntimeException {

    /* renamed from: a  reason: collision with root package name */
    public final String f2231a;

    /* renamed from: b  reason: collision with root package name */
    public final Throwable f2232b;

    public InvalidInputException(String str, Throwable th) {
        this.f2231a = str;
        this.f2232b = th;
    }

    public Throwable getCause() {
        return this.f2232b;
    }

    public String getMessage() {
        return this.f2231a;
    }
}
