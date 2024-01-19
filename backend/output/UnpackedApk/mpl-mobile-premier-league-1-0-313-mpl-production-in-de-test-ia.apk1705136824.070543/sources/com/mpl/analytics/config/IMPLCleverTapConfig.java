package com.mpl.analytics.config;

public interface IMPLCleverTapConfig {
    void changeCredentials();

    void disableNetworkInfoReporting();

    void enableNetworkInfoReporting();

    String getCleverTapAttributionIdentifier();

    String getCleverTapID();

    String getCleverTapId();

    String getDevicePushToken(String str);

    void startLoggingEvent();

    void stopLoggingEvent();
}
