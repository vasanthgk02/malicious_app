package com.mpl.androidapp.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.gson.Gson;
import com.mpl.androidapp.model.DeviceODNLData;
import com.shield.android.Shield;
import com.shield.android.Shield.Builder;
import com.shield.android.Shield.DeviceResultStateListener;
import com.shield.android.ShieldCallback;
import com.shield.android.ShieldException;
import com.shield.android.ShieldFingerprintUseCase;
import com.shield.android.ShieldFingerprintUseCase.b;
import com.shield.android.f.d;
import com.shield.android.f.d.j;
import com.shield.android.internal.i;
import java.util.HashMap;
import org.json.JSONObject;

public class DeviceUtils {
    public static final String TAG = "DeviceUtils";
    public static DeviceODNLData sDeviceODNLData;

    public static void fetchLatestDataFromShield() {
        MLogger.d(TAG, "fetchLatestDataFromShield: ");
        JSONObject latestDeviceResult = Shield.getInstance().getLatestDeviceResult();
        if (latestDeviceResult != null) {
            MLogger.d(TAG, "fetchLatestDataFromShield: ", latestDeviceResult);
            DeviceODNLData deviceODNLData = (DeviceODNLData) new Gson().fromJson(latestDeviceResult.toString(), DeviceODNLData.class);
            sDeviceODNLData = deviceODNLData;
            MLogger.d(TAG, "fetchLatestDataFromShield: ", deviceODNLData);
            return;
        }
        MLogger.e(TAG, "fetchLatestDataFromShield: ", Shield.getInstance().f1456b.j);
    }

    public static void fetchLatestDataFromShieldAsync() {
        MLogger.d(TAG, "trying to get device data Async");
        Shield instance = Shield.getInstance();
        AnonymousClass3 r1 = new DeviceResultStateListener() {
            public void isReady() {
                JSONObject latestDeviceResult = Shield.getInstance().getLatestDeviceResult();
                if (latestDeviceResult != null) {
                    MLogger.d(DeviceUtils.TAG, "fetchLatestDataFromShield: with async", latestDeviceResult);
                    DeviceUtils.sDeviceODNLData = (DeviceODNLData) new Gson().fromJson(latestDeviceResult.toString(), DeviceODNLData.class);
                    DeviceUtils.storeShieldId();
                    return;
                }
                MLogger.d(DeviceUtils.TAG, "Device result was null with async");
                MLogger.e(DeviceUtils.TAG, "fetchLatestDataFromShield: with async", Shield.getInstance().f1456b.j);
            }
        };
        ShieldFingerprintUseCase shieldFingerprintUseCase = instance.f1456b;
        shieldFingerprintUseCase.deviceResultStateListener = r1;
        if (shieldFingerprintUseCase.i != null || shieldFingerprintUseCase.j != null) {
            r1.isReady();
        }
    }

    public static DeviceODNLData getDeviceODNLData() {
        return sDeviceODNLData;
    }

    public static String getSessionID() {
        MLogger.d(TAG, "getSessionID() called : [START]");
        String str = Shield.getInstance().f1456b.f1469f;
        MLogger.d(TAG, "getSessionID() called : [END]", str);
        return str;
    }

    public static String getShieldId() {
        DeviceODNLData deviceODNLData = sDeviceODNLData;
        String shieldId = (deviceODNLData == null || deviceODNLData.getDeviceIntelligence() == null) ? "" : sDeviceODNLData.getDeviceIntelligence().getShieldId();
        MLogger.d(TAG, "getShieldId: ", shieldId);
        return shieldId;
    }

    public static void initShield(Activity activity, boolean z, boolean z2) {
        MLogger.d(TAG, "initShield:isFingerprintingOn ", Boolean.valueOf(z), "isGeoSpoofingCheckOn: ", Boolean.valueOf(z2));
        if (z2) {
            initShieldWithSpoofingDetection(activity);
        } else if (z) {
            initShieldWithoutSpoofingDetection(activity);
        } else {
            MLogger.d(TAG, "Not Initializing shield");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x003f A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void initShieldWithSpoofingDetection(final android.app.Activity r5) {
        /*
            java.lang.String r0 = "DeviceUtils"
            r1 = 1
            java.lang.Object[] r2 = new java.lang.Object[r1]
            java.lang.String r3 = "initShield with spoofing detection: [START]"
            r4 = 0
            r2[r4] = r3
            com.mpl.androidapp.utils.MLogger.d(r0, r2)
            com.shield.android.Shield$Builder r0 = new com.shield.android.Shield$Builder     // Catch:{ Exception -> 0x004a }
            java.lang.String r2 = com.mpl.androidapp.utils.MBuildConfigUtils.getShieldSiteID()     // Catch:{ Exception -> 0x004a }
            java.lang.String r3 = com.mpl.androidapp.utils.MBuildConfigUtils.getShieldSecretKey()     // Catch:{ Exception -> 0x004a }
            r0.<init>(r5, r2, r3)     // Catch:{ Exception -> 0x004a }
            com.mpl.androidapp.utils.DeviceUtils$1 r2 = new com.mpl.androidapp.utils.DeviceUtils$1     // Catch:{ Exception -> 0x004a }
            r2.<init>(r5)     // Catch:{ Exception -> 0x004a }
            r0.m = r2     // Catch:{ Exception -> 0x004a }
            android.os.Looper r5 = android.os.Looper.myLooper()     // Catch:{ Exception -> 0x004a }
            if (r5 == 0) goto L_0x0032
            android.os.Looper r2 = android.os.Looper.getMainLooper()     // Catch:{ Exception -> 0x004a }
            if (r5 == r2) goto L_0x002e
            goto L_0x0032
        L_0x002e:
            r5 = 0
            r0.o = r5     // Catch:{ Exception -> 0x004a }
            goto L_0x0038
        L_0x0032:
            java.lang.Thread r5 = java.lang.Thread.currentThread()     // Catch:{ Exception -> 0x004a }
            r0.o = r5     // Catch:{ Exception -> 0x004a }
        L_0x0038:
            com.shield.android.Shield r5 = r0.build()     // Catch:{ Exception -> 0x004a }
            java.lang.Class<com.shield.android.Shield> r0 = com.shield.android.Shield.class
            monitor-enter(r0)     // Catch:{ Exception -> 0x004a }
            com.shield.android.Shield r2 = com.shield.android.Shield.f1454d     // Catch:{ all -> 0x0047 }
            if (r2 != 0) goto L_0x0045
            com.shield.android.Shield.f1454d = r5     // Catch:{ all -> 0x0047 }
        L_0x0045:
            monitor-exit(r0)     // Catch:{ all -> 0x0047 }
            goto L_0x005e
        L_0x0047:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0047 }
            throw r5     // Catch:{ Exception -> 0x004a }
        L_0x004a:
            r5 = move-exception
            java.lang.String r0 = "DeviceUtils"
            java.lang.Object[] r2 = new java.lang.Object[r1]
            java.lang.String r3 = "exception when Initializing shield"
            java.lang.StringBuilder r3 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r3)
            java.lang.String r5 = com.android.tools.r8.GeneratedOutlineSupport.outline39(r5, r3)
            r2[r4] = r5
            com.mpl.androidapp.utils.MLogger.d(r0, r2)
        L_0x005e:
            java.lang.String r5 = "DeviceUtils"
            java.lang.Object[] r0 = new java.lang.Object[r1]
            java.lang.String r1 = "initShield with spoofing detection: [END]"
            r0[r4] = r1
            com.mpl.androidapp.utils.MLogger.d(r5, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.utils.DeviceUtils.initShieldWithSpoofingDetection(android.app.Activity):void");
    }

    public static void initShieldWithoutSpoofingDetection(Activity activity) {
        MLogger.d(TAG, "initShield without spoofing detection: [START]");
        try {
            Shield build = new Builder(activity, MBuildConfigUtils.getShieldSiteID(), MBuildConfigUtils.getShieldSecretKey()).build();
            synchronized (Shield.class) {
                if (Shield.f1454d == null) {
                    Shield.f1454d = build;
                }
            }
        } catch (Exception e2) {
            MLogger.d(TAG, GeneratedOutlineSupport.outline39(e2, GeneratedOutlineSupport.outline73("exception when Initializing shield")));
        }
        MLogger.d(TAG, "initShield without spoofing detection: [END]");
        fetchLatestDataFromShieldAsync();
    }

    public static void logoutShield() {
        Shield.stop();
    }

    public static void sendLocationSpoofingBroadcast(Context context) {
        LocalBroadcastManager.getInstance(context).sendBroadcast(new Intent(Constant.ACTION_GEOSPOOFING_DETECTED));
    }

    public static void setCustomShieldData(final String str, final HashMap<String, String> hashMap) {
        Shield instance = Shield.getInstance();
        AnonymousClass2 r1 = new DeviceResultStateListener() {
            public void isReady() {
                MLogger.d(DeviceUtils.TAG, "isReady:setCustomShieldData ");
                Shield instance = Shield.getInstance();
                String str = str;
                HashMap hashMap = hashMap;
                AnonymousClass1 r3 = new ShieldCallback<Boolean>() {
                    public void onFailure(ShieldException shieldException) {
                        MLogger.e(DeviceUtils.TAG, "onFailure:setCustomShieldData:sendAttributes ", shieldException);
                    }

                    public void onSuccess(Boolean bool) {
                        MLogger.d(DeviceUtils.TAG, "onSuccess:setCustomShieldData:sendAttributes ", bool);
                    }
                };
                ShieldFingerprintUseCase shieldFingerprintUseCase = instance.f1456b;
                if (shieldFingerprintUseCase.f1467c) {
                    r3.onSuccess((Object) Boolean.TRUE);
                    return;
                }
                d dVar = (d) shieldFingerprintUseCase.f1468e;
                dVar.b((i) new j(new b(r3, str, hashMap), str, hashMap));
            }
        };
        ShieldFingerprintUseCase shieldFingerprintUseCase = instance.f1456b;
        shieldFingerprintUseCase.deviceResultStateListener = r1;
        if (shieldFingerprintUseCase.i != null || shieldFingerprintUseCase.j != null) {
            r1.isReady();
        }
    }

    public static void storeShieldId() {
        DeviceODNLData deviceODNLData = sDeviceODNLData;
        if (deviceODNLData != null && deviceODNLData.getDeviceIntelligence() != null) {
            MSharedPreferencesUtils.setShieldId(sDeviceODNLData.getDeviceIntelligence().getShieldId());
        }
    }
}
