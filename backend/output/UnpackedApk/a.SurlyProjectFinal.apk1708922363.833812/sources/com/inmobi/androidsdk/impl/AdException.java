package com.inmobi.androidsdk.impl;

public final class AdException extends Exception {
    public static final int INVALID_REQUEST = 300;
    public static final int NO_FILL = 100;
    public static final int PARSE_ERROR = 200;
    public static final int SANDBOX_BADIP = 500;
    public static final int SANDBOX_OOF = 400;
    public static final int SANDBOX_UA = 700;
    public static final int SANDBOX_UAND = 600;
    private static final long serialVersionUID = -3924043691624251411L;
    private int code = INVALID_REQUEST;

    public AdException(String string, Exception exception, int code2) {
        super(string, exception);
        this.code = code2;
    }

    public AdException(String string, int code2) {
        super(string);
        this.code = code2;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code2) {
        this.code = code2;
    }
}
