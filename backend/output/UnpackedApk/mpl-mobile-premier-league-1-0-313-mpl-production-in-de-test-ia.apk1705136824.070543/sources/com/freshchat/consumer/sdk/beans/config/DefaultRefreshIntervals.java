package com.freshchat.consumer.sdk.beans.config;

public class DefaultRefreshIntervals extends RefreshIntervals {
    public static final long ACTIVE_CONV_MAX_FETCH_INTERVAL = 60000;
    public static final long ACTIVE_CONV_MIN_FETCH_INTERVAL = 20000;
    public static final long CHANNELS_FETCH_INTERVAL_LAID_BACK = 604800000;
    public static final long CHANNELS_FETCH_INTERVAL_NORMAL = 300000;
    public static final long FAQ_FETCH_INTERVAL_LAIDBACK = 604800000;
    public static final long FAQ_FETCH_INTERVAL_NORMAL = 300000;
    public static final long MESSAGES_FETCH_INTERVAL_LAIDBACK = 60000;
    public static final long MESSAGES_FETCH_INTERVAL_NORMAL = 30000;
    public static final long REMOTE_CONFIG_FETCH_INTERVAL = 3600000;
    public static final long RESPONSE_TIME_EXPECTATIONS_FETCH_INTERVAL = 300000;

    public DefaultRefreshIntervals() {
        setRemoteConfigFetchInterval(3600000);
        setResponseTimeExpectationsFetchInterval(300000);
        setActiveConvMinFetchInterval(ACTIVE_CONV_MIN_FETCH_INTERVAL);
        setActiveConvMaxFetchInterval(60000);
        setMsgFetchIntervalNormal(30000);
        setMsgFetchIntervalLaidback(60000);
        setFaqFetchIntervalNormal(300000);
        setFaqFetchIntervalLaidback(604800000);
        setChannelsFetchIntervalNormal(300000);
        setChannelsFetchIntervalLaidback(604800000);
    }
}
