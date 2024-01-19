package com.twitter.sdk.android.core;

public class Twitter {
    public static final DefaultLogger DEFAULT_LOGGER = new DefaultLogger();

    public static void getInstance() {
        throw new IllegalStateException("Must initialize Twitter before using getInstance()");
    }

    public static DefaultLogger getLogger() {
        return DEFAULT_LOGGER;
    }
}
