package io.sentry.android.core;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.SystemClock;
import io.sentry.DateUtils;
import java.util.Date;
import org.jetbrains.annotations.ApiStatus.Internal;

@Internal
public final class SentryPerformanceProvider extends ContentProvider {
    public static long appStartMillis = SystemClock.uptimeMillis();
    public static Date appStartTime = DateUtils.getCurrentDateTime();

    public SentryPerformanceProvider() {
        AppStartState.getInstance().setAppStartTime(appStartMillis, appStartTime);
    }

    public static void setAppStartTime(long j, Date date) {
        appStartMillis = j;
        appStartTime = date;
    }

    public void attachInfo(Context context, ProviderInfo providerInfo) {
        if (!SentryPerformanceProvider.class.getName().equals(providerInfo.authority)) {
            super.attachInfo(context, providerInfo);
            return;
        }
        throw new IllegalStateException("An applicationId is required to fulfill the manifest placeholder.");
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public boolean onCreate() {
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
