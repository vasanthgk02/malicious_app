package com.mpl.analytics.notification;

import android.content.Context;
import android.os.Bundle;

public interface IMPLCleverTapNotification {
    void createNotification(Context context, Bundle bundle);

    void createNotification(Context context, Bundle bundle, int i);

    void createNotificationChannel(Context context, String str, CharSequence charSequence, String str2, int i, String str3, boolean z);

    void createNotificationChannel(Context context, String str, CharSequence charSequence, String str2, int i, String str3, boolean z, String str4);

    void createNotificationChannel(Context context, String str, CharSequence charSequence, String str2, int i, boolean z);

    void createNotificationChannel(Context context, String str, CharSequence charSequence, String str2, int i, boolean z, String str3);

    void createNotificationChannelGroup(Context context, String str, String str2);

    void deleteNotificationChannel(Context context, String str);

    void deleteNotificationChannelGroup(Context context, String str);

    boolean isCleverTapNotification(Bundle bundle);

    void pushXiaomiRegistrationId(Context context);

    void registerMIPush(Context context, String str, String str2);
}
