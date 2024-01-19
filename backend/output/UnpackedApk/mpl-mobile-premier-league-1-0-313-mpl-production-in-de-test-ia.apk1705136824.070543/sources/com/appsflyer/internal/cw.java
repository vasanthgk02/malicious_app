package com.appsflyer.internal;

public enum cw {
    SUCCESS,
    FAILURE,
    NA,
    INTERNAL_ERROR;

    public final String toString() {
        return super.toString().toLowerCase();
    }
}
