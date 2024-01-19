package com.appsflyer.internal;

import android.content.ContentResolver;
import android.os.Build;
import android.provider.Settings.Secure;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import com.mpl.androidapp.utils.Constant;
import java.util.concurrent.ExecutorService;

public final class ab {
    public static String AFInAppEventParameterName;
    public static Boolean AFInAppEventType;
    public final ExecutorService AFKeystoreWrapper;
    public final bm valueOf;

    public ab() {
    }

    public static g AFInAppEventType(ContentResolver contentResolver) {
        String str;
        g gVar = null;
        if (!AFInAppEventType() || contentResolver == null) {
            return null;
        }
        if (AppsFlyerProperties.getInstance().getString("amazon_aid") == null && "Amazon".equals(Build.MANUFACTURER)) {
            int i = Secure.getInt(contentResolver, "limit_ad_tracking", 2);
            if (i == 0) {
                gVar = new g(Secure.getString(contentResolver, Constant.ADVERTISIING_ID), Boolean.FALSE);
            } else if (i != 2) {
                try {
                    str = Secure.getString(contentResolver, Constant.ADVERTISIING_ID);
                } catch (Throwable th) {
                    AFLogger.valueOf("Couldn't fetch Amazon Advertising ID (Ad-Tracking is limited!)", th);
                    str = "";
                }
                gVar = new g(str, Boolean.TRUE);
            }
        }
        return gVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003e, code lost:
        if (r8.length() == 0) goto L_0x0040;
     */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x008a A[SYNTHETIC, Splitter:B:33:0x008a] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0124  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.appsflyer.internal.g AFKeystoreWrapper(android.content.Context r12, java.util.Map<java.lang.String, java.lang.Object> r13) {
        /*
            java.lang.String r0 = "advertiserIdEnabled"
            java.lang.String r1 = "advertiserId"
            boolean r2 = AFInAppEventType()
            r3 = 0
            if (r2 != 0) goto L_0x000c
            return r3
        L_0x000c:
            java.lang.String r2 = "Trying to fetch GAID.."
            com.appsflyer.AFLogger.values(r2)
            r2 = 0
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r5 = -1
            com.google.android.gms.common.GoogleApiAvailability r6 = com.google.android.gms.common.GoogleApiAvailability.zab     // Catch:{ all -> 0x0020 }
            int r7 = com.google.android.gms.common.GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE     // Catch:{ all -> 0x0020 }
            int r5 = r6.isGooglePlayServicesAvailable(r12, r7)     // Catch:{ all -> 0x0020 }
        L_0x0020:
            r6 = 1
            java.lang.String r7 = "com.google.android.gms.ads.identifier.AdvertisingIdClient"
            java.lang.Class.forName(r7)     // Catch:{ all -> 0x005d }
            com.google.android.gms.ads.identifier.AdvertisingIdClient$Info r7 = com.google.android.gms.ads.identifier.AdvertisingIdClient.getAdvertisingIdInfo(r12)     // Catch:{ all -> 0x005d }
            if (r7 == 0) goto L_0x0050
            java.lang.String r8 = r7.getId()     // Catch:{ all -> 0x005d }
            boolean r7 = r7.isLimitAdTrackingEnabled()     // Catch:{ all -> 0x004c }
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r7)     // Catch:{ all -> 0x004c }
            if (r8 == 0) goto L_0x0040
            int r2 = r8.length()     // Catch:{ all -> 0x0048 }
            if (r2 != 0) goto L_0x0045
        L_0x0040:
            java.lang.String r2 = "emptyOrNull |"
            r4.append(r2)     // Catch:{ all -> 0x0048 }
        L_0x0045:
            r2 = 1
            goto L_0x00f0
        L_0x0048:
            r2 = move-exception
            r7 = r3
            r3 = 1
            goto L_0x0062
        L_0x004c:
            r7 = move-exception
            r2 = r7
            r7 = r3
            goto L_0x0061
        L_0x0050:
            java.lang.String r7 = "gpsAdInfo-null |"
            r4.append(r7)     // Catch:{ all -> 0x005d }
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException     // Catch:{ all -> 0x005d }
            java.lang.String r8 = "GpsAdIndo is null"
            r7.<init>(r8)     // Catch:{ all -> 0x005d }
            throw r7     // Catch:{ all -> 0x005d }
        L_0x005d:
            r7 = move-exception
            r8 = r3
            r2 = r7
            r7 = r8
        L_0x0061:
            r3 = 0
        L_0x0062:
            java.lang.String r9 = r2.getMessage()
            com.appsflyer.AFLogger.valueOf(r9, r2)
            java.lang.Class r2 = r2.getClass()
            java.lang.String r2 = r2.getSimpleName()
            r4.append(r2)
            java.lang.String r2 = " |"
            r4.append(r2)
            java.lang.String r9 = "WARNING: Google Play Services is missing."
            com.appsflyer.AFLogger.values(r9)
            com.appsflyer.AppsFlyerProperties r9 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r10 = "enableGpsFallback"
            boolean r9 = r9.getBoolean(r10, r6)
            if (r9 == 0) goto L_0x00ee
            com.appsflyer.internal.aa$e r7 = com.appsflyer.internal.aa.AFKeystoreWrapper(r12)     // Catch:{ all -> 0x00a6 }
            java.lang.String r8 = r7.AFInAppEventParameterName     // Catch:{ all -> 0x00a6 }
            boolean r7 = r7.AFKeystoreWrapper()     // Catch:{ all -> 0x00a6 }
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)     // Catch:{ all -> 0x00a6 }
            if (r8 == 0) goto L_0x00a0
            int r9 = r8.length()     // Catch:{ all -> 0x00a6 }
            if (r9 != 0) goto L_0x00ee
        L_0x00a0:
            java.lang.String r9 = "emptyOrNull (bypass) |"
            r4.append(r9)     // Catch:{ all -> 0x00a6 }
            goto L_0x00ee
        L_0x00a6:
            r7 = move-exception
            java.lang.String r8 = r7.getMessage()
            com.appsflyer.AFLogger.valueOf(r8, r7)
            java.lang.Class r8 = r7.getClass()
            java.lang.String r8 = r8.getSimpleName()
            r4.append(r8)
            r4.append(r2)
            com.appsflyer.AppsFlyerProperties r2 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r8 = r2.getString(r1)
            com.appsflyer.AppsFlyerProperties r2 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r2 = r2.getString(r0)
            boolean r2 = java.lang.Boolean.parseBoolean(r2)
            r2 = r2 ^ r6
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            java.lang.String r9 = r7.getLocalizedMessage()
            if (r9 == 0) goto L_0x00e3
            java.lang.String r7 = r7.getLocalizedMessage()
            com.appsflyer.AFLogger.values(r7)
            goto L_0x00ea
        L_0x00e3:
            java.lang.String r7 = r7.toString()
            com.appsflyer.AFLogger.values(r7)
        L_0x00ea:
            r11 = r3
            r3 = r2
            r2 = r11
            goto L_0x00f0
        L_0x00ee:
            r2 = r3
            r3 = r7
        L_0x00f0:
            java.lang.Class r12 = r12.getClass()
            java.lang.String r12 = r12.getName()
            java.lang.String r7 = "android.app.ReceiverRestrictedContext"
            boolean r12 = r12.equals(r7)
            if (r12 == 0) goto L_0x011e
            com.appsflyer.AppsFlyerProperties r12 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r8 = r12.getString(r1)
            com.appsflyer.AppsFlyerProperties r12 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r12 = r12.getString(r0)
            boolean r12 = java.lang.Boolean.parseBoolean(r12)
            r12 = r12 ^ r6
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r12)
            java.lang.String r12 = "context = android.app.ReceiverRestrictedContext |"
            r4.append(r12)
        L_0x011e:
            int r12 = r4.length()
            if (r12 <= 0) goto L_0x013d
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r12.append(r5)
            java.lang.String r5 = ": "
            r12.append(r5)
            r12.append(r4)
            java.lang.String r12 = r12.toString()
            java.lang.String r4 = "gaidError"
            r13.put(r4, r12)
        L_0x013d:
            if (r8 == 0) goto L_0x0170
            if (r3 == 0) goto L_0x0170
            r13.put(r1, r8)
            boolean r12 = r3.booleanValue()
            r12 = r12 ^ r6
            java.lang.String r12 = java.lang.String.valueOf(r12)
            r13.put(r0, r12)
            com.appsflyer.AppsFlyerProperties r12 = com.appsflyer.AppsFlyerProperties.getInstance()
            r12.set(r1, r8)
            com.appsflyer.AppsFlyerProperties r12 = com.appsflyer.AppsFlyerProperties.getInstance()
            boolean r1 = r3.booleanValue()
            r1 = r1 ^ r6
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r12.set(r0, r1)
            java.lang.String r12 = java.lang.String.valueOf(r2)
            java.lang.String r0 = "isGaidWithGps"
            r13.put(r0, r12)
        L_0x0170:
            com.appsflyer.internal.g r12 = new com.appsflyer.internal.g
            r12.<init>(r8, r3)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.ab.AFKeystoreWrapper(android.content.Context, java.util.Map):com.appsflyer.internal.g");
    }

    public ab(bm bmVar, ExecutorService executorService) {
        this.valueOf = bmVar;
        this.AFKeystoreWrapper = executorService;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0060 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.appsflyer.internal.g AFInAppEventType(android.content.Context r6) {
        /*
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r1 = AFInAppEventParameterName
            r2 = 1
            if (r1 == 0) goto L_0x000b
            r1 = 1
            goto L_0x000c
        L_0x000b:
            r1 = 0
        L_0x000c:
            r3 = 0
            if (r1 == 0) goto L_0x0013
            java.lang.String r6 = AFInAppEventParameterName
        L_0x0011:
            r0 = r3
            goto L_0x0052
        L_0x0013:
            java.lang.Boolean r4 = AFInAppEventType
            if (r4 == 0) goto L_0x001d
            boolean r4 = r4.booleanValue()
            if (r4 != 0) goto L_0x0029
        L_0x001d:
            java.lang.Boolean r4 = AFInAppEventType
            if (r4 != 0) goto L_0x0050
            java.lang.String r4 = "collectOAID"
            boolean r2 = r0.getBoolean(r4, r2)
            if (r2 == 0) goto L_0x0050
        L_0x0029:
            com.appsflyer.oaid.OaidClient r2 = new com.appsflyer.oaid.OaidClient     // Catch:{ all -> 0x0049 }
            r2.<init>(r6)     // Catch:{ all -> 0x0049 }
            boolean r6 = r0.isEnableLog()     // Catch:{ all -> 0x0049 }
            r2.setLogging(r6)     // Catch:{ all -> 0x0049 }
            com.appsflyer.oaid.OaidClient$Info r6 = r2.fetch()     // Catch:{ all -> 0x0049 }
            if (r6 == 0) goto L_0x0050
            java.lang.String r0 = r6.getId()     // Catch:{ all -> 0x0049 }
            java.lang.Boolean r6 = r6.getLat()     // Catch:{ all -> 0x0047 }
            r5 = r0
            r0 = r6
            r6 = r5
            goto L_0x0052
        L_0x0047:
            r6 = r0
            goto L_0x004a
        L_0x0049:
            r6 = r3
        L_0x004a:
            java.lang.String r0 = "No OAID library"
            com.appsflyer.AFLogger.AFInAppEventParameterName(r0)
            goto L_0x0011
        L_0x0050:
            r6 = r3
            r0 = r6
        L_0x0052:
            if (r6 == 0) goto L_0x0060
            com.appsflyer.internal.g r2 = new com.appsflyer.internal.g
            r2.<init>(r6, r0)
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r1)
            r2.AFInAppEventParameterName = r6
            return r2
        L_0x0060:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.ab.AFInAppEventType(android.content.Context):com.appsflyer.internal.g");
    }

    public static boolean AFInAppEventType() {
        Boolean bool = AFInAppEventType;
        return bool == null || bool.booleanValue();
    }
}
