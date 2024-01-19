package com.google.firebase.crashlytics;

import android.os.Bundle;
import com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorListener;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.analytics.AnalyticsEventReceiver;
import java.util.Locale;

public class CrashlyticsAnalyticsListener implements AnalyticsConnectorListener {
    public static final String CRASHLYTICS_ORIGIN = "clx";
    public static final String EVENT_NAME_KEY = "name";
    public static final String EVENT_ORIGIN_KEY = "_o";
    public static final String EVENT_PARAMS_KEY = "params";
    public AnalyticsEventReceiver breadcrumbEventReceiver;
    public AnalyticsEventReceiver crashlyticsOriginEventReceiver;

    public static void notifyEventReceiver(AnalyticsEventReceiver analyticsEventReceiver, String str, Bundle bundle) {
        if (analyticsEventReceiver != null) {
            analyticsEventReceiver.onEvent(str, bundle);
        }
    }

    private void notifyEventReceivers(String str, Bundle bundle) {
        AnalyticsEventReceiver analyticsEventReceiver;
        if ("clx".equals(bundle.getString(EVENT_ORIGIN_KEY))) {
            analyticsEventReceiver = this.crashlyticsOriginEventReceiver;
        } else {
            analyticsEventReceiver = this.breadcrumbEventReceiver;
        }
        notifyEventReceiver(analyticsEventReceiver, str, bundle);
    }

    public void onMessageTriggered(int i, Bundle bundle) {
        Logger.getLogger().v(String.format(Locale.US, "Analytics listener received message. ID: %d, Extras: %s", new Object[]{Integer.valueOf(i), bundle}));
        if (bundle != null) {
            String string = bundle.getString("name");
            if (string != null) {
                Bundle bundle2 = bundle.getBundle(EVENT_PARAMS_KEY);
                if (bundle2 == null) {
                    bundle2 = new Bundle();
                }
                notifyEventReceivers(string, bundle2);
            }
        }
    }

    public void setBreadcrumbEventReceiver(AnalyticsEventReceiver analyticsEventReceiver) {
        this.breadcrumbEventReceiver = analyticsEventReceiver;
    }

    public void setCrashlyticsOriginEventReceiver(AnalyticsEventReceiver analyticsEventReceiver) {
        this.crashlyticsOriginEventReceiver = analyticsEventReceiver;
    }
}
