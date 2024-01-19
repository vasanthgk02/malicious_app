package com.freshchat.consumer.sdk.beans.config;

public class DefaultUserAuthConfig extends UserAuthConfig {
    public static final long DEFAULT_AUTH_TIMEOUT_INTERVAL = 30000;
    public static final boolean JWT_AUTH_ENABLED = false;
    public static final boolean STRICT_MODE_ENABLED = false;

    public DefaultUserAuthConfig() {
        setJwtAuthEnabled(false);
        setStrictModeEnabled(false);
        setAuthTimeOutInterval(30000);
    }
}
