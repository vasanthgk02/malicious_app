package com.google.firebase.remoteconfig;

public class FirebaseRemoteConfigFetchThrottledException extends FirebaseRemoteConfigException {
    public FirebaseRemoteConfigFetchThrottledException(long j) {
        super("Fetch was throttled.");
    }

    public FirebaseRemoteConfigFetchThrottledException(String str, long j) {
        super(str);
    }
}
