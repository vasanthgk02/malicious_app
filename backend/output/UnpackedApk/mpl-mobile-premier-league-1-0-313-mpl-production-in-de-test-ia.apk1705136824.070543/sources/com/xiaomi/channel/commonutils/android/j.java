package com.xiaomi.channel.commonutils.android;

import android.content.Context;
import android.text.TextUtils;
import com.mpl.androidapp.utils.Constant;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.z;

public class j {

    /* renamed from: a  reason: collision with root package name */
    public static Context f4315a;

    /* renamed from: a  reason: collision with other field name */
    public static String f177a;

    public static int a() {
        try {
            Class<?> a2 = a(null, "miui.os.Build");
            if (a2.getField("IS_STABLE_VERSION").getBoolean(null)) {
                return 3;
            }
            return a2.getField("IS_DEVELOPMENT_VERSION").getBoolean(null) ? 2 : 1;
        } catch (Exception unused) {
            return 0;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static Context m330a() {
        return f4315a;
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0024 */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0024 A[SYNTHETIC, Splitter:B:13:0x0024] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Class<?> a(android.content.Context r5, java.lang.String r6) {
        /*
            if (r6 == 0) goto L_0x004a
            java.lang.String r0 = r6.trim()
            int r0 = r0.length()
            if (r0 == 0) goto L_0x004a
            r0 = 1
            r1 = 0
            if (r5 == 0) goto L_0x0012
            r2 = 1
            goto L_0x0013
        L_0x0012:
            r2 = 0
        L_0x0013:
            if (r2 == 0) goto L_0x0024
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 29
            if (r3 < r4) goto L_0x0024
            java.lang.ClassLoader r5 = r5.getClassLoader()     // Catch:{ all -> 0x0024 }
            java.lang.Class r5 = r5.loadClass(r6)     // Catch:{ all -> 0x0024 }
            return r5
        L_0x0024:
            java.lang.Class r5 = java.lang.Class.forName(r6)     // Catch:{ all -> 0x0029 }
            return r5
        L_0x0029:
            r5 = move-exception
            r6 = 2
            java.lang.Object[] r6 = new java.lang.Object[r6]
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r6[r1] = r2
            java.lang.String r1 = r5.getLocalizedMessage()
            r6[r0] = r1
            java.lang.String r0 = "loadClass fail hasContext= %s, errMsg = %s"
            java.lang.String r6 = java.lang.String.format(r0, r6)
            com.xiaomi.channel.commonutils.logger.b.a(r6)
            java.lang.ClassNotFoundException r6 = new java.lang.ClassNotFoundException
            java.lang.String r0 = "loadClass fail "
            r6.<init>(r0, r5)
            throw r6
        L_0x004a:
            java.lang.ClassNotFoundException r5 = new java.lang.ClassNotFoundException
            java.lang.String r6 = "class is empty"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.channel.commonutils.android.j.a(android.content.Context, java.lang.String):java.lang.Class");
    }

    public static void a(Context context) {
        f4315a = context.getApplicationContext();
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m331a() {
        return TextUtils.equals((String) z.a((String) "android.os.SystemProperties", (String) Constant.GET, "sys.boot_completed"), "1");
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m332a(Context context) {
        boolean z = false;
        try {
            if ((context.getApplicationInfo().flags & 2) != 0) {
                z = true;
            }
            return z;
        } catch (Exception e2) {
            b.a((Throwable) e2);
            return false;
        }
    }
}
