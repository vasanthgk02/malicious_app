package com.google.firebase.remoteconfig;

public interface FirebaseRemoteConfigValue {
    boolean asBoolean() throws IllegalArgumentException;

    double asDouble() throws IllegalArgumentException;

    long asLong() throws IllegalArgumentException;

    String asString();

    int getSource();
}
