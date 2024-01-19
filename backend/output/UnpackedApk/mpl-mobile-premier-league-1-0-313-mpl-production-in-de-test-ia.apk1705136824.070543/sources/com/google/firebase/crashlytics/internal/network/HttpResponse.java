package com.google.firebase.crashlytics.internal.network;

public class HttpResponse {
    public final String body;
    public final int code;

    public HttpResponse(int i, String str) {
        this.code = i;
        this.body = str;
    }

    public String body() {
        return this.body;
    }

    public int code() {
        return this.code;
    }
}
