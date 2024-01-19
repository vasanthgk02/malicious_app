package com.braintreepayments.api.internal;

import org.json.JSONObject;

public class AnalyticsEvent {
    public String event;
    public int id;
    public JSONObject metadata = new JSONObject();
    public long timestamp;

    public AnalyticsEvent() {
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x008a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x00af */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AnalyticsEvent(android.content.Context r5, java.lang.String r6, java.lang.String r7, java.lang.String r8) {
        /*
            r4 = this;
            r4.<init>()
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            r4.metadata = r0
            java.lang.String r0 = "android."
            java.lang.String r8 = com.android.tools.r8.GeneratedOutlineSupport.outline50(r0, r8)
            r4.event = r8
            long r0 = java.lang.System.currentTimeMillis()
            r4.timestamp = r0
            org.json.JSONObject r8 = r4.metadata     // Catch:{ JSONException -> 0x00b4 }
            java.lang.String r0 = "sessionId"
            org.json.JSONObject r6 = r8.put(r0, r6)     // Catch:{ JSONException -> 0x00b4 }
            java.lang.String r8 = "integrationType"
            org.json.JSONObject r6 = r6.put(r8, r7)     // Catch:{ JSONException -> 0x00b4 }
            java.lang.String r7 = "deviceNetworkType"
            java.lang.String r8 = "connectivity"
            java.lang.Object r8 = r5.getSystemService(r8)     // Catch:{ JSONException -> 0x00b4 }
            android.net.ConnectivityManager r8 = (android.net.ConnectivityManager) r8     // Catch:{ JSONException -> 0x00b4 }
            android.net.NetworkInfo r8 = r8.getActiveNetworkInfo()     // Catch:{ JSONException -> 0x00b4 }
            r0 = 0
            if (r8 == 0) goto L_0x003c
            java.lang.String r8 = r8.getTypeName()     // Catch:{ JSONException -> 0x00b4 }
            goto L_0x003d
        L_0x003c:
            r8 = r0
        L_0x003d:
            if (r8 != 0) goto L_0x0041
            java.lang.String r8 = "none"
        L_0x0041:
            org.json.JSONObject r6 = r6.put(r7, r8)     // Catch:{ JSONException -> 0x00b4 }
            java.lang.String r7 = "userInterfaceOrientation"
            android.content.res.Resources r8 = r5.getResources()     // Catch:{ JSONException -> 0x00b4 }
            android.content.res.Configuration r8 = r8.getConfiguration()     // Catch:{ JSONException -> 0x00b4 }
            int r8 = r8.orientation     // Catch:{ JSONException -> 0x00b4 }
            r1 = 1
            if (r8 == r1) goto L_0x005d
            r2 = 2
            if (r8 == r2) goto L_0x005a
            java.lang.String r8 = "Unknown"
            goto L_0x005f
        L_0x005a:
            java.lang.String r8 = "Landscape"
            goto L_0x005f
        L_0x005d:
            java.lang.String r8 = "Portrait"
        L_0x005f:
            org.json.JSONObject r6 = r6.put(r7, r8)     // Catch:{ JSONException -> 0x00b4 }
            java.lang.String r7 = "merchantAppVersion"
            r8 = 0
            android.content.pm.PackageManager r2 = r5.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0075 }
            java.lang.String r3 = r5.getPackageName()     // Catch:{ NameNotFoundException -> 0x0075 }
            android.content.pm.PackageInfo r2 = r2.getPackageInfo(r3, r8)     // Catch:{ NameNotFoundException -> 0x0075 }
            java.lang.String r2 = r2.versionName     // Catch:{ NameNotFoundException -> 0x0075 }
            goto L_0x0077
        L_0x0075:
            java.lang.String r2 = "VersionUnknown"
        L_0x0077:
            org.json.JSONObject r6 = r6.put(r7, r2)     // Catch:{ JSONException -> 0x00b4 }
            java.lang.String r7 = "paypalInstalled"
            java.lang.Class<com.paypal.android.sdk.onetouch.core.PayPalOneTouchCore> r2 = com.paypal.android.sdk.onetouch.core.PayPalOneTouchCore.class
            java.lang.String r2 = r2.getName()     // Catch:{ ClassNotFoundException | NoClassDefFoundError -> 0x008a }
            java.lang.Class.forName(r2)     // Catch:{ ClassNotFoundException | NoClassDefFoundError -> 0x008a }
            boolean r8 = com.paypal.android.sdk.onetouch.core.PayPalOneTouchCore.isWalletAppInstalled(r5)     // Catch:{ ClassNotFoundException | NoClassDefFoundError -> 0x008a }
        L_0x008a:
            org.json.JSONObject r6 = r6.put(r7, r8)     // Catch:{ JSONException -> 0x00b4 }
            java.lang.String r7 = "venmoInstalled"
            boolean r5 = co.hyperverge.hypersnapsdk.c.k.isVenmoInstalled(r5)     // Catch:{ JSONException -> 0x00b4 }
            org.json.JSONObject r5 = r6.put(r7, r5)     // Catch:{ JSONException -> 0x00b4 }
            java.lang.String r6 = "dropinVersion"
            java.lang.String r7 = "com.braintreepayments.api.dropin.BuildConfig"
            java.lang.String r8 = "VERSION_NAME"
            java.lang.Class r7 = java.lang.Class.forName(r7)     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x00af }
            java.lang.reflect.Field r7 = r7.getField(r8)     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x00af }
            r7.setAccessible(r1)     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x00af }
            java.lang.Class<java.lang.Object> r8 = java.lang.Object.class
            java.lang.Object r0 = r7.get(r8)     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x00af }
        L_0x00af:
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ JSONException -> 0x00b4 }
            r5.put(r6, r0)     // Catch:{ JSONException -> 0x00b4 }
        L_0x00b4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.braintreepayments.api.internal.AnalyticsEvent.<init>(android.content.Context, java.lang.String, java.lang.String, java.lang.String):void");
    }
}
