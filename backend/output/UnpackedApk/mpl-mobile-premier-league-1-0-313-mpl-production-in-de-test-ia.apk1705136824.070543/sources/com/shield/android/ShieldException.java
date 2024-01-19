package com.shield.android;

import java.io.IOException;

public class ShieldException extends RuntimeException {
    public final String body;
    public final int code;
    public final Kind kind;
    public final String message;

    public enum Kind {
        NETWORK,
        HTTP,
        UNEXPECTED
    }

    public ShieldException(String str, int i, String str2, String str3, Kind kind2, Throwable th) {
        super(str2, th);
        this.kind = kind2;
        this.message = str2;
        this.body = str3;
        this.code = i;
    }

    public static ShieldException httpError(String str, int i, String str2, String str3) {
        ShieldException shieldException = new ShieldException(str, i, str2, str3, Kind.HTTP, null);
        return shieldException;
    }

    public static ShieldException networkError(IOException iOException) {
        ShieldException shieldException = new ShieldException(null, 0, iOException.getMessage(), null, Kind.NETWORK, iOException);
        return shieldException;
    }

    public static ShieldException unexpectedError(Throwable th) {
        ShieldException shieldException = new ShieldException(null, 0, th.getMessage(), null, Kind.UNEXPECTED, th);
        return shieldException;
    }
}
