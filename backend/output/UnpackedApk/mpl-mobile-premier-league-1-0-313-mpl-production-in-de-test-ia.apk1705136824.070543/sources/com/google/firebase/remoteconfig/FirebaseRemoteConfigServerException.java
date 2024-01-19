package com.google.firebase.remoteconfig;

public class FirebaseRemoteConfigServerException extends FirebaseRemoteConfigException {
    public final int httpStatusCode;

    public FirebaseRemoteConfigServerException(int i, String str) {
        super(str);
        this.httpStatusCode = i;
    }

    public FirebaseRemoteConfigServerException(int i, String str, Throwable th) {
        super(str, th);
        this.httpStatusCode = i;
    }
}
