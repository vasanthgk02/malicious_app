package com.facebook.appevents.ondeviceprocessing;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.facebook.appevents.AppEvent;
import com.facebook.appevents.ondeviceprocessing.RemoteServiceWrapper.EventType;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\b\u0010\n\u001a\u00020\u0007H\u0007J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0007J\u001c\u0010\u000e\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0007R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/facebook/appevents/ondeviceprocessing/OnDeviceProcessingManager;", "", "()V", "ALLOWED_IMPLICIT_EVENTS", "", "", "isEventEligibleForOnDeviceProcessing", "", "event", "Lcom/facebook/appevents/AppEvent;", "isOnDeviceProcessingEnabled", "sendCustomEventAsync", "", "applicationId", "sendInstallEventAsync", "preferencesName", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: OnDeviceProcessingManager.kt */
public final class OnDeviceProcessingManager {
    public static final Set<String> ALLOWED_IMPLICIT_EVENTS = TweetUtils.setOf((T[]) new String[]{"fb_mobile_purchase", "StartTrial", "Subscribe"});
    public static final OnDeviceProcessingManager INSTANCE = new OnDeviceProcessingManager();

    /* JADX WARNING: Removed duplicated region for block: B:29:0x005a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean isOnDeviceProcessingEnabled() {
        /*
            java.lang.Class<com.facebook.appevents.ondeviceprocessing.OnDeviceProcessingManager> r0 = com.facebook.appevents.ondeviceprocessing.OnDeviceProcessingManager.class
            boolean r1 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r0)
            r2 = 0
            if (r1 == 0) goto L_0x000a
            return r2
        L_0x000a:
            com.facebook.FacebookSdk r1 = com.facebook.FacebookSdk.INSTANCE     // Catch:{ all -> 0x005c }
            android.content.Context r1 = com.facebook.FacebookSdk.getApplicationContext()     // Catch:{ all -> 0x005c }
            com.facebook.FacebookSdk r3 = com.facebook.FacebookSdk.INSTANCE     // Catch:{ all -> 0x005c }
            boolean r1 = com.facebook.FacebookSdk.getLimitEventAndDataUsage(r1)     // Catch:{ all -> 0x005c }
            r3 = 1
            if (r1 != 0) goto L_0x0021
            boolean r1 = com.facebook.internal.Utility.isDataProcessingRestricted()     // Catch:{ all -> 0x005c }
            if (r1 != 0) goto L_0x0021
            r1 = 1
            goto L_0x0022
        L_0x0021:
            r1 = 0
        L_0x0022:
            if (r1 == 0) goto L_0x005b
            java.lang.Class<com.facebook.appevents.ondeviceprocessing.RemoteServiceWrapper> r1 = com.facebook.appevents.ondeviceprocessing.RemoteServiceWrapper.class
            boolean r4 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r1)     // Catch:{ all -> 0x005c }
            if (r4 == 0) goto L_0x002d
            goto L_0x004c
        L_0x002d:
            java.lang.Boolean r4 = com.facebook.appevents.ondeviceprocessing.RemoteServiceWrapper.isServiceAvailable     // Catch:{ all -> 0x0053 }
            if (r4 != 0) goto L_0x0048
            com.facebook.FacebookSdk r4 = com.facebook.FacebookSdk.INSTANCE     // Catch:{ all -> 0x0053 }
            android.content.Context r4 = com.facebook.FacebookSdk.getApplicationContext()     // Catch:{ all -> 0x0053 }
            com.facebook.appevents.ondeviceprocessing.RemoteServiceWrapper r5 = com.facebook.appevents.ondeviceprocessing.RemoteServiceWrapper.INSTANCE     // Catch:{ all -> 0x0053 }
            android.content.Intent r4 = r5.getVerifiedServiceIntent(r4)     // Catch:{ all -> 0x0053 }
            if (r4 == 0) goto L_0x0041
            r4 = 1
            goto L_0x0042
        L_0x0041:
            r4 = 0
        L_0x0042:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)     // Catch:{ all -> 0x0053 }
            com.facebook.appevents.ondeviceprocessing.RemoteServiceWrapper.isServiceAvailable = r4     // Catch:{ all -> 0x0053 }
        L_0x0048:
            java.lang.Boolean r4 = com.facebook.appevents.ondeviceprocessing.RemoteServiceWrapper.isServiceAvailable     // Catch:{ all -> 0x0053 }
            if (r4 != 0) goto L_0x004e
        L_0x004c:
            r0 = 0
            goto L_0x0058
        L_0x004e:
            boolean r0 = r4.booleanValue()     // Catch:{ all -> 0x0053 }
            goto L_0x0058
        L_0x0053:
            r4 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r4, r1)     // Catch:{ all -> 0x005c }
            goto L_0x004c
        L_0x0058:
            if (r0 == 0) goto L_0x005b
            r2 = 1
        L_0x005b:
            return r2
        L_0x005c:
            r1 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r1, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.ondeviceprocessing.OnDeviceProcessingManager.isOnDeviceProcessingEnabled():boolean");
    }

    /* renamed from: sendCustomEventAsync$lambda-1  reason: not valid java name */
    public static final void m182sendCustomEventAsync$lambda1(String str, AppEvent appEvent) {
        Class<RemoteServiceWrapper> cls;
        Class<OnDeviceProcessingManager> cls2 = OnDeviceProcessingManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls2)) {
            try {
                Intrinsics.checkNotNullParameter(str, "$applicationId");
                Intrinsics.checkNotNullParameter(appEvent, "$event");
                List listOf = TweetUtils.listOf(appEvent);
                cls = RemoteServiceWrapper.class;
                if (!CrashShieldHandler.isObjectCrashing(cls)) {
                    Intrinsics.checkNotNullParameter(str, "applicationId");
                    Intrinsics.checkNotNullParameter(listOf, "appEvents");
                    RemoteServiceWrapper.INSTANCE.sendEvents(EventType.CUSTOM_APP_EVENTS, str, listOf);
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls2);
            }
        }
    }

    /* renamed from: sendInstallEventAsync$lambda-0  reason: not valid java name */
    public static final void m183sendInstallEventAsync$lambda0(Context context, String str, String str2) {
        Class<RemoteServiceWrapper> cls;
        Class<OnDeviceProcessingManager> cls2 = OnDeviceProcessingManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls2)) {
            try {
                Intrinsics.checkNotNullParameter(context, "$context");
                SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
                String stringPlus = Intrinsics.stringPlus(str2, "pingForOnDevice");
                if (sharedPreferences.getLong(stringPlus, 0) == 0) {
                    cls = RemoteServiceWrapper.class;
                    if (!CrashShieldHandler.isObjectCrashing(cls)) {
                        Intrinsics.checkNotNullParameter(str2, "applicationId");
                        RemoteServiceWrapper.INSTANCE.sendEvents(EventType.MOBILE_APP_INSTALL, str2, EmptyList.INSTANCE);
                    }
                    Editor edit = sharedPreferences.edit();
                    edit.putLong(stringPlus, System.currentTimeMillis());
                    edit.apply();
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls2);
            }
        }
    }
}
