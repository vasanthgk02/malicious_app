package com.appsflyer.internal;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.ViewConfiguration;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.appsflyer.AppsFlyerProperties;
import com.mpl.androidapp.utils.Constant;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONException;

public abstract class an implements Runnable {
    public static String AFInAppEventType = null;
    public static String AFKeystoreWrapper = "v2";
    public static int AFLogger$LogLevel = 0;
    public static long init = 0;
    public static char onAppOpenAttributionNative = '\u0000';
    public static int onAttributionFailureNative = 1;
    public static int onInstallConversionDataLoadedNative;
    public String AFInAppEventParameterName;
    public final Map<String, Object> AFVersionDeclaration = AFInAppEventParameterName();
    public final String AppsFlyer2dXConversionCallback = UUID.randomUUID().toString();
    public final Context getLevel;
    public final String valueOf;
    public final ac values;

    public static class c implements Runnable {
        public final cm AFKeystoreWrapper;

        public c() {
        }

        public void run() {
            HttpURLConnection values = values();
            if (values != null) {
                values.disconnect();
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:52:0x017d  */
        /* JADX WARNING: Removed duplicated region for block: B:53:0x0180  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.net.HttpURLConnection values() {
            /*
                r17 = this;
                r1 = r17
                java.lang.String r2 = ""
                com.appsflyer.internal.cm r0 = r1.AFKeystoreWrapper
                java.lang.String r3 = r0.onDeepLinkingNative
                java.util.Map r0 = r0.values()
                org.json.JSONObject r0 = com.appsflyer.internal.n.AFInAppEventType(r0)
                java.lang.String r0 = r0.toString()
                com.appsflyer.internal.cm r4 = r1.AFKeystoreWrapper
                boolean r4 = r4.AFLogger$LogLevel()
                com.appsflyer.internal.cm r5 = r1.AFKeystoreWrapper
                boolean r5 = r5.AppsFlyer2dXConversionCallback()
                com.appsflyer.internal.cm r6 = r1.AFKeystoreWrapper
                boolean r6 = r6.getLevel()
                com.appsflyer.internal.cm r7 = r1.AFKeystoreWrapper
                boolean r7 = r7.AFInAppEventType()
                byte[] r8 = r0.getBytes()
                r9 = 0
                if (r4 == 0) goto L_0x0034
                return r9
            L_0x0034:
                r4 = 0
                r10 = 1
                java.net.URL r11 = new java.net.URL     // Catch:{ all -> 0x0164 }
                r11.<init>(r3)     // Catch:{ all -> 0x0164 }
                if (r6 == 0) goto L_0x007e
                com.appsflyer.internal.ak r12 = com.appsflyer.internal.ak.AFInAppEventType()     // Catch:{ all -> 0x0164 }
                java.lang.String r13 = r11.toString()     // Catch:{ all -> 0x0164 }
                r12.AFInAppEventType(r13, r0)     // Catch:{ all -> 0x0164 }
                java.lang.String r12 = "UTF-8"
                byte[] r12 = r0.getBytes(r12)     // Catch:{ all -> 0x0164 }
                int r12 = r12.length     // Catch:{ all -> 0x0164 }
                java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x0164 }
                java.lang.String r14 = "call = "
                r13.<init>(r14)     // Catch:{ all -> 0x0164 }
                r13.append(r11)     // Catch:{ all -> 0x0164 }
                java.lang.String r14 = "; size = "
                r13.append(r14)     // Catch:{ all -> 0x0164 }
                r13.append(r12)     // Catch:{ all -> 0x0164 }
                java.lang.String r14 = " byte"
                r13.append(r14)     // Catch:{ all -> 0x0164 }
                if (r12 <= r10) goto L_0x006b
                java.lang.String r12 = "s"
                goto L_0x006c
            L_0x006b:
                r12 = r2
            L_0x006c:
                r13.append(r12)     // Catch:{ all -> 0x0164 }
                java.lang.String r12 = "; body = "
                r13.append(r12)     // Catch:{ all -> 0x0164 }
                r13.append(r0)     // Catch:{ all -> 0x0164 }
                java.lang.String r0 = r13.toString()     // Catch:{ all -> 0x0164 }
                com.appsflyer.internal.ai.AFKeystoreWrapper(r0)     // Catch:{ all -> 0x0164 }
            L_0x007e:
                java.lang.String r0 = "AppsFlyer"
                int r0 = r0.hashCode()     // Catch:{ all -> 0x0164 }
                android.net.TrafficStats.setThreadStatsTag(r0)     // Catch:{ all -> 0x0164 }
                java.net.URLConnection r0 = r11.openConnection()     // Catch:{ all -> 0x0164 }
                java.lang.Object r0 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r0)     // Catch:{ all -> 0x0164 }
                java.net.URLConnection r0 = (java.net.URLConnection) r0     // Catch:{ all -> 0x0164 }
                r12 = r0
                java.net.HttpURLConnection r12 = (java.net.HttpURLConnection) r12     // Catch:{ all -> 0x0164 }
                r0 = 30000(0x7530, float:4.2039E-41)
                r12.setReadTimeout(r0)     // Catch:{ all -> 0x0161 }
                r12.setConnectTimeout(r0)     // Catch:{ all -> 0x0161 }
                java.lang.String r0 = "POST"
                r12.setRequestMethod(r0)     // Catch:{ all -> 0x0161 }
                r12.setDoInput(r10)     // Catch:{ all -> 0x0161 }
                r12.setDoOutput(r10)     // Catch:{ all -> 0x0161 }
                java.lang.String r0 = "Content-Type"
                if (r7 == 0) goto L_0x00ae
                java.lang.String r13 = "application/octet-stream"
                goto L_0x00b0
            L_0x00ae:
                java.lang.String r13 = "application/json"
            L_0x00b0:
                r12.setRequestProperty(r0, r13)     // Catch:{ all -> 0x0161 }
                java.io.OutputStream r0 = r12.getOutputStream()     // Catch:{ all -> 0x0161 }
                if (r7 == 0) goto L_0x0134
                com.appsflyer.internal.cm r7 = r1.AFKeystoreWrapper     // Catch:{ all -> 0x0161 }
                java.lang.String r7 = r7.AFVersionDeclaration     // Catch:{ all -> 0x0161 }
                java.lang.Object[] r13 = new java.lang.Object[r10]     // Catch:{ all -> 0x012b }
                r13[r4] = r7     // Catch:{ all -> 0x012b }
                int r7 = android.view.ViewConfiguration.getKeyRepeatDelay()     // Catch:{ all -> 0x012b }
                int r7 = r7 >> 16
                int r7 = r7 + 24
                int r14 = android.view.ViewConfiguration.getScrollDefaultDelay()     // Catch:{ all -> 0x012b }
                int r14 = r14 >> 16
                int r14 = r14 + 24
                r15 = 0
                float r16 = android.graphics.PointF.length(r15, r15)     // Catch:{ all -> 0x012b }
                int r15 = (r16 > r15 ? 1 : (r16 == r15 ? 0 : -1))
                char r15 = (char) r15     // Catch:{ all -> 0x012b }
                java.lang.Object r7 = com.appsflyer.internal.e.AFInAppEventParameterName(r7, r14, r15)     // Catch:{ all -> 0x012b }
                java.lang.Class r7 = (java.lang.Class) r7     // Catch:{ all -> 0x012b }
                java.lang.String r14 = "AFInAppEventParameterName"
                java.lang.Class[] r15 = new java.lang.Class[r10]     // Catch:{ all -> 0x012b }
                java.lang.Class<java.lang.String> r16 = java.lang.String.class
                r15[r4] = r16     // Catch:{ all -> 0x012b }
                java.lang.reflect.Method r7 = r7.getMethod(r14, r15)     // Catch:{ all -> 0x012b }
                java.lang.Object r7 = r7.invoke(r9, r13)     // Catch:{ all -> 0x012b }
                java.lang.Object[] r9 = new java.lang.Object[r10]     // Catch:{ all -> 0x0122 }
                r9[r4] = r8     // Catch:{ all -> 0x0122 }
                int r8 = android.view.ViewConfiguration.getTapTimeout()     // Catch:{ all -> 0x0122 }
                int r8 = r8 >> 16
                int r8 = 24 - r8
                int r13 = android.os.Process.getGidForName(r2)     // Catch:{ all -> 0x0122 }
                int r13 = 23 - r13
                int r14 = android.view.ViewConfiguration.getPressedStateDuration()     // Catch:{ all -> 0x0122 }
                int r14 = r14 >> 16
                char r14 = (char) r14     // Catch:{ all -> 0x0122 }
                java.lang.Object r8 = com.appsflyer.internal.e.AFInAppEventParameterName(r8, r13, r14)     // Catch:{ all -> 0x0122 }
                java.lang.Class r8 = (java.lang.Class) r8     // Catch:{ all -> 0x0122 }
                java.lang.String r13 = "values"
                java.lang.Class[] r14 = new java.lang.Class[r10]     // Catch:{ all -> 0x0122 }
                java.lang.Class<byte[]> r15 = byte[].class
                r14[r4] = r15     // Catch:{ all -> 0x0122 }
                java.lang.reflect.Method r8 = r8.getDeclaredMethod(r13, r14)     // Catch:{ all -> 0x0122 }
                java.lang.Object r7 = r8.invoke(r7, r9)     // Catch:{ all -> 0x0122 }
                r8 = r7
                byte[] r8 = (byte[]) r8     // Catch:{ all -> 0x0122 }
                goto L_0x0134
            L_0x0122:
                r0 = move-exception
                java.lang.Throwable r4 = r0.getCause()     // Catch:{ all -> 0x0161 }
                if (r4 == 0) goto L_0x012a
                throw r4     // Catch:{ all -> 0x0161 }
            L_0x012a:
                throw r0     // Catch:{ all -> 0x0161 }
            L_0x012b:
                r0 = move-exception
                java.lang.Throwable r4 = r0.getCause()     // Catch:{ all -> 0x0161 }
                if (r4 == 0) goto L_0x0133
                throw r4     // Catch:{ all -> 0x0161 }
            L_0x0133:
                throw r0     // Catch:{ all -> 0x0161 }
            L_0x0134:
                r0.write(r8)     // Catch:{ all -> 0x0161 }
                r0.close()     // Catch:{ all -> 0x0161 }
                r12.connect()     // Catch:{ all -> 0x0161 }
                int r0 = r12.getResponseCode()     // Catch:{ all -> 0x0161 }
                if (r5 == 0) goto L_0x014a
                com.appsflyer.internal.ac.AFInAppEventParameterName()     // Catch:{ all -> 0x0161 }
                java.lang.String r2 = com.appsflyer.internal.ac.AFInAppEventParameterName(r12)     // Catch:{ all -> 0x0161 }
            L_0x014a:
                if (r6 == 0) goto L_0x0157
                com.appsflyer.internal.ak r5 = com.appsflyer.internal.ak.AFInAppEventType()     // Catch:{ all -> 0x0161 }
                java.lang.String r6 = r11.toString()     // Catch:{ all -> 0x0161 }
                r5.values(r6, r0, r2)     // Catch:{ all -> 0x0161 }
            L_0x0157:
                r5 = 200(0xc8, float:2.8E-43)
                if (r0 != r5) goto L_0x0173
                java.lang.String r0 = "Status 200 ok"
                com.appsflyer.AFLogger.values(r0)     // Catch:{ all -> 0x0161 }
                goto L_0x0174
            L_0x0161:
                r0 = move-exception
                r9 = r12
                goto L_0x0165
            L_0x0164:
                r0 = move-exception
            L_0x0165:
                java.lang.String r3 = java.lang.String.valueOf(r3)
                java.lang.String r4 = "Error while calling "
                java.lang.String r3 = r4.concat(r3)
                com.appsflyer.AFLogger.valueOf(r3, r0)
                r12 = r9
            L_0x0173:
                r4 = 1
            L_0x0174:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                java.lang.String r3 = "Connection "
                r0.<init>(r3)
                if (r4 == 0) goto L_0x0180
                java.lang.String r3 = "error"
                goto L_0x0182
            L_0x0180:
                java.lang.String r3 = "call succeeded"
            L_0x0182:
                r0.append(r3)
                java.lang.String r3 = ": "
                r0.append(r3)
                r0.append(r2)
                java.lang.String r0 = r0.toString()
                com.appsflyer.AFLogger.values(r0)
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.an.c.values():java.net.HttpURLConnection");
        }

        public c(cm cmVar) {
            this.AFKeystoreWrapper = cmVar;
        }
    }

    static {
        AFKeystoreWrapper();
        StringBuilder sb = new StringBuilder("https://%sonelink.%s/shortlink-sdk/");
        sb.append(AFKeystoreWrapper);
        AFInAppEventType = sb.toString();
        int i = onAttributionFailureNative + 25;
        onInstallConversionDataLoadedNative = i % 128;
        int i2 = i % 2;
    }

    public an(ac acVar, Context context, String str) {
        this.values = acVar;
        this.getLevel = context;
        this.valueOf = str;
    }

    private Map<String, Object> AFInAppEventParameterName() {
        HashMap outline87 = GeneratedOutlineSupport.outline87(Constant.BUILD_NUMBER, "6.5.4");
        outline87.put("counter", Integer.valueOf(this.values.valueOf(ac.AFInAppEventType(this.getLevel), false)));
        outline87.put("model", Build.MODEL);
        outline87.put(AFKeystoreWrapper("粞Რ䥕穷작", "Ẩ⋾", "嘢쥲亳儷", -1460880153 - TextUtils.indexOf("", ""), (char) ((ViewConfiguration.getWindowTouchSlop() >> 8) + 65054)).intern(), Build.BRAND);
        outline87.put("sdk", Integer.toString(VERSION.SDK_INT));
        try {
            outline87.put("app_version_name", this.getLevel.getPackageManager().getPackageInfo(this.getLevel.getPackageName(), 0).versionName);
            int i = onInstallConversionDataLoadedNative + 95;
            onAttributionFailureNative = i % 128;
            int i2 = i % 2;
        } catch (NameNotFoundException unused) {
        }
        outline87.put("app_id", this.getLevel.getPackageName());
        outline87.put("platformextension", new al().AFInAppEventType());
        int i3 = onAttributionFailureNative + 69;
        onInstallConversionDataLoadedNative = i3 % 128;
        int i4 = i3 % 2;
        return outline87;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00d7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void AFInAppEventType() {
        /*
            r7 = this;
            java.lang.String r0 = ""
            java.lang.String r1 = r7.values()
            java.lang.String r2 = java.lang.String.valueOf(r1)
            java.lang.String r3 = "oneLinkUrl: "
            java.lang.String r2 = r3.concat(r2)
            com.appsflyer.AFLogger.AFKeystoreWrapper(r2)
            java.net.URL r2 = new java.net.URL     // Catch:{ all -> 0x0085 }
            r2.<init>(r1)     // Catch:{ all -> 0x0085 }
            java.net.URLConnection r2 = r2.openConnection()     // Catch:{ all -> 0x0085 }
            java.lang.Object r2 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r2)     // Catch:{ all -> 0x0085 }
            java.net.URLConnection r2 = (java.net.URLConnection) r2     // Catch:{ all -> 0x0085 }
            javax.net.ssl.HttpsURLConnection r2 = (javax.net.ssl.HttpsURLConnection) r2     // Catch:{ all -> 0x0085 }
            java.lang.String r3 = "content-type"
            java.lang.String r4 = "application/json"
            r2.setRequestProperty(r3, r4)     // Catch:{ all -> 0x0085 }
            r3 = 3000(0xbb8, float:4.204E-42)
            r2.setReadTimeout(r3)     // Catch:{ all -> 0x0085 }
            r2.setConnectTimeout(r3)     // Catch:{ all -> 0x0085 }
            java.lang.String r3 = r7.valueOf     // Catch:{ all -> 0x0085 }
            r2.setRequestMethod(r3)     // Catch:{ all -> 0x0085 }
            r7.AFInAppEventParameterName(r2)     // Catch:{ all -> 0x0085 }
            int r3 = r2.getResponseCode()     // Catch:{ all -> 0x0085 }
            java.lang.String r2 = com.appsflyer.internal.ac.AFInAppEventParameterName(r2)     // Catch:{ all -> 0x0085 }
            r4 = 200(0xc8, float:2.8E-43)
            r5 = 75
            if (r3 != r4) goto L_0x004c
            r4 = 81
            goto L_0x004e
        L_0x004c:
            r4 = 75
        L_0x004e:
            if (r4 == r5) goto L_0x006c
            int r3 = onAttributionFailureNative
            int r3 = r3 + 43
            int r4 = r3 % 128
            onInstallConversionDataLoadedNative = r4
            int r3 = r3 % 2
            if (r3 == 0) goto L_0x005e
            r3 = 1
            goto L_0x005f
        L_0x005e:
            r3 = 0
        L_0x005f:
            java.lang.String r4 = "Status 200 ok"
            if (r3 != 0) goto L_0x0067
            com.appsflyer.AFLogger.values(r4)     // Catch:{ all -> 0x0083 }
            goto L_0x00ae
        L_0x0067:
            com.appsflyer.AFLogger.values(r4)     // Catch:{ all -> 0x0083 }
            r0 = 0
            throw r0     // Catch:{ all -> 0x0083 }
        L_0x006c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0083 }
            java.lang.String r4 = "Response code = "
            r0.<init>(r4)     // Catch:{ all -> 0x0083 }
            r0.append(r3)     // Catch:{ all -> 0x0083 }
            java.lang.String r3 = " content = "
            r0.append(r3)     // Catch:{ all -> 0x0083 }
            r0.append(r2)     // Catch:{ all -> 0x0083 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0083 }
            goto L_0x00ae
        L_0x0083:
            r0 = move-exception
            goto L_0x0089
        L_0x0085:
            r2 = move-exception
            r6 = r2
            r2 = r0
            r0 = r6
        L_0x0089:
            java.lang.String r3 = java.lang.String.valueOf(r1)
            java.lang.String r4 = "Error while calling "
            java.lang.String r3 = r4.concat(r3)
            com.appsflyer.AFLogger.valueOf(r3, r0)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r1)
            java.lang.String r1 = " stacktrace: "
            r3.append(r1)
            java.lang.String r0 = r0.toString()
            r3.append(r0)
            java.lang.String r0 = r3.toString()
        L_0x00ae:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            r3 = 26
            if (r1 == 0) goto L_0x00b8
            r1 = 4
            goto L_0x00ba
        L_0x00b8:
            r1 = 26
        L_0x00ba:
            if (r1 == r3) goto L_0x00d7
            int r0 = onAttributionFailureNative
            int r0 = r0 + 77
            int r1 = r0 % 128
            onInstallConversionDataLoadedNative = r1
            int r0 = r0 % 2
            java.lang.String r0 = java.lang.String.valueOf(r2)
            java.lang.String r1 = "Connection call succeeded: "
            java.lang.String r0 = r1.concat(r0)
            com.appsflyer.AFLogger.values(r0)
            r7.valueOf(r2)
            return
        L_0x00d7:
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = "Connection error: "
            java.lang.String r0 = r1.concat(r0)
            com.appsflyer.AFLogger.AppsFlyer2dXConversionCallback(r0)
            r7.valueOf()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.an.AFInAppEventType():void");
    }

    public static void AFKeystoreWrapper() {
        init = 5852232774877074978L;
        onAppOpenAttributionNative = 0;
        AFLogger$LogLevel = 0;
    }

    public abstract void AFInAppEventParameterName(HttpsURLConnection httpsURLConnection) throws JSONException, IOException;

    public final void AFKeystoreWrapper(HttpsURLConnection httpsURLConnection, String... strArr) {
        ArrayList arrayList = new ArrayList(Arrays.asList(strArr));
        arrayList.add(1, AFKeystoreWrapper);
        String AFInAppEventParameterName2 = ag.AFInAppEventParameterName((String[]) arrayList.toArray(new String[0]));
        StringBuilder sb = new StringBuilder();
        sb.append(AppsFlyerProperties.getInstance().getDevKey());
        sb.append(this.AppsFlyer2dXConversionCallback);
        sb.append(AFKeystoreWrapper);
        httpsURLConnection.setRequestProperty(AFKeystoreWrapper("ዺ力￻쬣꠻ጵ삸瑃뜂ᣫ?", "뾎숵?⒗", "嘢쥲亳儷", -1 - TextUtils.indexOf("", '0', 0), (char) (-1 - TextUtils.lastIndexOf("", '0', 0, 0))).intern(), ag.valueOf(AFInAppEventParameterName2, sb.toString()));
        int i = onInstallConversionDataLoadedNative + 41;
        onAttributionFailureNative = i % 128;
        int i2 = i % 2;
    }

    public void run() {
        int i = onAttributionFailureNative + 23;
        onInstallConversionDataLoadedNative = i % 128;
        char c2 = i % 2 != 0 ? '4' : 10;
        boolean z = false;
        AFInAppEventType();
        if (c2 != 10) {
            int i2 = 65 / 0;
        }
        int i3 = onAttributionFailureNative + 125;
        onInstallConversionDataLoadedNative = i3 % 128;
        if (i3 % 2 != 0) {
            z = true;
        }
        if (z) {
            throw null;
        }
    }

    public abstract void valueOf();

    public abstract void valueOf(String str);

    public abstract String values();

    /* JADX WARNING: type inference failed for: r9v1 */
    /* JADX WARNING: type inference failed for: r8v1 */
    /* JADX WARNING: type inference failed for: r7v1 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String AFKeystoreWrapper(java.lang.String r7, java.lang.String r8, java.lang.String r9, int r10, char r11) {
        /*
            if (r9 == 0) goto L_0x0006
            char[] r9 = r9.toCharArray()
        L_0x0006:
            char[] r9 = (char[]) r9
            if (r8 == 0) goto L_0x000e
            char[] r8 = r8.toCharArray()
        L_0x000e:
            char[] r8 = (char[]) r8
            if (r7 == 0) goto L_0x0016
            char[] r7 = r7.toCharArray()
        L_0x0016:
            char[] r7 = (char[]) r7
            java.lang.Object r0 = com.appsflyer.internal.dp.valueOf
            monitor-enter(r0)
            java.lang.Object r8 = r8.clone()     // Catch:{ all -> 0x0090 }
            char[] r8 = (char[]) r8     // Catch:{ all -> 0x0090 }
            java.lang.Object r9 = r9.clone()     // Catch:{ all -> 0x0090 }
            char[] r9 = (char[]) r9     // Catch:{ all -> 0x0090 }
            r1 = 0
            char r2 = r8[r1]     // Catch:{ all -> 0x0090 }
            r11 = r11 ^ r2
            char r11 = (char) r11     // Catch:{ all -> 0x0090 }
            r8[r1] = r11     // Catch:{ all -> 0x0090 }
            r11 = 2
            char r2 = r9[r11]     // Catch:{ all -> 0x0090 }
            char r10 = (char) r10     // Catch:{ all -> 0x0090 }
            int r2 = r2 + r10
            char r10 = (char) r2     // Catch:{ all -> 0x0090 }
            r9[r11] = r10     // Catch:{ all -> 0x0090 }
            int r10 = r7.length     // Catch:{ all -> 0x0090 }
            char[] r2 = new char[r10]     // Catch:{ all -> 0x0090 }
            com.appsflyer.internal.dp.AFInAppEventParameterName = r1     // Catch:{ all -> 0x0090 }
        L_0x003b:
            int r1 = com.appsflyer.internal.dp.AFInAppEventParameterName     // Catch:{ all -> 0x0090 }
            if (r1 >= r10) goto L_0x0089
            int r1 = com.appsflyer.internal.dp.AFInAppEventParameterName     // Catch:{ all -> 0x0090 }
            int r1 = r1 + r11
            int r1 = r1 % 4
            int r3 = com.appsflyer.internal.dp.AFInAppEventParameterName     // Catch:{ all -> 0x0090 }
            int r3 = r3 + 3
            int r3 = r3 % 4
            int r4 = com.appsflyer.internal.dp.AFInAppEventParameterName     // Catch:{ all -> 0x0090 }
            int r4 = r4 % 4
            char r4 = r8[r4]     // Catch:{ all -> 0x0090 }
            int r4 = r4 * 32718
            char r5 = r9[r1]     // Catch:{ all -> 0x0090 }
            int r4 = r4 + r5
            r5 = 65535(0xffff, float:9.1834E-41)
            int r4 = r4 % r5
            char r4 = (char) r4     // Catch:{ all -> 0x0090 }
            com.appsflyer.internal.dp.AFInAppEventType = r4     // Catch:{ all -> 0x0090 }
            char r6 = r8[r3]     // Catch:{ all -> 0x0090 }
            int r6 = r6 * 32718
            char r1 = r9[r1]     // Catch:{ all -> 0x0090 }
            int r6 = r6 + r1
            int r6 = r6 / r5
            char r1 = (char) r6     // Catch:{ all -> 0x0090 }
            r9[r3] = r1     // Catch:{ all -> 0x0090 }
            r8[r3] = r4     // Catch:{ all -> 0x0090 }
            int r1 = com.appsflyer.internal.dp.AFInAppEventParameterName     // Catch:{ all -> 0x0090 }
            int r4 = com.appsflyer.internal.dp.AFInAppEventParameterName     // Catch:{ all -> 0x0090 }
            char r4 = r7[r4]     // Catch:{ all -> 0x0090 }
            char r3 = r8[r3]     // Catch:{ all -> 0x0090 }
            r3 = r3 ^ r4
            long r3 = (long) r3     // Catch:{ all -> 0x0090 }
            long r5 = init     // Catch:{ all -> 0x0090 }
            long r3 = r3 ^ r5
            int r5 = AFLogger$LogLevel     // Catch:{ all -> 0x0090 }
            long r5 = (long) r5     // Catch:{ all -> 0x0090 }
            long r3 = r3 ^ r5
            char r5 = onAppOpenAttributionNative     // Catch:{ all -> 0x0090 }
            long r5 = (long) r5     // Catch:{ all -> 0x0090 }
            long r3 = r3 ^ r5
            int r4 = (int) r3     // Catch:{ all -> 0x0090 }
            char r3 = (char) r4     // Catch:{ all -> 0x0090 }
            r2[r1] = r3     // Catch:{ all -> 0x0090 }
            int r1 = com.appsflyer.internal.dp.AFInAppEventParameterName     // Catch:{ all -> 0x0090 }
            int r1 = r1 + 1
            com.appsflyer.internal.dp.AFInAppEventParameterName = r1     // Catch:{ all -> 0x0090 }
            goto L_0x003b
        L_0x0089:
            java.lang.String r7 = new java.lang.String     // Catch:{ all -> 0x0090 }
            r7.<init>(r2)     // Catch:{ all -> 0x0090 }
            monitor-exit(r0)     // Catch:{ all -> 0x0090 }
            return r7
        L_0x0090:
            r7 = move-exception
            monitor-exit(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.an.AFKeystoreWrapper(java.lang.String, java.lang.String, java.lang.String, int, char):java.lang.String");
    }
}
