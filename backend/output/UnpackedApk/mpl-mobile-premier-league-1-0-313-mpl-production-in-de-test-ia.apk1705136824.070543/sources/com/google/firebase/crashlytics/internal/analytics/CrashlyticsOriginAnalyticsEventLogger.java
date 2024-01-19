package com.google.firebase.crashlytics.internal.analytics;

import android.os.Bundle;
import com.google.firebase.analytics.connector.AnalyticsConnector;

public class CrashlyticsOriginAnalyticsEventLogger implements AnalyticsEventLogger {
    public static final String FIREBASE_ANALYTICS_ORIGIN_CRASHLYTICS = "clx";
    public final AnalyticsConnector analyticsConnector;

    public CrashlyticsOriginAnalyticsEventLogger(AnalyticsConnector analyticsConnector2) {
        this.analyticsConnector = analyticsConnector2;
    }

    public void logEvent(String str, Bundle bundle) {
        this.analyticsConnector.logEvent("clx", str, bundle);
    }
}
