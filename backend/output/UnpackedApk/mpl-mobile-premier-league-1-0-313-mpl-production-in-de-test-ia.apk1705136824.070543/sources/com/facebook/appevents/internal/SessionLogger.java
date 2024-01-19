package com.facebook.appevents.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsLogger.FlushBehavior;
import com.facebook.appevents.AppEventsLoggerImpl;
import com.facebook.internal.Logger;
import com.facebook.internal.Logger.Companion;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.internal.security.CertificateUtil;
import com.freshchat.consumer.sdk.beans.config.DefaultConversationConfig;
import com.freshchat.consumer.sdk.beans.config.DefaultRemoteConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J,\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0007J\b\u0010\u0016\u001a\u00020\u0011H\u0002J$\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u0015\u001a\u0004\u0018\u00010\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \b*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/facebook/appevents/internal/SessionLogger;", "", "()V", "INACTIVE_SECONDS_QUANTA", "", "PACKAGE_CHECKSUM", "", "TAG", "kotlin.jvm.PlatformType", "computePackageChecksum", "context", "Landroid/content/Context;", "getQuantaIndex", "", "timeBetweenSessions", "", "logActivateApp", "", "activityName", "sourceApplicationInfo", "Lcom/facebook/appevents/internal/SourceApplicationInfo;", "appId", "logClockSkewEvent", "logDeactivateApp", "sessionInfo", "Lcom/facebook/appevents/internal/SessionInfo;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: SessionLogger.kt */
public final class SessionLogger {
    public static final long[] INACTIVE_SECONDS_QUANTA = {300000, 900000, DefaultRemoteConfig.SESSION_TIMEOUT_DURATION, 3600000, 21600000, 43200000, 86400000, 172800000, DefaultConversationConfig.ACTIVE_CONV_WINDOW, 604800000, 1209600000, 1814400000, 2419200000L, 5184000000L, 7776000000L, 10368000000L, 12960000000L, 15552000000L, 31536000000L};
    public static final SessionLogger INSTANCE = new SessionLogger();

    public static final void logActivateApp(String str, SourceApplicationInfo sourceApplicationInfo, String str2, Context context) {
        Class<SessionLogger> cls = SessionLogger.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(str, "activityName");
                Intrinsics.checkNotNullParameter(context, "context");
                Bundle bundle = new Bundle();
                bundle.putString("fb_mobile_launch_source", "Unclassified");
                bundle.putString("fb_mobile_pckg_fp", INSTANCE.computePackageChecksum(context));
                bundle.putString("fb_mobile_app_cert_hash", CertificateUtil.getCertificateHash(context));
                Intrinsics.checkNotNullParameter(str, "activityName");
                Intrinsics.checkNotNullParameter(str, "activityName");
                AppEventsLoggerImpl appEventsLoggerImpl = new AppEventsLoggerImpl(str, str2, (AccessToken) null);
                Intrinsics.checkNotNullParameter(appEventsLoggerImpl, "loggerImpl");
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                if (FacebookSdk.getAutoLogAppEventsEnabled()) {
                    appEventsLoggerImpl.logEvent("fb_mobile_activate_app", bundle);
                }
                if (AppEventsLoggerImpl.Companion.getFlushBehavior() != FlushBehavior.EXPLICIT_ONLY) {
                    appEventsLoggerImpl.flush();
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00af, code lost:
        if (r0 == null) goto L_0x00b1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0056 A[Catch:{ all -> 0x008a, all -> 0x00f2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00aa A[Catch:{ all -> 0x008a, all -> 0x00f2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00ab A[Catch:{ all -> 0x008a, all -> 0x00f2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00be A[Catch:{ all -> 0x008a, all -> 0x00f2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00c1 A[Catch:{ all -> 0x008a, all -> 0x00f2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00ee A[Catch:{ all -> 0x008a, all -> 0x00f2 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void logDeactivateApp(java.lang.String r18, com.facebook.appevents.internal.SessionInfo r19, java.lang.String r20) {
        /*
            r1 = r18
            r2 = r19
            java.lang.String r3 = "activityName"
            java.lang.Class<com.facebook.appevents.internal.SessionLogger> r4 = com.facebook.appevents.internal.SessionLogger.class
            boolean r0 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r4)
            if (r0 == 0) goto L_0x000f
            return
        L_0x000f:
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r3)     // Catch:{ all -> 0x00f2 }
            if (r2 != 0) goto L_0x0015
            return
        L_0x0015:
            java.lang.Long r0 = r2.diskRestoreTime     // Catch:{ all -> 0x00f2 }
            r5 = 0
            if (r0 != 0) goto L_0x001f
            java.lang.Long r0 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x00f2 }
        L_0x001f:
            if (r0 != 0) goto L_0x002e
            java.lang.Long r0 = r2.sessionLastEventTime     // Catch:{ all -> 0x00f2 }
            if (r0 != 0) goto L_0x0027
            r7 = r5
            goto L_0x002b
        L_0x0027:
            long r7 = r0.longValue()     // Catch:{ all -> 0x00f2 }
        L_0x002b:
            long r7 = r5 - r7
            goto L_0x0032
        L_0x002e:
            long r7 = r0.longValue()     // Catch:{ all -> 0x00f2 }
        L_0x0032:
            int r0 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x003c
            com.facebook.appevents.internal.SessionLogger r0 = INSTANCE     // Catch:{ all -> 0x00f2 }
            r0.logClockSkewEvent()     // Catch:{ all -> 0x00f2 }
            r7 = r5
        L_0x003c:
            java.lang.Long r0 = r2.sessionStartTime     // Catch:{ all -> 0x00f2 }
            if (r0 == 0) goto L_0x0051
            java.lang.Long r0 = r2.sessionLastEventTime     // Catch:{ all -> 0x00f2 }
            if (r0 != 0) goto L_0x0045
            goto L_0x0051
        L_0x0045:
            long r9 = r0.longValue()     // Catch:{ all -> 0x00f2 }
            java.lang.Long r0 = r2.sessionStartTime     // Catch:{ all -> 0x00f2 }
            long r11 = r0.longValue()     // Catch:{ all -> 0x00f2 }
            long r9 = r9 - r11
            goto L_0x0052
        L_0x0051:
            r9 = r5
        L_0x0052:
            int r0 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x005c
            com.facebook.appevents.internal.SessionLogger r0 = INSTANCE     // Catch:{ all -> 0x00f2 }
            r0.logClockSkewEvent()     // Catch:{ all -> 0x00f2 }
            r9 = r5
        L_0x005c:
            android.os.Bundle r11 = new android.os.Bundle     // Catch:{ all -> 0x00f2 }
            r11.<init>()     // Catch:{ all -> 0x00f2 }
            java.lang.String r0 = "fb_mobile_app_interruptions"
            int r12 = r2.interruptionCount     // Catch:{ all -> 0x00f2 }
            r11.putInt(r0, r12)     // Catch:{ all -> 0x00f2 }
            java.lang.String r12 = "fb_mobile_time_between_sessions"
            java.util.Locale r13 = java.util.Locale.ROOT     // Catch:{ all -> 0x00f2 }
            java.lang.String r14 = "session_quanta_%d"
            r15 = 1
            java.lang.Object[] r5 = new java.lang.Object[r15]     // Catch:{ all -> 0x00f2 }
            boolean r0 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r4)     // Catch:{ all -> 0x00f2 }
            r6 = 0
            if (r0 == 0) goto L_0x0079
            goto L_0x008e
        L_0x0079:
            r0 = 0
        L_0x007a:
            long[] r15 = INACTIVE_SECONDS_QUANTA     // Catch:{ all -> 0x008a }
            int r15 = r15.length     // Catch:{ all -> 0x008a }
            if (r0 >= r15) goto L_0x008f
            long[] r15 = INACTIVE_SECONDS_QUANTA     // Catch:{ all -> 0x008a }
            r16 = r15[r0]     // Catch:{ all -> 0x008a }
            int r15 = (r16 > r7 ? 1 : (r16 == r7 ? 0 : -1))
            if (r15 >= 0) goto L_0x008f
            int r0 = r0 + 1
            goto L_0x007a
        L_0x008a:
            r0 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r0, r4)     // Catch:{ all -> 0x00f2 }
        L_0x008e:
            r0 = 0
        L_0x008f:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x00f2 }
            r5[r6] = r0     // Catch:{ all -> 0x00f2 }
            r6 = 1
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r5, r6)     // Catch:{ all -> 0x00f2 }
            java.lang.String r0 = java.lang.String.format(r13, r14, r0)     // Catch:{ all -> 0x00f2 }
            java.lang.String r5 = "java.lang.String.format(locale, format, *args)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r5)     // Catch:{ all -> 0x00f2 }
            r11.putString(r12, r0)     // Catch:{ all -> 0x00f2 }
            com.facebook.appevents.internal.SourceApplicationInfo r0 = r2.sourceApplicationInfo     // Catch:{ all -> 0x00f2 }
            if (r0 != 0) goto L_0x00ab
            goto L_0x00b1
        L_0x00ab:
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00f2 }
            if (r0 != 0) goto L_0x00b3
        L_0x00b1:
            java.lang.String r0 = "Unclassified"
        L_0x00b3:
            java.lang.String r5 = "fb_mobile_launch_source"
            r11.putString(r5, r0)     // Catch:{ all -> 0x00f2 }
            java.lang.String r0 = "_logTime"
            java.lang.Long r2 = r2.sessionLastEventTime     // Catch:{ all -> 0x00f2 }
            if (r2 != 0) goto L_0x00c1
            r5 = 0
            goto L_0x00c5
        L_0x00c1:
            long r5 = r2.longValue()     // Catch:{ all -> 0x00f2 }
        L_0x00c5:
            r2 = 1000(0x3e8, float:1.401E-42)
            long r7 = (long) r2     // Catch:{ all -> 0x00f2 }
            long r5 = r5 / r7
            r11.putLong(r0, r5)     // Catch:{ all -> 0x00f2 }
            r0 = 0
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r3)     // Catch:{ all -> 0x00f2 }
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r3)     // Catch:{ all -> 0x00f2 }
            com.facebook.appevents.AppEventsLoggerImpl r2 = new com.facebook.appevents.AppEventsLoggerImpl     // Catch:{ all -> 0x00f2 }
            r3 = r20
            r2.<init>(r1, r3, r0)     // Catch:{ all -> 0x00f2 }
            java.lang.String r0 = "loggerImpl"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)     // Catch:{ all -> 0x00f2 }
            java.lang.String r0 = "fb_mobile_deactivate_app"
            double r5 = (double) r9     // Catch:{ all -> 0x00f2 }
            r7 = 1000(0x3e8, double:4.94E-321)
            double r7 = (double) r7     // Catch:{ all -> 0x00f2 }
            double r5 = r5 / r7
            com.facebook.FacebookSdk r1 = com.facebook.FacebookSdk.INSTANCE     // Catch:{ all -> 0x00f2 }
            boolean r1 = com.facebook.FacebookSdk.getAutoLogAppEventsEnabled()     // Catch:{ all -> 0x00f2 }
            if (r1 == 0) goto L_0x00f1
            r2.logEvent(r0, r5, r11)     // Catch:{ all -> 0x00f2 }
        L_0x00f1:
            return
        L_0x00f2:
            r0 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r0, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.internal.SessionLogger.logDeactivateApp(java.lang.String, com.facebook.appevents.internal.SessionInfo, java.lang.String):void");
    }

    public final String computePackageChecksum(Context context) {
        String str = null;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            String stringPlus = Intrinsics.stringPlus("PCKGCHKSUM;", packageManager.getPackageInfo(context.getPackageName(), 0).versionName);
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0);
            String string = sharedPreferences.getString(stringPlus, null);
            if (string != null && string.length() == 32) {
                return string;
            }
            String computeChecksumWithPackageManager = HashUtils.computeChecksumWithPackageManager(context, null);
            if (computeChecksumWithPackageManager == null) {
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0);
                Intrinsics.checkNotNullExpressionValue(applicationInfo, "pm.getApplicationInfo(context.packageName, 0)");
                computeChecksumWithPackageManager = HashUtils.computeChecksum(applicationInfo.sourceDir);
            }
            sharedPreferences.edit().putString(stringPlus, computeChecksumWithPackageManager).apply();
            str = computeChecksumWithPackageManager;
            return str;
        } catch (Exception unused) {
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public final void logClockSkewEvent() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Companion companion = Logger.Companion;
                LoggingBehavior loggingBehavior = LoggingBehavior.APP_EVENTS;
                Intrinsics.checkNotNull("com.facebook.appevents.internal.SessionLogger");
                companion.log(loggingBehavior, "com.facebook.appevents.internal.SessionLogger", "Clock skew detected");
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }
}
