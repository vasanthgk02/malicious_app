package com.appsflyer.internal;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.PointF;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.FirebaseMessagingServiceListener;
import com.appsflyer.internal.an.c;
import com.netcore.android.SMTEventParamKeys;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.apache.pdfbox.pdfparser.BaseParser;

public final class cd extends cm {
    public static int onAppOpenAttribution = 0;
    public static String onAttributionFailureNative = null;
    public static char onConversionDataFail = '\u0000';
    public static char[] onResponseErrorNative = null;
    public static int onResponseNative = 1;
    public final bv onAppOpenAttributionNative;
    public final SharedPreferences onInstallConversionDataLoadedNative;

    static {
        AFVersionDeclaration();
        StringBuilder sb = new StringBuilder("https://%sregister.%s/api/v");
        sb.append(ac.values);
        onAttributionFailureNative = sb.toString();
        int i = onAppOpenAttribution + 3;
        onResponseNative = i % 128;
        if ((i % 2 == 0 ? 'D' : '$') != '$') {
            throw null;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public cd(Context context) {
        // StringBuilder sb = new StringBuilder();
        // sb.append(String.format(onAttributionFailureNative, new Object[]{AppsFlyerLib.getInstance().getHostPrefix(), ac.AFInAppEventParameterName().getHostName()}));
        // sb.append(context.getPackageName());
        super(null, sb.toString(), null, null, null, context);
        this.onInstallConversionDataLoadedNative = ac.AFInAppEventType(context);
        this.onAppOpenAttributionNative = ac.AFInAppEventParameterName().values(context);
    }

    public static boolean AFInAppEventType(SharedPreferences sharedPreferences) {
        int i = onAppOpenAttribution + 9;
        onResponseNative = i % 128;
        if (i % 2 == 0) {
        }
        return sharedPreferences.getBoolean("sentRegisterRequestToAF", false);
    }

    public static boolean AFKeystoreWrapper(Context context) {
        if (!AppsFlyerLib.getInstance().isStopped()) {
            try {
                Class.forName("com.google.firebase.messaging.FirebaseMessagingService");
                if ((z.AFKeystoreWrapper(context, new Intent("com.google.firebase.MESSAGING_EVENT", null, context, FirebaseMessagingServiceListener.class)) ? '(' : '9') == '(') {
                    int i = onAppOpenAttribution + 81;
                    onResponseNative = i % 128;
                    int i2 = i % 2;
                    return true;
                }
            } catch (ClassNotFoundException unused) {
            } catch (Throwable th) {
                AFLogger.valueOf("An error occurred while trying to verify manifest declarations: ", th);
            }
            return false;
        }
        int i3 = onResponseNative + 53;
        onAppOpenAttribution = i3 % 128;
        int i4 = i3 % 2;
        int i5 = onResponseNative + 15;
        onAppOpenAttribution = i5 % 128;
        int i6 = i5 % 2;
        return false;
    }

    public static void AFVersionDeclaration() {
        onResponseErrorNative = new char[]{'b', 'r', 'a', 'n', 'd', 'c', 'e', 'f', 'g'};
        onConversionDataFail = 3;
    }

    private void init() {
        int i = onAppOpenAttribution + 89;
        onResponseNative = i % 128;
        if (i % 2 != 0) {
            this.onAppOpenAttributionNative.AFInAppEventType((String) "sentRegisterRequestToAF", true);
        } else {
            this.onAppOpenAttributionNative.AFInAppEventType((String) "sentRegisterRequestToAF", false);
        }
        AFLogger.AFInAppEventParameterName("Successfully registered for Uninstall Tracking");
        int i2 = onAppOpenAttribution + 79;
        onResponseNative = i2 % 128;
        int i3 = i2 % 2;
    }

    private am onInstallConversionDataLoadedNative() {
        String string = this.onInstallConversionDataLoadedNative.getString("afUninstallToken", null);
        long j = this.onInstallConversionDataLoadedNative.getLong("afUninstallToken_received_time", 0);
        boolean z = false;
        boolean z2 = this.onInstallConversionDataLoadedNative.getBoolean("afUninstallToken_queued", false);
        this.onAppOpenAttributionNative.AFInAppEventType((String) "afUninstallToken_queued", false);
        if (string == null) {
            String string2 = AppsFlyerProperties.getInstance().getString("afUninstallToken");
            if (string2 != null) {
                String[] split = string2.split(",");
                string = split[split.length - 1];
            }
        }
        if (j == 0) {
            String string3 = AppsFlyerProperties.getInstance().getString("afUninstallToken");
            if (string3 != null) {
                int i = onResponseNative + 125;
                onAppOpenAttribution = i % 128;
                int i2 = i % 2;
                String[] split2 = string3.split(",");
                if (split2.length >= 2) {
                    int i3 = onAppOpenAttribution + 81;
                    onResponseNative = i3 % 128;
                    int i4 = i3 % 2;
                    try {
                        j = Long.parseLong(split2[split2.length - 2]);
                    } catch (NumberFormatException unused) {
                    }
                }
            }
        }
        if (string == null) {
            return null;
        }
        am amVar = new am(string, j, z2);
        int i5 = onAppOpenAttribution + 35;
        onResponseNative = i5 % 128;
        if (i5 % 2 != 0) {
            z = true;
        }
        if (z) {
            return amVar;
        }
        throw null;
    }

    public static /* synthetic */ void valueOf(cd cdVar) {
        int i = onResponseNative + 47;
        onAppOpenAttribution = i % 128;
        boolean z = i % 2 != 0;
        cdVar.init();
        if (z) {
            throw null;
        }
    }

    private void values(am amVar) {
        int i = onResponseNative + 115;
        onAppOpenAttribution = i % 128;
        int i2 = i % 2;
        this.onInstallConversionDataLoadedNative.edit().putString("afUninstallToken", amVar.AFInAppEventType).putLong("afUninstallToken_received_time", amVar.AFKeystoreWrapper).putBoolean("afUninstallToken_queued", amVar.values()).apply();
        int i3 = onAppOpenAttribution + 63;
        onResponseNative = i3 % 128;
        if (i3 % 2 == 0) {
            throw null;
        }
    }

    public final void AFInAppEventParameterName(String str) {
        if (str != null) {
            AFLogger.values("Firebase Refreshed Token = ".concat(str));
            am onInstallConversionDataLoadedNative2 = onInstallConversionDataLoadedNative();
            if (onInstallConversionDataLoadedNative2 == null || !str.equals(onInstallConversionDataLoadedNative2.AFInAppEventType)) {
                long currentTimeMillis = System.currentTimeMillis();
                boolean z = ac.AFInAppEventType(this.onInstallConversionDataLoadedNative) && (onInstallConversionDataLoadedNative2 == null || currentTimeMillis - onInstallConversionDataLoadedNative2.AFKeystoreWrapper > TimeUnit.SECONDS.toMillis(2));
                values(new am(str, currentTimeMillis, !z));
                if (z) {
                    AFKeystoreWrapper(str);
                }
            }
        }
    }

    public final void AFKeystoreWrapper() {
        am onInstallConversionDataLoadedNative2 = onInstallConversionDataLoadedNative();
        boolean z = true;
        if (onInstallConversionDataLoadedNative2 != null) {
            int i = onAppOpenAttribution + 83;
            onResponseNative = i % 128;
            int i2 = i % 2;
            if (onInstallConversionDataLoadedNative2.values()) {
                int i3 = onAppOpenAttribution + 15;
                onResponseNative = i3 % 128;
                if (i3 % 2 != 0) {
                    z = false;
                }
                if (!z) {
                    String str = onInstallConversionDataLoadedNative2.AFInAppEventType;
                    AFLogger.AFInAppEventParameterName("Resending Uninstall token to AF servers: ".concat(String.valueOf(str)));
                    AFKeystoreWrapper(str);
                } else {
                    String str2 = onInstallConversionDataLoadedNative2.AFInAppEventType;
                    AFLogger.AFInAppEventParameterName("Resending Uninstall token to AF servers: ".concat(String.valueOf(str2)));
                    AFKeystoreWrapper(str2);
                    throw null;
                }
            }
        }
        int i4 = onResponseNative + 79;
        onAppOpenAttribution = i4 % 128;
        if ((i4 % 2 != 0 ? 26 : 'P') == 26) {
            throw null;
        }
    }

    private void AFKeystoreWrapper(String str) {
        int i = onAppOpenAttribution + 101;
        onResponseNative = i % 128;
        int i2 = i % 2;
        Application application = this.AFKeystoreWrapper;
        final ac AFInAppEventParameterName = ac.AFInAppEventParameterName();
        if (AFInAppEventParameterName.AFKeystoreWrapper()) {
            AFLogger.values("CustomerUserId not set, Tracking is disabled", true);
            return;
        }
        String devKey = AppsFlyerProperties.getInstance().getDevKey();
        if ((devKey == null ? 8 : ')') != ')') {
            AFLogger.AppsFlyer2dXConversionCallback("[registerUninstall] AppsFlyer's SDK cannot send any event without providing DevKey.");
            return;
        }
        PackageManager packageManager = application.getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(application.getPackageName(), 0);
            this.AFInAppEventType.put("app_version_code", Integer.toString(packageInfo.versionCode));
            this.AFInAppEventType.put("app_version_name", packageInfo.versionName);
            this.AFInAppEventType.put("app_name", packageManager.getApplicationLabel(packageInfo.applicationInfo).toString());
            this.AFInAppEventType.put("installDate", ac.valueOf(new SimpleDateFormat("yyyy-MM-dd_HHmmssZ", Locale.US), packageInfo.firstInstallTime));
        } catch (Throwable th) {
            AFLogger.valueOf("Exception while collecting application version info.", th);
        }
        ac.AFInAppEventType((Context) application, this.AFInAppEventType);
        String AFInAppEventType = ac.AFInAppEventType();
        if (AFInAppEventType != null) {
            this.AFInAppEventType.put("appUserId", AFInAppEventType);
        }
        try {
            this.AFInAppEventType.put("model", Build.MODEL);
            this.AFInAppEventType.put(AFKeystoreWrapper((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 5, (byte) (95 - TextUtils.lastIndexOf("", '0')), "\u0001\u0002\u0000\u0005Ä").intern(), Build.BRAND);
        } catch (Throwable th2) {
            AFLogger.valueOf("Exception while collecting device brand and model.", th2);
        }
        if (!(!AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, false))) {
            int i3 = onResponseNative + 77;
            onAppOpenAttribution = i3 % 128;
            if (i3 % 2 != 0) {
                this.AFInAppEventType.put(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, BaseParser.TRUE);
                int i4 = 93 / 0;
            } else {
                this.AFInAppEventType.put(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, BaseParser.TRUE);
            }
        }
        g AFInAppEventType2 = ab.AFInAppEventType(application.getContentResolver());
        if ((AFInAppEventType2 != null ? '[' : 'Y') == '[') {
            this.AFInAppEventType.put("amazon_aid", AFInAppEventType2.values);
            this.AFInAppEventType.put("amazon_aid_limit", String.valueOf(AFInAppEventType2.AFKeystoreWrapper));
        }
        String string = AppsFlyerProperties.getInstance().getString(SMTEventParamKeys.SMT_AD_ID);
        if (!(string == null)) {
            int i5 = onAppOpenAttribution + 1;
            onResponseNative = i5 % 128;
            if (i5 % 2 == 0) {
                this.AFInAppEventType.put(SMTEventParamKeys.SMT_AD_ID, string);
                int i6 = 55 / 0;
            } else {
                this.AFInAppEventType.put(SMTEventParamKeys.SMT_AD_ID, string);
            }
        }
        this.AFInAppEventType.put("devkey", devKey);
        this.AFInAppEventType.put("uid", af.valueOf(new WeakReference(application)));
        this.AFInAppEventType.put("af_gcm_token", str);
        this.AFInAppEventType.put("launch_counter", Integer.toString(AFInAppEventParameterName.valueOf(this.onInstallConversionDataLoadedNative, false)));
        this.AFInAppEventType.put("sdk", Integer.toString(VERSION.SDK_INT));
        String AFInAppEventParameterName2 = AFInAppEventParameterName.AFInAppEventParameterName((Context) application);
        if ((AFInAppEventParameterName2 != null ? '?' : 27) != 27) {
            this.AFInAppEventType.put("channel", AFInAppEventParameterName2);
        }
        new Thread(new Runnable() {
            public final void run() {
                try {
                    cd cdVar = cd.this;
                    cdVar.onConversionDataSuccess = AFInAppEventParameterName.isStopped();
                    HttpURLConnection values2 = new c(cdVar).values();
                    if (values2 != null) {
                        if (values2.getResponseCode() == 200) {
                            cd.valueOf(cd.this);
                        }
                        values2.disconnect();
                    }
                } catch (Throwable th) {
                    AFLogger.valueOf(th.getMessage(), th);
                }
            }
        }).start();
    }

    /* JADX WARNING: type inference failed for: r10v1 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String AFKeystoreWrapper(int r8, byte r9, java.lang.String r10) {
        /*
            if (r10 == 0) goto L_0x0006
            char[] r10 = r10.toCharArray()
        L_0x0006:
            char[] r10 = (char[]) r10
            java.lang.Object r0 = com.appsflyer.internal.Cdo.AFVersionDeclaration
            monitor-enter(r0)
            char[] r1 = onResponseErrorNative     // Catch:{ all -> 0x00eb }
            char r2 = onConversionDataFail     // Catch:{ all -> 0x00eb }
            char[] r3 = new char[r8]     // Catch:{ all -> 0x00eb }
            int r4 = r8 % 2
            if (r4 == 0) goto L_0x001d
            int r8 = r8 + -1
            char r4 = r10[r8]     // Catch:{ all -> 0x00eb }
            int r4 = r4 - r9
            char r4 = (char) r4     // Catch:{ all -> 0x00eb }
            r3[r8] = r4     // Catch:{ all -> 0x00eb }
        L_0x001d:
            r4 = 1
            if (r8 <= r4) goto L_0x00e4
            r5 = 0
            com.appsflyer.internal.Cdo.values = r5     // Catch:{ all -> 0x00eb }
        L_0x0023:
            int r5 = com.appsflyer.internal.Cdo.values     // Catch:{ all -> 0x00eb }
            if (r5 >= r8) goto L_0x00e4
            int r5 = com.appsflyer.internal.Cdo.values     // Catch:{ all -> 0x00eb }
            char r5 = r10[r5]     // Catch:{ all -> 0x00eb }
            com.appsflyer.internal.Cdo.AFInAppEventType = r5     // Catch:{ all -> 0x00eb }
            int r5 = com.appsflyer.internal.Cdo.values     // Catch:{ all -> 0x00eb }
            int r5 = r5 + r4
            char r5 = r10[r5]     // Catch:{ all -> 0x00eb }
            com.appsflyer.internal.Cdo.valueOf = r5     // Catch:{ all -> 0x00eb }
            char r5 = com.appsflyer.internal.Cdo.AFInAppEventType     // Catch:{ all -> 0x00eb }
            char r6 = com.appsflyer.internal.Cdo.valueOf     // Catch:{ all -> 0x00eb }
            if (r5 != r6) goto L_0x004d
            int r5 = com.appsflyer.internal.Cdo.values     // Catch:{ all -> 0x00eb }
            char r6 = com.appsflyer.internal.Cdo.AFInAppEventType     // Catch:{ all -> 0x00eb }
            int r6 = r6 - r9
            char r6 = (char) r6     // Catch:{ all -> 0x00eb }
            r3[r5] = r6     // Catch:{ all -> 0x00eb }
            int r5 = com.appsflyer.internal.Cdo.values     // Catch:{ all -> 0x00eb }
            int r5 = r5 + r4
            char r6 = com.appsflyer.internal.Cdo.valueOf     // Catch:{ all -> 0x00eb }
            int r6 = r6 - r9
            char r6 = (char) r6     // Catch:{ all -> 0x00eb }
            r3[r5] = r6     // Catch:{ all -> 0x00eb }
            goto L_0x00dc
        L_0x004d:
            char r5 = com.appsflyer.internal.Cdo.AFInAppEventType     // Catch:{ all -> 0x00eb }
            int r5 = r5 / r2
            com.appsflyer.internal.Cdo.AFKeystoreWrapper = r5     // Catch:{ all -> 0x00eb }
            char r5 = com.appsflyer.internal.Cdo.AFInAppEventType     // Catch:{ all -> 0x00eb }
            int r5 = r5 % r2
            com.appsflyer.internal.Cdo.init = r5     // Catch:{ all -> 0x00eb }
            char r5 = com.appsflyer.internal.Cdo.valueOf     // Catch:{ all -> 0x00eb }
            int r5 = r5 / r2
            com.appsflyer.internal.Cdo.AFInAppEventParameterName = r5     // Catch:{ all -> 0x00eb }
            char r5 = com.appsflyer.internal.Cdo.valueOf     // Catch:{ all -> 0x00eb }
            int r5 = r5 % r2
            com.appsflyer.internal.Cdo.getLevel = r5     // Catch:{ all -> 0x00eb }
            int r5 = com.appsflyer.internal.Cdo.init     // Catch:{ all -> 0x00eb }
            int r6 = com.appsflyer.internal.Cdo.getLevel     // Catch:{ all -> 0x00eb }
            if (r5 != r6) goto L_0x0091
            int r5 = com.appsflyer.internal.Cdo.AFKeystoreWrapper     // Catch:{ all -> 0x00eb }
            int r5 = r5 + r2
            int r5 = r5 - r4
            int r5 = r5 % r2
            com.appsflyer.internal.Cdo.AFKeystoreWrapper = r5     // Catch:{ all -> 0x00eb }
            int r5 = com.appsflyer.internal.Cdo.AFInAppEventParameterName     // Catch:{ all -> 0x00eb }
            int r5 = r5 + r2
            int r5 = r5 - r4
            int r5 = r5 % r2
            com.appsflyer.internal.Cdo.AFInAppEventParameterName = r5     // Catch:{ all -> 0x00eb }
            int r5 = com.appsflyer.internal.Cdo.AFKeystoreWrapper     // Catch:{ all -> 0x00eb }
            int r5 = r5 * r2
            int r6 = com.appsflyer.internal.Cdo.init     // Catch:{ all -> 0x00eb }
            int r5 = r5 + r6
            int r6 = com.appsflyer.internal.Cdo.AFInAppEventParameterName     // Catch:{ all -> 0x00eb }
            int r6 = r6 * r2
            int r7 = com.appsflyer.internal.Cdo.getLevel     // Catch:{ all -> 0x00eb }
            int r6 = r6 + r7
            int r7 = com.appsflyer.internal.Cdo.values     // Catch:{ all -> 0x00eb }
            char r5 = r1[r5]     // Catch:{ all -> 0x00eb }
            r3[r7] = r5     // Catch:{ all -> 0x00eb }
            int r5 = com.appsflyer.internal.Cdo.values     // Catch:{ all -> 0x00eb }
            int r5 = r5 + r4
            char r6 = r1[r6]     // Catch:{ all -> 0x00eb }
            r3[r5] = r6     // Catch:{ all -> 0x00eb }
            goto L_0x00dc
        L_0x0091:
            int r5 = com.appsflyer.internal.Cdo.AFKeystoreWrapper     // Catch:{ all -> 0x00eb }
            int r6 = com.appsflyer.internal.Cdo.AFInAppEventParameterName     // Catch:{ all -> 0x00eb }
            if (r5 != r6) goto L_0x00c1
            int r5 = com.appsflyer.internal.Cdo.init     // Catch:{ all -> 0x00eb }
            int r5 = r5 + r2
            int r5 = r5 - r4
            int r5 = r5 % r2
            com.appsflyer.internal.Cdo.init = r5     // Catch:{ all -> 0x00eb }
            int r5 = com.appsflyer.internal.Cdo.getLevel     // Catch:{ all -> 0x00eb }
            int r5 = r5 + r2
            int r5 = r5 - r4
            int r5 = r5 % r2
            com.appsflyer.internal.Cdo.getLevel = r5     // Catch:{ all -> 0x00eb }
            int r5 = com.appsflyer.internal.Cdo.AFKeystoreWrapper     // Catch:{ all -> 0x00eb }
            int r5 = r5 * r2
            int r6 = com.appsflyer.internal.Cdo.init     // Catch:{ all -> 0x00eb }
            int r5 = r5 + r6
            int r6 = com.appsflyer.internal.Cdo.AFInAppEventParameterName     // Catch:{ all -> 0x00eb }
            int r6 = r6 * r2
            int r7 = com.appsflyer.internal.Cdo.getLevel     // Catch:{ all -> 0x00eb }
            int r6 = r6 + r7
            int r7 = com.appsflyer.internal.Cdo.values     // Catch:{ all -> 0x00eb }
            char r5 = r1[r5]     // Catch:{ all -> 0x00eb }
            r3[r7] = r5     // Catch:{ all -> 0x00eb }
            int r5 = com.appsflyer.internal.Cdo.values     // Catch:{ all -> 0x00eb }
            int r5 = r5 + r4
            char r6 = r1[r6]     // Catch:{ all -> 0x00eb }
            r3[r5] = r6     // Catch:{ all -> 0x00eb }
            goto L_0x00dc
        L_0x00c1:
            int r5 = com.appsflyer.internal.Cdo.AFKeystoreWrapper     // Catch:{ all -> 0x00eb }
            int r5 = r5 * r2
            int r6 = com.appsflyer.internal.Cdo.getLevel     // Catch:{ all -> 0x00eb }
            int r5 = r5 + r6
            int r6 = com.appsflyer.internal.Cdo.AFInAppEventParameterName     // Catch:{ all -> 0x00eb }
            int r6 = r6 * r2
            int r7 = com.appsflyer.internal.Cdo.init     // Catch:{ all -> 0x00eb }
            int r6 = r6 + r7
            int r7 = com.appsflyer.internal.Cdo.values     // Catch:{ all -> 0x00eb }
            char r5 = r1[r5]     // Catch:{ all -> 0x00eb }
            r3[r7] = r5     // Catch:{ all -> 0x00eb }
            int r5 = com.appsflyer.internal.Cdo.values     // Catch:{ all -> 0x00eb }
            int r5 = r5 + r4
            char r6 = r1[r6]     // Catch:{ all -> 0x00eb }
            r3[r5] = r6     // Catch:{ all -> 0x00eb }
        L_0x00dc:
            int r5 = com.appsflyer.internal.Cdo.values     // Catch:{ all -> 0x00eb }
            int r5 = r5 + 2
            com.appsflyer.internal.Cdo.values = r5     // Catch:{ all -> 0x00eb }
            goto L_0x0023
        L_0x00e4:
            java.lang.String r8 = new java.lang.String     // Catch:{ all -> 0x00eb }
            r8.<init>(r3)     // Catch:{ all -> 0x00eb }
            monitor-exit(r0)     // Catch:{ all -> 0x00eb }
            return r8
        L_0x00eb:
            r8 = move-exception
            monitor-exit(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.cd.AFKeystoreWrapper(int, byte, java.lang.String):java.lang.String");
    }
}
