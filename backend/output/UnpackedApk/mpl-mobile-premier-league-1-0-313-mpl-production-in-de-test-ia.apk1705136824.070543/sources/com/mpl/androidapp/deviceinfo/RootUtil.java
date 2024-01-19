package com.mpl.androidapp.deviceinfo;

import android.os.Build;
import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.utils.MLogger;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public final class RootUtil {
    public static final String TAG = "DeviceInfo";

    public static boolean checkRootMethod1() {
        String str = Build.TAGS;
        return str != null && str.contains("test-keys");
    }

    public static boolean checkRootMethod2() {
        String[] strArr = {"/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su", "/su/bin/su"};
        for (int i = 0; i < 10; i++) {
            if (new File(strArr[i]).exists()) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkRootMethod3() {
        boolean z = false;
        Process process = null;
        try {
            Process exec = Runtime.getRuntime().exec(new String[]{"/system/xbin/which", "su"});
            if (new BufferedReader(new InputStreamReader(exec.getInputStream())).readLine() != null) {
                z = true;
            }
            exec.destroy();
            return z;
        } catch (Throwable unused) {
            if (process != null) {
                process.destroy();
            }
            return false;
        }
    }

    public static boolean checkRootMethod4(String str) {
        String[] strArr = {"/sbin/", "/system/bin/", "/system/xbin/", "/data/local/xbin/", "/data/local/bin/", "/system/sd/xbin/", "/system/bin/failsafe/", "/data/local/"};
        for (int i = 0; i < 8; i++) {
            if (new File(GeneratedOutlineSupport.outline50(strArr[i], str)).exists()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0050, code lost:
        if (r0 == null) goto L_0x005c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean checkRootMethod5() {
        /*
            boolean r0 = isRootAvailable()
            r1 = 0
            if (r0 == 0) goto L_0x005c
            r0 = 0
            r2 = 1
            java.lang.Runtime r3 = java.lang.Runtime.getRuntime()     // Catch:{ Exception -> 0x0041 }
            java.lang.String r4 = "su"
            java.lang.String r5 = "-c"
            java.lang.String r6 = "id"
            java.lang.String[] r4 = new java.lang.String[]{r4, r5, r6}     // Catch:{ Exception -> 0x0041 }
            java.lang.Process r0 = r3.exec(r4)     // Catch:{ Exception -> 0x0041 }
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0041 }
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0041 }
            java.io.InputStream r5 = r0.getInputStream()     // Catch:{ Exception -> 0x0041 }
            r4.<init>(r5)     // Catch:{ Exception -> 0x0041 }
            r3.<init>(r4)     // Catch:{ Exception -> 0x0041 }
            java.lang.String r3 = r3.readLine()     // Catch:{ Exception -> 0x0041 }
            if (r3 == 0) goto L_0x0052
            java.lang.String r3 = r3.toLowerCase()     // Catch:{ Exception -> 0x0041 }
            java.lang.String r4 = "uid=0"
            boolean r3 = r3.contains(r4)     // Catch:{ Exception -> 0x0041 }
            if (r3 == 0) goto L_0x0052
            r0.destroy()
            return r2
        L_0x003f:
            r1 = move-exception
            goto L_0x0056
        L_0x0041:
            r3 = move-exception
            java.lang.String r4 = "DeviceInfo"
            r5 = 2
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x003f }
            java.lang.String r6 = ""
            r5[r1] = r6     // Catch:{ all -> 0x003f }
            r5[r2] = r3     // Catch:{ all -> 0x003f }
            com.mpl.androidapp.utils.MLogger.e(r4, r5)     // Catch:{ all -> 0x003f }
            if (r0 == 0) goto L_0x005c
        L_0x0052:
            r0.destroy()
            goto L_0x005c
        L_0x0056:
            if (r0 == 0) goto L_0x005b
            r0.destroy()
        L_0x005b:
            throw r1
        L_0x005c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.deviceinfo.RootUtil.checkRootMethod5():boolean");
    }

    public static boolean isDeviceRooted() {
        MLogger.d("DeviceInfo", "isDeviceRooted:checking ");
        if (checkRootMethod1() || checkRootMethod2() || checkRootMethod3() || checkRootMethod4("su") || checkRootMethod5()) {
            return true;
        }
        return false;
    }

    public static boolean isRootAvailable() {
        String str = System.getenv("PATH");
        if (str != null && !TextUtils.isEmpty(str)) {
            for (String file : str.split(":")) {
                if (new File(file, "su").exists()) {
                    return true;
                }
            }
        }
        return false;
    }
}
