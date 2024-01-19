package com.freshchat.consumer.sdk.beans.config;

import com.freshchat.consumer.sdk.beans.config.AccountConfig.FAQAPIVersion;

public class DefaultAccountConfig extends AccountConfig {
    public static final FAQAPIVersion DEFAULT_FAQ_API_VERSION = FAQAPIVersion.STANDALONE;

    public DefaultAccountConfig() {
        setFcFaqApiVersion(DEFAULT_FAQ_API_VERSION);
    }
}
