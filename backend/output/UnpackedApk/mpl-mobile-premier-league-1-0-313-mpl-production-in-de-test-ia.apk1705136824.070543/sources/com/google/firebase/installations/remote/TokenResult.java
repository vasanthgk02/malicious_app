package com.google.firebase.installations.remote;

public abstract class TokenResult {

    public static abstract class Builder {
        public abstract TokenResult build();

        public abstract Builder setTokenExpirationTimestamp(long j);
    }

    public enum ResponseCode {
        OK,
        BAD_CONFIG,
        AUTH_ERROR
    }

    public static Builder builder() {
        com.google.firebase.installations.remote.AutoValue_TokenResult.Builder builder = new com.google.firebase.installations.remote.AutoValue_TokenResult.Builder();
        builder.setTokenExpirationTimestamp(0);
        return builder;
    }
}
