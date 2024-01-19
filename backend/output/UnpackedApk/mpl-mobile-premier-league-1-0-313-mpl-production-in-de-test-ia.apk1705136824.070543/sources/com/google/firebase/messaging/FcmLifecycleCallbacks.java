package com.google.firebase.messaging;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.android.material.resources.TextAppearanceConfig;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

public class FcmLifecycleCallbacks implements ActivityLifecycleCallbacks {
    public final Set<Intent> seenIntents = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: logNotificationOpen */
    public final void lambda$onActivityCreated$0$FcmLifecycleCallbacks(Intent intent) {
        boolean z;
        Bundle extras = intent.getExtras();
        if (extras != null) {
            Bundle bundle = extras.getBundle("gcm.n.analytics_data");
            if (bundle == null) {
                z = false;
            } else {
                z = "1".equals(bundle.getString("google.c.a.e"));
            }
            if (z) {
                if (bundle != null) {
                    if ("1".equals(bundle.getString("google.c.a.tc"))) {
                        FirebaseApp instance = FirebaseApp.getInstance();
                        instance.checkNotDeleted();
                        AnalyticsConnector analyticsConnector = (AnalyticsConnector) instance.componentRuntime.get(AnalyticsConnector.class);
                        Log.isLoggable("FirebaseMessaging", 3);
                        if (analyticsConnector != null) {
                            String string = bundle.getString("google.c.a.c_id");
                            analyticsConnector.setUserProperty("fcm", "_ln", string);
                            Bundle bundle2 = new Bundle();
                            bundle2.putString(DefaultSettingsSpiCall.SOURCE_PARAM, "Firebase");
                            bundle2.putString("medium", "notification");
                            bundle2.putString("campaign", string);
                            analyticsConnector.logEvent("fcm", "_cmp", bundle2);
                        }
                    } else {
                        Log.isLoggable("FirebaseMessaging", 3);
                    }
                }
                TextAppearanceConfig.logToScion("_no", bundle);
            }
        }
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        Intent intent = activity.getIntent();
        if (intent != null && this.seenIntents.add(intent)) {
            if (VERSION.SDK_INT <= 24) {
                new Handler(Looper.getMainLooper()).post(new Runnable(intent) {
                    public final /* synthetic */ Intent f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        FcmLifecycleCallbacks.this.lambda$onActivityCreated$0$FcmLifecycleCallbacks(this.f$1);
                    }
                });
            } else {
                lambda$onActivityCreated$0$FcmLifecycleCallbacks(intent);
            }
        }
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
        if (activity.isFinishing()) {
            this.seenIntents.remove(activity.getIntent());
        }
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }
}
