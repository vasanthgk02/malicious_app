package com.badlogic.gdx.utils;

public class GdxRuntimeException extends RuntimeException {
    public static final long serialVersionUID = 6735854402467673117L;

    public GdxRuntimeException(String str) {
        super(str);
    }

    public GdxRuntimeException(Throwable th) {
        super(th);
    }

    public GdxRuntimeException(String str, Throwable th) {
        super(str, th);
    }
}
