package com.clevertap.android.sdk;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

public final class ActivityLifecycleCallback {
    public static boolean registered;

    @TargetApi(14)
    public static synchronized void register(Application application, String str) {
        synchronized (ActivityLifecycleCallback.class) {
            if (application == null) {
                Logger.i("Application instance is null/system API is too old");
            } else if (registered) {
                Logger.v("Lifecycle callbacks have already been registered");
            } else {
                registered = true;
                application.registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks(null) {
                    public void onActivityCreated(Activity activity, Bundle bundle) {
                        String str = null;
                        if (str != null) {
                            CleverTapAPI.onActivityCreated(activity, str);
                        } else {
                            CleverTapAPI.onActivityCreated(activity, null);
                        }
                    }

                    public void onActivityDestroyed(Activity activity) {
                    }

                    public void onActivityPaused(Activity activity) {
                        CleverTapAPI.onActivityPaused();
                    }

                    public void onActivityResumed(Activity activity) {
                        String str = null;
                        if (str != null) {
                            CleverTapAPI.onActivityResumed(activity, str);
                        } else {
                            CleverTapAPI.onActivityResumed(activity, null);
                        }
                    }

                    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                    }

                    public void onActivityStarted(Activity activity) {
                    }

                    public void onActivityStopped(Activity activity) {
                    }
                });
                Logger.i("Activity Lifecycle Callback successfully registered");
            }
        }
    }
}
