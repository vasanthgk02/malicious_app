package com.appsflyer.internal;

import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.internal.components.network.http.exceptions.ParsingException;
import com.netcore.android.SMTEventParamKeys;
import com.netcore.android.preference.SMTPreferenceConstants;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.apache.fontbox.cmap.CMap;
import org.eclipse.paho.android.service.MqttServiceConstants;
import org.json.JSONException;

public final class ak {
    public static char AppsFlyer2dXConversionCallback = '긓';
    public static char init = '';
    public static char onAppOpenAttributionNative = '㲅';
    public static int onDeepLinkingNative = 0;
    public static int onInstallConversionDataLoadedNative = 1;
    public static char onInstallConversionFailureNative = '➪';
    public static ak values;
    public int AFInAppEventParameterName = 0;
    public List<String> AFInAppEventType = new ArrayList();
    public boolean AFKeystoreWrapper = true;
    public boolean AFLogger$LogLevel = (true ^ AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.DPM, false));
    public boolean AFVersionDeclaration = false;
    public String getLevel = "-1";
    public Map<String, Object> valueOf;

    @Deprecated
    public static ak AFInAppEventType() {
        int i = onInstallConversionDataLoadedNative + 19;
        onDeepLinkingNative = i % 128;
        int i2 = i % 2;
        if (values == null) {
            values = new ak();
        }
        ak akVar = values;
        int i3 = onDeepLinkingNative + 13;
        onInstallConversionDataLoadedNative = i3 % 128;
        if (i3 % 2 != 0) {
            return akVar;
        }
        try {
            throw null;
        }
    }

    private synchronized Map<String, Object> AFLogger$LogLevel() {
        Map<String, Object> map;
        int i = onDeepLinkingNative + 47;
        onInstallConversionDataLoadedNative = i % 128;
        int i2 = i % 2;
        this.valueOf.put("data", this.AFInAppEventType);
        init();
        map = this.valueOf;
        int i3 = onDeepLinkingNative + 115;
        onInstallConversionDataLoadedNative = i3 % 128;
        if ((i3 % 2 == 0 ? 'Z' : '0') != '0') {
            throw null;
        }
        return map;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0040, code lost:
        if ((!r4.AFVersionDeclaration) != false) goto L_0x0042;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean AppsFlyer2dXConversionCallback() {
        /*
            r4 = this;
            int r0 = onInstallConversionDataLoadedNative
            int r0 = r0 + 61
            int r1 = r0 % 128
            onDeepLinkingNative = r1
            int r0 = r0 % 2
            r1 = 14
            if (r0 == 0) goto L_0x0011
            r0 = 16
            goto L_0x0013
        L_0x0011:
            r0 = 14
        L_0x0013:
            if (r0 != r1) goto L_0x004e
            boolean r0 = r4.AFLogger$LogLevel
            r1 = 92
            if (r0 == 0) goto L_0x001e
            r0 = 92
            goto L_0x0020
        L_0x001e:
            r0 = 83
        L_0x0020:
            r2 = 0
            if (r0 == r1) goto L_0x0024
            goto L_0x0042
        L_0x0024:
            boolean r0 = r4.AFKeystoreWrapper
            r1 = 1
            if (r0 != 0) goto L_0x002b
            r0 = 1
            goto L_0x002c
        L_0x002b:
            r0 = 0
        L_0x002c:
            if (r0 == r1) goto L_0x002f
            goto L_0x004d
        L_0x002f:
            int r0 = onDeepLinkingNative
            int r0 = r0 + 85
            int r3 = r0 % 128
            onInstallConversionDataLoadedNative = r3
            int r0 = r0 % 2
            boolean r0 = r4.AFVersionDeclaration
            if (r0 == 0) goto L_0x003f
            r0 = 0
            goto L_0x0040
        L_0x003f:
            r0 = 1
        L_0x0040:
            if (r0 == 0) goto L_0x004d
        L_0x0042:
            int r0 = onInstallConversionDataLoadedNative
            int r0 = r0 + 43
            int r1 = r0 % 128
            onDeepLinkingNative = r1
            int r0 = r0 % 2
            return r2
        L_0x004d:
            return r1
        L_0x004e:
            r0 = 0
            throw r0     // Catch:{ all -> 0x0050 }
        L_0x0050:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.ak.AppsFlyer2dXConversionCallback():boolean");
    }

    private synchronized void init() {
        this.AFInAppEventType = new ArrayList();
        this.AFInAppEventParameterName = 0;
        int i = onDeepLinkingNative + 73;
        onInstallConversionDataLoadedNative = i % 128;
        if (i % 2 == 0) {
            int i2 = 72 / 0;
        }
    }

    private synchronized void valueOf(String str, String str2, String str3, String str4) {
        int i = onDeepLinkingNative + 55;
        onInstallConversionDataLoadedNative = i % 128;
        if (i % 2 != 0) {
            if ((str != null ? 16 : 'C') == 16) {
                try {
                    if (str.length() > 0) {
                        int i2 = onInstallConversionDataLoadedNative + 85;
                        onDeepLinkingNative = i2 % 128;
                        if (i2 % 2 == 0) {
                            this.valueOf.put("app_id", str);
                        } else {
                            this.valueOf.put("app_id", str);
                            throw null;
                        }
                    }
                } catch (Throwable unused) {
                    return;
                }
            }
            boolean z = false;
            if ((str2 != null ? 7 : '[') == 7) {
                if (str2.length() > 0) {
                    int i3 = onDeepLinkingNative + 69;
                    onInstallConversionDataLoadedNative = i3 % 128;
                    int i4 = i3 % 2;
                    this.valueOf.put("app_version", str2);
                }
            }
            if (str3 != null && str3.length() > 0) {
                this.valueOf.put("channel", str3);
            }
            if ((str4 != null ? 'G' : 'A') == 'G') {
                if (str4.length() > 0) {
                    z = true;
                }
                if (z) {
                    int i5 = onDeepLinkingNative + 113;
                    onInstallConversionDataLoadedNative = i5 % 128;
                    int i6 = i5 % 2;
                    this.valueOf.put("preInstall", str4);
                }
            }
        } else {
            throw null;
        }
    }

    public final synchronized void AFInAppEventParameterName() {
        AFInAppEventParameterName((String) "r_debugging_off", new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ", Locale.ENGLISH).format(Long.valueOf(System.currentTimeMillis())), new String[0]);
        this.AFVersionDeclaration = false;
        this.AFKeystoreWrapper = false;
        int i = onDeepLinkingNative + 43;
        onInstallConversionDataLoadedNative = i % 128;
        if (!(i % 2 != 0)) {
            int i2 = 2 / 0;
        }
    }

    public final synchronized void AFKeystoreWrapper() {
        this.AFVersionDeclaration = true;
        AFInAppEventParameterName((String) "r_debugging_on", new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ", Locale.ENGLISH).format(Long.valueOf(System.currentTimeMillis())), new String[0]);
        int i = onInstallConversionDataLoadedNative + 27;
        onDeepLinkingNative = i % 128;
        int i2 = i % 2;
    }

    public final boolean AFVersionDeclaration() {
        int i = onDeepLinkingNative + 21;
        onInstallConversionDataLoadedNative = i % 128;
        int i2 = i % 2;
        boolean z = this.AFVersionDeclaration;
        int i3 = onInstallConversionDataLoadedNative + 49;
        onDeepLinkingNative = i3 % 128;
        if ((i3 % 2 != 0 ? 3 : '7') == '7') {
            return z;
        }
        try {
            throw null;
        }
    }

    public final void getLevel() {
        int i = onDeepLinkingNative + 29;
        onInstallConversionDataLoadedNative = i % 128;
        this.AFLogger$LogLevel = (i % 2 == 0 ? 'O' : 'W') != 'W';
        int i2 = onDeepLinkingNative + 45;
        onInstallConversionDataLoadedNative = i2 % 128;
        int i3 = i2 % 2;
    }

    public final synchronized void values(String str) {
        int i = onInstallConversionDataLoadedNative + 97;
        onDeepLinkingNative = i % 128;
        int i2 = i % 2;
        this.getLevel = str;
        int i3 = onInstallConversionDataLoadedNative + 35;
        onDeepLinkingNative = i3 % 128;
        if (!(i3 % 2 == 0)) {
            throw null;
        }
    }

    public final synchronized void values() {
        int i = onDeepLinkingNative + 23;
        onInstallConversionDataLoadedNative = i % 128;
        if (!(i % 2 == 0)) {
            this.valueOf = null;
            values = null;
        } else {
            this.valueOf = null;
            values = null;
            throw null;
        }
    }

    public final void AFKeystoreWrapper(String str, String... strArr) {
        int i = onInstallConversionDataLoadedNative + 77;
        onDeepLinkingNative = i % 128;
        char c2 = i % 2 != 0 ? 'b' : '%';
        AFInAppEventParameterName((String) "public_api_call", str, strArr);
        if (c2 == '%') {
            int i2 = onInstallConversionDataLoadedNative + 89;
            onDeepLinkingNative = i2 % 128;
            int i3 = i2 % 2;
            return;
        }
        throw null;
    }

    private synchronized void AFInAppEventParameterName(String str, String str2, String str3) {
        try {
            boolean z = false;
            this.valueOf.put(AFInAppEventParameterName((String) "쉝鏭碻壨﮻", 5 - View.combineMeasuredStates(0, 0)).intern(), Build.BRAND);
            this.valueOf.put("model", Build.MODEL);
            this.valueOf.put("platform", "Android");
            this.valueOf.put("platform_version", VERSION.RELEASE);
            if (str != null) {
                z = true;
            }
            if (z) {
                if (str.length() > 0) {
                    this.valueOf.put(SMTEventParamKeys.SMT_AD_ID, str);
                }
            }
            if ((str2 != null ? ')' : '@') == ')') {
                int i = onDeepLinkingNative + 115;
                onInstallConversionDataLoadedNative = i % 128;
                int i2 = i % 2;
                if ((str2.length() > 0 ? 'F' : '7') == 'F') {
                    this.valueOf.put("imei", str2);
                }
            }
            if (str3 != null && str3.length() > 0) {
                int i3 = onInstallConversionDataLoadedNative + 17;
                onDeepLinkingNative = i3 % 128;
                int i4 = i3 % 2;
                this.valueOf.put("android_id", str3);
            }
        } catch (Throwable unused) {
        }
    }

    public final void AFInAppEventType(String str, PackageManager packageManager) {
        int i = onDeepLinkingNative + 117;
        onInstallConversionDataLoadedNative = i % 128;
        int i2 = i % 2;
        try {
            AFInAppEventParameterName(str, packageManager);
            bl<String> AFKeystoreWrapper2 = ac.AFInAppEventParameterName().values().valueOf().AFKeystoreWrapper(AFLogger$LogLevel());
            if (!AFKeystoreWrapper2.valueOf.getAndSet(true)) {
                AFKeystoreWrapper2.AFKeystoreWrapper.submit(new Runnable(null) {
                    public /* synthetic */ bi AFInAppEventParameterName;

                    {
                        this.AFInAppEventParameterName = r2;
                    }

                    public final void run() {
                        try {
                            br<String> AFInAppEventType2 = bl.this.values.AFInAppEventType(bl.this.AFInAppEventType);
                            if (this.AFInAppEventParameterName != null) {
                                try {
                                    br brVar = new br(bl.this.AFInAppEventParameterName.values((String) AFInAppEventType2.valueOf), AFInAppEventType2.values, AFInAppEventType2.AFKeystoreWrapper, AFInAppEventType2.AFInAppEventParameterName, AFInAppEventType2.AFInAppEventType);
                                    this.AFInAppEventParameterName.values(brVar);
                                } catch (JSONException e2) {
                                    this.AFInAppEventParameterName.values((Throwable) new ParsingException(e2.getMessage(), e2, AFInAppEventType2));
                                }
                            }
                        } catch (IOException e3) {
                            bi biVar = this.AFInAppEventParameterName;
                            if (biVar != null) {
                                biVar.values((Throwable) e3);
                            }
                        }
                    }
                });
                int i3 = onInstallConversionDataLoadedNative + 125;
                onDeepLinkingNative = i3 % 128;
                int i4 = i3 % 2;
                return;
            }
            throw new IllegalStateException("Http call is already executed");
        } catch (Throwable th) {
            AFLogger.values(th);
        }
    }

    public final void values(String str, int i, String str2) {
        int i2 = onInstallConversionDataLoadedNative + 59;
        onDeepLinkingNative = i2 % 128;
        if (!(i2 % 2 == 0)) {
            String[] strArr = new String[3];
            strArr[1] = String.valueOf(i);
            strArr[1] = str2;
            AFInAppEventParameterName((String) "server_response", str, strArr);
            return;
        }
        AFInAppEventParameterName((String) "server_response", str, String.valueOf(i), str2);
    }

    public static String[] values(String str, StackTraceElement[] stackTraceElementArr) {
        int i = onDeepLinkingNative + 123;
        onInstallConversionDataLoadedNative = i % 128;
        int i2 = i % 2;
        int i3 = 1;
        if ((stackTraceElementArr == null ? 29 : '1') != 29) {
            String[] strArr = new String[(stackTraceElementArr.length + 1)];
            strArr[0] = str;
            while (true) {
                if ((i3 < stackTraceElementArr.length ? 9 : '<') == '<') {
                    break;
                }
                strArr[i3] = stackTraceElementArr[i3].toString();
                i3++;
            }
            int i4 = onInstallConversionDataLoadedNative + 31;
            onDeepLinkingNative = i4 % 128;
            if ((i4 % 2 != 0 ? '/' : '=') == '=') {
                return strArr;
            }
            int i5 = 40 / 0;
            return strArr;
        }
        return new String[]{str};
    }

    public final void valueOf(Throwable th) {
        StackTraceElement[] stackTraceElementArr;
        int i = onDeepLinkingNative + 117;
        onInstallConversionDataLoadedNative = i % 128;
        int i2 = i % 2;
        Throwable cause = th.getCause();
        String simpleName = th.getClass().getSimpleName();
        String message = (cause == null ? '.' : '?') != '?' ? th.getMessage() : cause.getMessage();
        if (!(cause != null)) {
            int i3 = onDeepLinkingNative + 87;
            onInstallConversionDataLoadedNative = i3 % 128;
            int i4 = i3 % 2;
            stackTraceElementArr = th.getStackTrace();
        } else {
            stackTraceElementArr = cause.getStackTrace();
            int i5 = onDeepLinkingNative + 51;
            onInstallConversionDataLoadedNative = i5 % 128;
            int i6 = i5 % 2;
        }
        AFInAppEventParameterName((String) MqttServiceConstants.TRACE_EXCEPTION, simpleName, values(message, stackTraceElementArr));
    }

    private synchronized void AFInAppEventType(String str, String str2, String str3, String str4) {
        try {
            this.valueOf.put(SMTPreferenceConstants.SMT_SDK_VERSION, str);
            if ((str2 != null ? '5' : '7') != '7') {
                if (str2.length() > 0) {
                    this.valueOf.put("devkey", str2);
                }
            }
            if (str3 != null) {
                int i = onInstallConversionDataLoadedNative + 17;
                onDeepLinkingNative = i % 128;
                if (i % 2 == 0) {
                    if ((str3.length() > 0 ? '+' : 'S') != 'S') {
                        int i2 = onInstallConversionDataLoadedNative + 97;
                        onDeepLinkingNative = i2 % 128;
                        if (!(i2 % 2 != 0)) {
                            this.valueOf.put("originalAppsFlyerId", str3);
                        } else {
                            this.valueOf.put("originalAppsFlyerId", str3);
                            int i3 = 56 / 0;
                        }
                    }
                } else {
                    str3.length();
                    throw null;
                }
            }
            if ((str4 != null ? 16 : '\\') == 16) {
                if (str4.length() > 0) {
                    int i4 = onInstallConversionDataLoadedNative + 75;
                    onDeepLinkingNative = i4 % 128;
                    if (i4 % 2 != 0) {
                        this.valueOf.put("uid", str4);
                        int i5 = 63 / 0;
                    } else {
                        this.valueOf.put("uid", str4);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public final void AFInAppEventParameterName(String str, String str2) {
        int i = onDeepLinkingNative + 123;
        onInstallConversionDataLoadedNative = i % 128;
        int i2 = i % 2;
        AFInAppEventParameterName((String) null, str, str2);
        int i3 = onInstallConversionDataLoadedNative + 23;
        onDeepLinkingNative = i3 % 128;
        int i4 = i3 % 2;
    }

    private synchronized void AFInAppEventParameterName(String str, String str2, String... strArr) {
        String str3;
        int i = onDeepLinkingNative + 85;
        onInstallConversionDataLoadedNative = i % 128;
        int i2 = i % 2;
        if ((AppsFlyer2dXConversionCallback() ? 'R' : 13) == 13 || this.AFInAppEventParameterName >= 98304) {
            int i3 = onInstallConversionDataLoadedNative + 103;
            onDeepLinkingNative = i3 % 128;
            int i4 = i3 % 2;
            return;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            String join = TextUtils.join(", ", strArr);
            if (str != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(currentTimeMillis);
                sb.append(CMap.SPACE);
                sb.append(Thread.currentThread().getId());
                sb.append(" _/AppsFlyer_6.5.4 [");
                sb.append(str);
                sb.append("] ");
                sb.append(str2);
                sb.append(CMap.SPACE);
                sb.append(join);
                str3 = sb.toString();
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(currentTimeMillis);
                sb2.append(CMap.SPACE);
                sb2.append(Thread.currentThread().getId());
                sb2.append(CMap.SPACE);
                sb2.append(str2);
                sb2.append("/AppsFlyer_6.5.4 ");
                sb2.append(join);
                str3 = sb2.toString();
            }
            this.AFInAppEventType.add(str3);
            this.AFInAppEventParameterName += str3.length() << 1;
            int i5 = onInstallConversionDataLoadedNative + 31;
            onDeepLinkingNative = i5 % 128;
            if ((i5 % 2 != 0 ? 17 : 'Y') != 'Y') {
                throw null;
            }
        } catch (Throwable unused) {
        }
    }

    public final synchronized void valueOf() {
        int i = onInstallConversionDataLoadedNative + 91;
        onDeepLinkingNative = i % 128;
        if ((i % 2 != 0 ? '(' : 20) != 20) {
            this.AFKeystoreWrapper = false;
        } else {
            this.AFKeystoreWrapper = false;
        }
        init();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002e, code lost:
        if (r4 != null) goto L_0x0030;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0090 */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00aa  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void AFInAppEventParameterName(java.lang.String r9, android.content.pm.PackageManager r10) {
        /*
            r8 = this;
            monitor-enter(r8)
            int r0 = onInstallConversionDataLoadedNative     // Catch:{ all -> 0x00b8 }
            int r0 = r0 + 67
            int r1 = r0 % 128
            onDeepLinkingNative = r1     // Catch:{ all -> 0x00b8 }
            int r0 = r0 % 2
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0011
            r0 = 1
            goto L_0x0012
        L_0x0011:
            r0 = 0
        L_0x0012:
            if (r0 == r1) goto L_0x0021
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x00b8 }
            java.lang.String r3 = "remote_debug_static_data"
            java.lang.String r4 = r0.getString(r3)     // Catch:{ all -> 0x00b8 }
            if (r4 == 0) goto L_0x003c
            goto L_0x0030
        L_0x0021:
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x00b8 }
            java.lang.String r3 = "remote_debug_static_data"
            java.lang.String r4 = r0.getString(r3)     // Catch:{ all -> 0x00b8 }
            r5 = 94
            int r5 = r5 / r2
            if (r4 == 0) goto L_0x003c
        L_0x0030:
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ all -> 0x00ab }
            r9.<init>(r4)     // Catch:{ all -> 0x00ab }
            java.util.Map r9 = com.appsflyer.internal.n.valueOf(r9)     // Catch:{ all -> 0x00ab }
            r8.valueOf = r9     // Catch:{ all -> 0x00ab }
            goto L_0x00ab
        L_0x003c:
            java.util.HashMap r4 = new java.util.HashMap     // Catch:{ all -> 0x00b8 }
            r4.<init>()     // Catch:{ all -> 0x00b8 }
            r8.valueOf = r4     // Catch:{ all -> 0x00b8 }
            com.appsflyer.internal.ac r4 = com.appsflyer.internal.ac.AFInAppEventParameterName()     // Catch:{ all -> 0x00b8 }
            java.lang.String r5 = "advertiserId"
            java.lang.String r5 = r0.getString(r5)     // Catch:{ all -> 0x00b8 }
            java.lang.String r6 = r4.AppsFlyer2dXConversionCallback     // Catch:{ all -> 0x00b8 }
            java.lang.String r4 = r4.init     // Catch:{ all -> 0x00b8 }
            r8.AFInAppEventParameterName(r5, r6, r4)     // Catch:{ all -> 0x00b8 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b8 }
            java.lang.String r5 = "6.5.4."
            r4.<init>(r5)     // Catch:{ all -> 0x00b8 }
            java.lang.String r5 = com.appsflyer.internal.ac.valueOf     // Catch:{ all -> 0x00b8 }
            r4.append(r5)     // Catch:{ all -> 0x00b8 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x00b8 }
            java.lang.String r5 = r0.getDevKey()     // Catch:{ all -> 0x00b8 }
            java.lang.String r6 = "KSAppsFlyerId"
            java.lang.String r6 = r0.getString(r6)     // Catch:{ all -> 0x00b8 }
            java.lang.String r7 = "uid"
            java.lang.String r7 = r0.getString(r7)     // Catch:{ all -> 0x00b8 }
            r8.AFInAppEventType(r4, r5, r6, r7)     // Catch:{ all -> 0x00b8 }
            android.content.pm.PackageInfo r10 = r10.getPackageInfo(r9, r2)     // Catch:{ all -> 0x0090 }
            int r10 = r10.versionCode     // Catch:{ all -> 0x0090 }
            java.lang.String r4 = "channel"
            java.lang.String r4 = r0.getString(r4)     // Catch:{ all -> 0x0090 }
            java.lang.String r5 = "preInstallName"
            java.lang.String r5 = r0.getString(r5)     // Catch:{ all -> 0x0090 }
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch:{ all -> 0x0090 }
            r8.valueOf(r9, r10, r4, r5)     // Catch:{ all -> 0x0090 }
        L_0x0090:
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ all -> 0x00b8 }
            java.util.Map<java.lang.String, java.lang.Object> r10 = r8.valueOf     // Catch:{ all -> 0x00b8 }
            r9.<init>(r10)     // Catch:{ all -> 0x00b8 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x00b8 }
            r0.set(r3, r9)     // Catch:{ all -> 0x00b8 }
            int r9 = onDeepLinkingNative     // Catch:{ all -> 0x00b8 }
            int r9 = r9 + 97
            int r10 = r9 % 128
            onInstallConversionDataLoadedNative = r10     // Catch:{ all -> 0x00b8 }
            int r9 = r9 % 2
            if (r9 != 0) goto L_0x00ab
            r2 = 1
        L_0x00ab:
            java.util.Map<java.lang.String, java.lang.Object> r9 = r8.valueOf     // Catch:{ all -> 0x00b8 }
            java.lang.String r10 = "launch_counter"
            java.lang.String r0 = r8.getLevel     // Catch:{ all -> 0x00b8 }
            r9.put(r10, r0)     // Catch:{ all -> 0x00b8 }
            monitor-exit(r8)
            return
        L_0x00b6:
            r9 = move-exception
            throw r9     // Catch:{ all -> 0x00b8 }
        L_0x00b8:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.ak.AFInAppEventParameterName(java.lang.String, android.content.pm.PackageManager):void");
    }

    public final void AFInAppEventType(String str, String str2) {
        int i = onDeepLinkingNative + 105;
        onInstallConversionDataLoadedNative = i % 128;
        int i2 = i % 2;
        AFInAppEventParameterName((String) "server_request", str, str2);
        int i3 = onDeepLinkingNative + 43;
        onInstallConversionDataLoadedNative = i3 % 128;
        if ((i3 % 2 == 0 ? 18 : 'Y') != 'Y') {
            throw null;
        }
    }

    /* JADX WARNING: type inference failed for: r12v1 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String AFInAppEventParameterName(java.lang.String r12, int r13) {
        /*
            if (r12 == 0) goto L_0x0006
            char[] r12 = r12.toCharArray()
        L_0x0006:
            char[] r12 = (char[]) r12
            java.lang.Object r0 = com.appsflyer.internal.dt.valueOf
            monitor-enter(r0)
            int r1 = r12.length     // Catch:{ all -> 0x0082 }
            char[] r1 = new char[r1]     // Catch:{ all -> 0x0082 }
            r2 = 0
            com.appsflyer.internal.dt.AFInAppEventType = r2     // Catch:{ all -> 0x0082 }
            r3 = 2
            char[] r4 = new char[r3]     // Catch:{ all -> 0x0082 }
        L_0x0014:
            int r5 = com.appsflyer.internal.dt.AFInAppEventType     // Catch:{ all -> 0x0082 }
            int r6 = r12.length     // Catch:{ all -> 0x0082 }
            if (r5 >= r6) goto L_0x007b
            int r5 = com.appsflyer.internal.dt.AFInAppEventType     // Catch:{ all -> 0x0082 }
            char r5 = r12[r5]     // Catch:{ all -> 0x0082 }
            r4[r2] = r5     // Catch:{ all -> 0x0082 }
            int r5 = com.appsflyer.internal.dt.AFInAppEventType     // Catch:{ all -> 0x0082 }
            r6 = 1
            int r5 = r5 + r6
            char r5 = r12[r5]     // Catch:{ all -> 0x0082 }
            r4[r6] = r5     // Catch:{ all -> 0x0082 }
            r5 = 58224(0xe370, float:8.1589E-41)
            r7 = 0
        L_0x002b:
            r8 = 16
            if (r7 >= r8) goto L_0x0068
            char r8 = r4[r6]     // Catch:{ all -> 0x0082 }
            char r9 = r4[r2]     // Catch:{ all -> 0x0082 }
            int r9 = r9 + r5
            char r10 = r4[r2]     // Catch:{ all -> 0x0082 }
            int r10 = r10 << 4
            char r11 = onInstallConversionFailureNative     // Catch:{ all -> 0x0082 }
            int r10 = r10 + r11
            r9 = r9 ^ r10
            char r10 = r4[r2]     // Catch:{ all -> 0x0082 }
            int r10 = r10 >>> 5
            char r11 = onAppOpenAttributionNative     // Catch:{ all -> 0x0082 }
            int r10 = r10 + r11
            r9 = r9 ^ r10
            int r8 = r8 - r9
            char r8 = (char) r8     // Catch:{ all -> 0x0082 }
            r4[r6] = r8     // Catch:{ all -> 0x0082 }
            char r8 = r4[r2]     // Catch:{ all -> 0x0082 }
            char r9 = r4[r6]     // Catch:{ all -> 0x0082 }
            int r9 = r9 + r5
            char r10 = r4[r6]     // Catch:{ all -> 0x0082 }
            int r10 = r10 << 4
            char r11 = init     // Catch:{ all -> 0x0082 }
            int r10 = r10 + r11
            r9 = r9 ^ r10
            char r10 = r4[r6]     // Catch:{ all -> 0x0082 }
            int r10 = r10 >>> 5
            char r11 = AppsFlyer2dXConversionCallback     // Catch:{ all -> 0x0082 }
            int r10 = r10 + r11
            r9 = r9 ^ r10
            int r8 = r8 - r9
            char r8 = (char) r8     // Catch:{ all -> 0x0082 }
            r4[r2] = r8     // Catch:{ all -> 0x0082 }
            r8 = 40503(0x9e37, float:5.6757E-41)
            int r5 = r5 - r8
            int r7 = r7 + 1
            goto L_0x002b
        L_0x0068:
            int r5 = com.appsflyer.internal.dt.AFInAppEventType     // Catch:{ all -> 0x0082 }
            char r7 = r4[r2]     // Catch:{ all -> 0x0082 }
            r1[r5] = r7     // Catch:{ all -> 0x0082 }
            int r5 = com.appsflyer.internal.dt.AFInAppEventType     // Catch:{ all -> 0x0082 }
            int r5 = r5 + r6
            char r6 = r4[r6]     // Catch:{ all -> 0x0082 }
            r1[r5] = r6     // Catch:{ all -> 0x0082 }
            int r5 = com.appsflyer.internal.dt.AFInAppEventType     // Catch:{ all -> 0x0082 }
            int r5 = r5 + r3
            com.appsflyer.internal.dt.AFInAppEventType = r5     // Catch:{ all -> 0x0082 }
            goto L_0x0014
        L_0x007b:
            java.lang.String r12 = new java.lang.String     // Catch:{ all -> 0x0082 }
            r12.<init>(r1, r2, r13)     // Catch:{ all -> 0x0082 }
            monitor-exit(r0)     // Catch:{ all -> 0x0082 }
            return r12
        L_0x0082:
            r12 = move-exception
            monitor-exit(r0)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.ak.AFInAppEventParameterName(java.lang.String, int):java.lang.String");
    }
}
