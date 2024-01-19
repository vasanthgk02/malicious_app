package com.freshchat.consumer.sdk.beans.config;

public class DefaultLiveTranslationConfig extends LiveTranslationConfig {
    public static final boolean LIVE_TRANSLATION_ENABLED = false;

    public DefaultLiveTranslationConfig() {
        setEnabled(false);
    }
}
