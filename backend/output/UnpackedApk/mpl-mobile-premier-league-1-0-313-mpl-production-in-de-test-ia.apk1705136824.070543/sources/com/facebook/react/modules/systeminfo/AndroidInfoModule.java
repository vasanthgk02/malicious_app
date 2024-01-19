package com.facebook.react.modules.systeminfo;

import android.annotation.SuppressLint;
import android.app.UiModeManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import com.facebook.fbreact.specs.NativePlatformConstantsAndroidSpec;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import com.mpl.androidapp.cleanarch.core.config.domain.ConfigZkFeatures;
import java.util.HashMap;
import java.util.Map;
import org.apache.pdfbox.pdfparser.BaseParser;
import org.apache.pdfbox.pdmodel.documentinterchange.taggedpdf.PDPrintFieldAttributeObject;

@SuppressLint({"HardwareIds"})
@ReactModule(name = "PlatformConstants")
public class AndroidInfoModule extends NativePlatformConstantsAndroidSpec implements TurboModule {
    public static final String IS_TESTING = "IS_TESTING";
    public static final String NAME = "PlatformConstants";

    public AndroidInfoModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(14:7|8|9|10|11|12|(3:13|14|(1:16)(1:64))|17|18|19|36|37|38|39) */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x007e, code lost:
        if (r3 == null) goto L_0x0083;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:36:0x0080 */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0079 A[SYNTHETIC, Splitter:B:32:0x0079] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00c7 A[SYNTHETIC, Splitter:B:54:0x00c7] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00ce A[SYNTHETIC, Splitter:B:58:0x00ce] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String getServerHost() {
        /*
            r9 = this;
            com.facebook.react.bridge.ReactApplicationContext r0 = r9.getReactApplicationContext()
            android.content.Context r0 = r0.getApplicationContext()
            android.content.res.Resources r0 = r0.getResources()
            int r1 = com.facebook.react.R$integer.react_native_dev_server_port
            int r0 = r0.getInteger(r1)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            int r0 = r0.intValue()
            java.lang.Class<com.facebook.react.modules.systeminfo.AndroidInfoHelpers> r1 = com.facebook.react.modules.systeminfo.AndroidInfoHelpers.class
            monitor-enter(r1)
            java.lang.String r2 = com.facebook.react.modules.systeminfo.AndroidInfoHelpers.metroHostPropValue     // Catch:{ all -> 0x00d2 }
            if (r2 == 0) goto L_0x0026
            java.lang.String r2 = com.facebook.react.modules.systeminfo.AndroidInfoHelpers.metroHostPropValue     // Catch:{ all -> 0x00d2 }
            monitor-exit(r1)
            goto L_0x0086
        L_0x0026:
            r2 = 0
            java.lang.Runtime r3 = java.lang.Runtime.getRuntime()     // Catch:{ Exception -> 0x0068, all -> 0x0065 }
            java.lang.String r4 = "/system/bin/getprop"
            java.lang.String r5 = "metro.host"
            java.lang.String[] r4 = new java.lang.String[]{r4, r5}     // Catch:{ Exception -> 0x0068, all -> 0x0065 }
            java.lang.Process r3 = r3.exec(r4)     // Catch:{ Exception -> 0x0068, all -> 0x0065 }
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0060, all -> 0x005d }
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0060, all -> 0x005d }
            java.io.InputStream r6 = r3.getInputStream()     // Catch:{ Exception -> 0x0060, all -> 0x005d }
            java.lang.String r7 = "UTF-8"
            java.nio.charset.Charset r7 = java.nio.charset.Charset.forName(r7)     // Catch:{ Exception -> 0x0060, all -> 0x005d }
            r5.<init>(r6, r7)     // Catch:{ Exception -> 0x0060, all -> 0x005d }
            r4.<init>(r5)     // Catch:{ Exception -> 0x0060, all -> 0x005d }
            java.lang.String r2 = ""
        L_0x004d:
            java.lang.String r5 = r4.readLine()     // Catch:{ Exception -> 0x005b }
            if (r5 == 0) goto L_0x0055
            r2 = r5
            goto L_0x004d
        L_0x0055:
            com.facebook.react.modules.systeminfo.AndroidInfoHelpers.metroHostPropValue = r2     // Catch:{ Exception -> 0x005b }
            r4.close()     // Catch:{ Exception -> 0x0080 }
            goto L_0x0080
        L_0x005b:
            r2 = move-exception
            goto L_0x006c
        L_0x005d:
            r0 = move-exception
            goto L_0x00c5
        L_0x0060:
            r4 = move-exception
            r8 = r4
            r4 = r2
            r2 = r8
            goto L_0x006c
        L_0x0065:
            r0 = move-exception
            r3 = r2
            goto L_0x00c5
        L_0x0068:
            r3 = move-exception
            r4 = r2
            r2 = r3
            r3 = r4
        L_0x006c:
            java.lang.String r5 = "AndroidInfoHelpers"
            java.lang.String r6 = "Failed to query for metro.host prop:"
            com.facebook.common.logging.FLog.w(r5, r6, r2)     // Catch:{ all -> 0x00c1 }
            java.lang.String r2 = ""
            com.facebook.react.modules.systeminfo.AndroidInfoHelpers.metroHostPropValue = r2     // Catch:{ all -> 0x00c1 }
            if (r4 == 0) goto L_0x007e
            r4.close()     // Catch:{ Exception -> 0x007d }
            goto L_0x007e
        L_0x007d:
        L_0x007e:
            if (r3 == 0) goto L_0x0083
        L_0x0080:
            r3.destroy()     // Catch:{ all -> 0x00d2 }
        L_0x0083:
            java.lang.String r2 = com.facebook.react.modules.systeminfo.AndroidInfoHelpers.metroHostPropValue     // Catch:{ all -> 0x00d2 }
            monitor-exit(r1)
        L_0x0086:
            java.lang.String r1 = ""
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L_0x008f
            goto L_0x00ab
        L_0x008f:
            java.lang.String r1 = android.os.Build.FINGERPRINT
            java.lang.String r2 = "vbox"
            boolean r1 = r1.contains(r2)
            if (r1 == 0) goto L_0x009c
            java.lang.String r2 = "10.0.3.2"
            goto L_0x00ab
        L_0x009c:
            java.lang.String r1 = android.os.Build.FINGERPRINT
            java.lang.String r2 = "generic"
            boolean r1 = r1.contains(r2)
            if (r1 == 0) goto L_0x00a9
            java.lang.String r2 = "10.0.2.2"
            goto L_0x00ab
        L_0x00a9:
            java.lang.String r2 = "localhost"
        L_0x00ab:
            java.util.Locale r1 = java.util.Locale.US
            java.lang.String r3 = "%s:%d"
            r4 = 2
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r5 = 0
            r4[r5] = r2
            r2 = 1
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r4[r2] = r0
            java.lang.String r0 = java.lang.String.format(r1, r3, r4)
            return r0
        L_0x00c1:
            r0 = move-exception
            r2 = r3
            r3 = r2
            r2 = r4
        L_0x00c5:
            if (r2 == 0) goto L_0x00cc
            r2.close()     // Catch:{ Exception -> 0x00cb }
            goto L_0x00cc
        L_0x00cb:
        L_0x00cc:
            if (r3 == 0) goto L_0x00d1
            r3.destroy()     // Catch:{ all -> 0x00d2 }
        L_0x00d1:
            throw r0     // Catch:{ all -> 0x00d2 }
        L_0x00d2:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.modules.systeminfo.AndroidInfoModule.getServerHost():java.lang.String");
    }

    private Boolean isRunningScreenshotTest() {
        try {
            Class.forName("com.facebook.testing.react.screenshots.ReactAppScreenshotTestActivity");
            return Boolean.TRUE;
        } catch (ClassNotFoundException unused) {
            return Boolean.FALSE;
        }
    }

    private String uiMode() {
        int currentModeType = ((UiModeManager) getReactApplicationContext().getSystemService("uimode")).getCurrentModeType();
        if (currentModeType == 1) {
            return ConfigZkFeatures.CONFIG_TYPE_NORMAL;
        }
        if (currentModeType == 2) {
            return "desk";
        }
        if (currentModeType == 3) {
            return "car";
        }
        if (currentModeType != 4) {
            return currentModeType != 6 ? "unknown" : "watch";
        }
        return PDPrintFieldAttributeObject.ROLE_TV;
    }

    public String getAndroidID() {
        return Secure.getString(getReactApplicationContext().getContentResolver(), "android_id");
    }

    public String getName() {
        return NAME;
    }

    public Map<String, Object> getTypedExportedConstants() {
        HashMap hashMap = new HashMap();
        hashMap.put("Version", Integer.valueOf(VERSION.SDK_INT));
        hashMap.put("Release", VERSION.RELEASE);
        hashMap.put("Serial", Build.SERIAL);
        hashMap.put("Fingerprint", Build.FINGERPRINT);
        hashMap.put("Model", Build.MODEL);
        hashMap.put("isTesting", Boolean.valueOf(BaseParser.TRUE.equals(System.getProperty(IS_TESTING)) || isRunningScreenshotTest().booleanValue()));
        hashMap.put("reactNativeVersion", ReactNativeVersion.VERSION);
        hashMap.put("uiMode", uiMode());
        return hashMap;
    }

    public void invalidate() {
    }
}
