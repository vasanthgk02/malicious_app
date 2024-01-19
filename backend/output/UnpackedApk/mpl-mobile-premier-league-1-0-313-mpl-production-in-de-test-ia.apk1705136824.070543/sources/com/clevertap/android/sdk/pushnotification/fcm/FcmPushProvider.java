package com.clevertap.android.sdk.pushnotification.fcm;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.pushnotification.CTPushProvider;
import com.clevertap.android.sdk.pushnotification.CTPushProviderListener;
import com.clevertap.android.sdk.pushnotification.PushConstants;
import com.clevertap.android.sdk.pushnotification.PushConstants.PushType;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

@SuppressLint({"unused"})
public class FcmPushProvider implements CTPushProvider {
    public IFcmSdkHandler handler;

    @SuppressLint({"unused"})
    public FcmPushProvider(CTPushProviderListener cTPushProviderListener, Context context, CleverTapInstanceConfig cleverTapInstanceConfig) {
        this.handler = new FcmSdkHandlerImpl(cTPushProviderListener, context, cleverTapInstanceConfig);
    }

    public int getPlatform() {
        return 1;
    }

    public PushType getPushType() {
        if (((FcmSdkHandlerImpl) this.handler) != null) {
            return PushType.FCM;
        }
        throw null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x001d A[SYNTHETIC, Splitter:B:13:0x001d] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003c A[Catch:{ all -> 0x006c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isAvailable() {
        /*
            r6 = this;
            com.clevertap.android.sdk.pushnotification.fcm.IFcmSdkHandler r0 = r6.handler
            com.clevertap.android.sdk.pushnotification.fcm.FcmSdkHandlerImpl r0 = (com.clevertap.android.sdk.pushnotification.fcm.FcmSdkHandlerImpl) r0
            if (r0 == 0) goto L_0x0087
            java.lang.String r1 = "PushProvider"
            r2 = 1
            android.content.Context r3 = r0.context     // Catch:{ all -> 0x006c }
            java.lang.String r4 = "com.google.android.gms.common.GooglePlayServicesUtil"
            java.lang.Class.forName(r4)     // Catch:{ ClassNotFoundException -> 0x001a }
            com.google.android.gms.common.GoogleApiAvailabilityLight r4 = com.google.android.gms.common.GoogleApiAvailabilityLight.zza     // Catch:{ ClassNotFoundException -> 0x001a }
            int r3 = r4.isGooglePlayServicesAvailable(r3)     // Catch:{ ClassNotFoundException -> 0x001a }
            if (r3 != 0) goto L_0x001a
            r3 = 1
            goto L_0x001b
        L_0x001a:
            r3 = 0
        L_0x001b:
            if (r3 != 0) goto L_0x003c
            com.clevertap.android.sdk.CleverTapInstanceConfig r2 = r0.config     // Catch:{ all -> 0x006c }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x006c }
            r3.<init>()     // Catch:{ all -> 0x006c }
            java.lang.String r4 = com.clevertap.android.sdk.pushnotification.PushConstants.FCM_LOG_TAG     // Catch:{ all -> 0x006c }
            r3.append(r4)     // Catch:{ all -> 0x006c }
            java.lang.String r4 = "Google Play services is currently unavailable."
            r3.append(r4)     // Catch:{ all -> 0x006c }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x006c }
            com.clevertap.android.sdk.Logger r4 = r2.logger     // Catch:{ all -> 0x006c }
            java.lang.String r2 = r2.getDefaultSuffix(r1)     // Catch:{ all -> 0x006c }
            r4.verbose(r2, r3)     // Catch:{ all -> 0x006c }
            goto L_0x0085
        L_0x003c:
            com.google.firebase.FirebaseApp r3 = com.google.firebase.FirebaseApp.getInstance()     // Catch:{ all -> 0x006c }
            r3.checkNotDeleted()     // Catch:{ all -> 0x006c }
            com.google.firebase.FirebaseOptions r3 = r3.options     // Catch:{ all -> 0x006c }
            java.lang.String r3 = r3.gcmSenderId     // Catch:{ all -> 0x006c }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x006c }
            if (r3 == 0) goto L_0x0086
            com.clevertap.android.sdk.CleverTapInstanceConfig r2 = r0.config     // Catch:{ all -> 0x006c }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x006c }
            r3.<init>()     // Catch:{ all -> 0x006c }
            java.lang.String r4 = com.clevertap.android.sdk.pushnotification.PushConstants.FCM_LOG_TAG     // Catch:{ all -> 0x006c }
            r3.append(r4)     // Catch:{ all -> 0x006c }
            java.lang.String r4 = "The FCM sender ID is not set. Unable to register for FCM."
            r3.append(r4)     // Catch:{ all -> 0x006c }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x006c }
            com.clevertap.android.sdk.Logger r4 = r2.logger     // Catch:{ all -> 0x006c }
            java.lang.String r2 = r2.getDefaultSuffix(r1)     // Catch:{ all -> 0x006c }
            r4.verbose(r2, r3)     // Catch:{ all -> 0x006c }
            goto L_0x0085
        L_0x006c:
            r2 = move-exception
            com.clevertap.android.sdk.CleverTapInstanceConfig r0 = r0.config
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = com.clevertap.android.sdk.pushnotification.PushConstants.FCM_LOG_TAG
            java.lang.String r5 = "Unable to register with FCM."
            java.lang.String r3 = com.android.tools.r8.GeneratedOutlineSupport.outline62(r3, r4, r5)
            com.clevertap.android.sdk.Logger r4 = r0.logger
            java.lang.String r0 = r0.getDefaultSuffix(r1)
            r4.verbose(r0, r3, r2)
        L_0x0085:
            r2 = 0
        L_0x0086:
            return r2
        L_0x0087:
            r0 = 0
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.pushnotification.fcm.FcmPushProvider.isAvailable():boolean");
    }

    public boolean isSupported() {
        boolean z;
        boolean z2;
        Context context = ((FcmSdkHandlerImpl) this.handler).context;
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            z = true;
        } catch (NameNotFoundException unused) {
            z = false;
        }
        if (z) {
            return true;
        }
        try {
            context.getPackageManager().getPackageInfo("com.google.market", 0);
            z2 = true;
        } catch (NameNotFoundException unused2) {
            z2 = false;
        }
        if (z2) {
            return true;
        }
        return false;
    }

    public int minSDKSupportVersionCode() {
        return 0;
    }

    public void requestToken() {
        FcmSdkHandlerImpl fcmSdkHandlerImpl = (FcmSdkHandlerImpl) this.handler;
        if (fcmSdkHandlerImpl != null) {
            try {
                CleverTapInstanceConfig cleverTapInstanceConfig = fcmSdkHandlerImpl.config;
                cleverTapInstanceConfig.logger.verbose(cleverTapInstanceConfig.getDefaultSuffix("PushProvider"), PushConstants.FCM_LOG_TAG + "Requesting FCM token using googleservices.json");
                FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener<String>() {
                    public void onComplete(Task<String> task) {
                        String str = null;
                        if (!task.isSuccessful()) {
                            CleverTapInstanceConfig cleverTapInstanceConfig = FcmSdkHandlerImpl.this.config;
                            cleverTapInstanceConfig.logger.verbose(cleverTapInstanceConfig.getDefaultSuffix("PushProvider"), GeneratedOutlineSupport.outline62(new StringBuilder(), PushConstants.FCM_LOG_TAG, "FCM token using googleservices.json failed"), task.getException());
                            FcmSdkHandlerImpl.this.listener.onNewToken(null, PushType.FCM);
                            return;
                        }
                        if (task.getResult() != null) {
                            str = (String) task.getResult();
                        }
                        CleverTapInstanceConfig cleverTapInstanceConfig2 = FcmSdkHandlerImpl.this.config;
                        cleverTapInstanceConfig2.logger.verbose(cleverTapInstanceConfig2.getDefaultSuffix("PushProvider"), GeneratedOutlineSupport.outline63(new StringBuilder(), PushConstants.FCM_LOG_TAG, "FCM token using googleservices.json - ", str));
                        FcmSdkHandlerImpl.this.listener.onNewToken(str, PushType.FCM);
                    }
                });
            } catch (Throwable th) {
                CleverTapInstanceConfig cleverTapInstanceConfig2 = fcmSdkHandlerImpl.config;
                cleverTapInstanceConfig2.logger.verbose(cleverTapInstanceConfig2.getDefaultSuffix("PushProvider"), GeneratedOutlineSupport.outline62(new StringBuilder(), PushConstants.FCM_LOG_TAG, "Error requesting FCM token"), th);
                fcmSdkHandlerImpl.listener.onNewToken(null, PushType.FCM);
            }
        } else {
            throw null;
        }
    }

    public void setHandler(IFcmSdkHandler iFcmSdkHandler) {
        this.handler = iFcmSdkHandler;
    }
}
