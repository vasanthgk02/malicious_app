package com.freshchat.consumer.sdk.beans.config;

public class DefaultCsatConfig extends CsatConfig {
    public static final int CSAT_TIME_LIMIT = 0;
    public static final boolean CSAT_TIME_LIMITED = false;

    public DefaultCsatConfig() {
        setCsatAutoExpire(false);
        setCsatExpiryInterval(0);
    }
}
