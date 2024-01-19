package com.freshchat.consumer.sdk;

import android.net.Uri;
import android.os.Bundle;
import com.freshchat.consumer.sdk.b.c;
import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.j.as;

public final class FreshchatNotificationConfig {
    public String backstackFallbackActivityClassName;
    public int importance = 3;
    public int largeIconResId;
    public boolean notificationInterceptionEnabled;
    public boolean notificationSoundEnabled = true;
    public Uri notificationSoundUri;
    public int priority = 0;
    public int smallIconResId;

    private FreshchatNotificationConfig launchActivityOnFinish(String str, Bundle bundle, int i) {
        if (as.a(str)) {
            this.backstackFallbackActivityClassName = str.trim();
        } else {
            ai.w("FRESHCHAT_WARNING", "Invalid activity name received in launchActivityOnFinish()");
        }
        return this;
    }

    public String getActivityToLaunchOnFinish() {
        return this.backstackFallbackActivityClassName;
    }

    public int getImportance() {
        return this.importance;
    }

    public int getLargeIcon() {
        return this.largeIconResId;
    }

    public Uri getNotificationSound() {
        return this.notificationSoundUri;
    }

    public int getPriority() {
        return this.priority;
    }

    public int getSmallIcon() {
        return this.smallIconResId;
    }

    public boolean isNotificationInterceptionEnabled() {
        return this.notificationInterceptionEnabled;
    }

    public boolean isNotificationSoundEnabled() {
        return this.notificationSoundEnabled;
    }

    public FreshchatNotificationConfig launchActivityOnFinish(String str) {
        launchActivityOnFinish(str, null, -1);
        return this;
    }

    public FreshchatNotificationConfig setImportance(int i) {
        if (i < 0 || i > 5) {
            ai.w("FRESHCHAT_WARNING", c.INVALID_NOTIFICATION_CONFIG_IMPORTANCE_VALUE.toString().replace("{{importance}}", String.valueOf(i)));
        } else {
            this.importance = i;
        }
        return this;
    }

    public FreshchatNotificationConfig setLargeIcon(int i) {
        this.largeIconResId = i;
        return this;
    }

    public FreshchatNotificationConfig setNotificationInterceptionEnabled(boolean z) {
        this.notificationInterceptionEnabled = z;
        return this;
    }

    public FreshchatNotificationConfig setNotificationSound(Uri uri) {
        this.notificationSoundUri = uri;
        return this;
    }

    public FreshchatNotificationConfig setNotificationSoundEnabled(boolean z) {
        this.notificationSoundEnabled = z;
        return this;
    }

    public FreshchatNotificationConfig setPriority(int i) {
        if (i < -2 || i > 2) {
            ai.w("FRESHCHAT_WARNING", "Invalid notification priority value provided : " + i + ", fallback to default priority");
        } else {
            this.priority = i;
        }
        return this;
    }

    public FreshchatNotificationConfig setSmallIcon(int i) {
        this.smallIconResId = i;
        return this;
    }
}
