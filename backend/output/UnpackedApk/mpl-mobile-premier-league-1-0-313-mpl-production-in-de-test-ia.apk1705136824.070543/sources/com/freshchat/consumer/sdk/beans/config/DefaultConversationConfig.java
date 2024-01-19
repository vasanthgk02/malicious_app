package com.freshchat.consumer.sdk.beans.config;

public class DefaultConversationConfig extends ConversationConfig {
    public static final double ACTIVE_CONV_FETCH_BACKOFF_RATIO = 1.25d;
    public static final long ACTIVE_CONV_WINDOW = 259200000;
    public static final boolean LAUNCH_DEEPLINK_FROM_NOTIFICATION = true;

    public DefaultConversationConfig() {
        setActiveConvWindow(ACTIVE_CONV_WINDOW);
        setActiveConvFetchBackoffRatio(1.25d);
        setLaunchDeeplinkFromNotification(true);
    }
}
