package com.freshchat.consumer.sdk.beans.config;

import java.util.HashSet;
import java.util.Set;

public class DefaultRemoteConfig extends RemoteConfig {
    public static final Set<String> ENABLED_FEATURES;
    public static final long SESSION_TIMEOUT_DURATION = 1800000;

    static {
        HashSet hashSet = new HashSet();
        ENABLED_FEATURES = hashSet;
        hashSet.add(Feature.FAQ.name());
        ENABLED_FEATURES.add(Feature.INBOX.name());
    }

    public DefaultRemoteConfig() {
        setAccountActive(true);
        setEnabledFeatures(ENABLED_FEATURES);
        setSessionTimeoutInterval(SESSION_TIMEOUT_DURATION);
        setConversationConfig(new DefaultConversationConfig());
        setRefreshIntervals(new DefaultRefreshIntervals());
        setCsatConfig(new DefaultCsatConfig());
        setUserAuthConfig(new DefaultUserAuthConfig());
        setEventsConfig(new DefaultUserEventsConfig());
        setLiveTranslationConfig(new DefaultLiveTranslationConfig());
        setAccountConfig(new DefaultAccountConfig());
    }
}
