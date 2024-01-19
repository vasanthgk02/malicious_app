package com.clevertap.android.sdk;

import android.app.Activity;
import android.location.Location;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONObject;

public class CoreMetaData extends CleverTapMetaData {
    public static int activityCount;
    public static boolean appForeground;
    public static WeakReference<Activity> currentActivity;
    public static int initialAppEnteredForegroundTime;
    public long appInstallTime = 0;
    public boolean appLaunchPushed = false;
    public final Object appLaunchPushedLock = new Object();
    public String campaign = null;
    public String currentScreenName = null;
    public int currentSessionId = 0;
    public boolean currentUserOptedOut = false;
    public HashMap<String, Integer> customSdkVersions = new HashMap<>();
    public int directCallSDKVersion = 0;
    public boolean firstRequestInSession = false;
    public boolean firstSession = false;
    public int geofenceSDKVersion = 0;
    public boolean installReferrerDataSent = false;
    public boolean isBgPing = false;
    public boolean isLocationForGeofence = false;
    public boolean isProductConfigRequested;
    public String lastNotificationId;
    public int lastSessionLength = 0;
    public Location locationFromUser = null;
    public String medium = null;
    public final Object optOutFlagLock = new Object();
    public long referrerClickTime = 0;
    public String source = null;
    public JSONObject wzrkParams = null;

    public static Activity getCurrentActivity() {
        WeakReference<Activity> weakReference = currentActivity;
        if (weakReference == null) {
            return null;
        }
        return (Activity) weakReference.get();
    }

    public static void setCurrentActivity(Activity activity) {
        if (activity == null) {
            currentActivity = null;
            return;
        }
        if (!activity.getLocalClassName().contains("InAppNotificationActivity")) {
            currentActivity = new WeakReference<>(activity);
        }
    }

    public boolean inCurrentSession() {
        return this.currentSessionId > 0;
    }

    public boolean isAppLaunchPushed() {
        boolean z;
        synchronized (this.appLaunchPushedLock) {
            try {
                z = this.appLaunchPushed;
            }
        }
        return z;
    }

    public void setAppLaunchPushed(boolean z) {
        synchronized (this.appLaunchPushedLock) {
            this.appLaunchPushed = z;
        }
    }

    public void setCurrentUserOptedOut(boolean z) {
        synchronized (this.optOutFlagLock) {
            this.currentUserOptedOut = z;
        }
    }

    public synchronized void setWzrkParams(JSONObject jSONObject) {
        if (this.wzrkParams == null) {
            this.wzrkParams = jSONObject;
        }
    }
}
