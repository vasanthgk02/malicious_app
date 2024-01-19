package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.XMJobService;

public final class bc {

    /* renamed from: a  reason: collision with root package name */
    public static int f4482a = 0;

    /* renamed from: a  reason: collision with other field name */
    public static a f343a;

    /* renamed from: a  reason: collision with other field name */
    public static final String f344a = XMJobService.class.getCanonicalName();

    public interface a {
        void a();

        void a(boolean z);

        /* renamed from: a  reason: collision with other method in class */
        boolean m514a();
    }

    public static synchronized void a() {
        synchronized (bc.class) {
            if (f343a != null) {
                b.a((String) "[Alarm] stop alarm.");
                f343a.a();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005b, code lost:
        if (f344a.equals(com.xiaomi.channel.commonutils.android.j.a(r9, r6.name).getSuperclass().getCanonicalName()) != false) goto L_0x005d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x007d, code lost:
        r2 = r5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0096  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r9) {
        /*
            java.lang.String r0 = "android.permission.BIND_JOB_SERVICE"
            android.content.Context r9 = r9.getApplicationContext()
            java.lang.String r1 = r9.getPackageName()
            java.lang.String r2 = "com.xiaomi.xmsf"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0019
            com.xiaomi.push.bd r0 = new com.xiaomi.push.bd
            r0.<init>(r9)
            goto L_0x00c4
        L_0x0019:
            android.content.pm.PackageManager r1 = r9.getPackageManager()
            r2 = 0
            java.lang.String r3 = r9.getPackageName()     // Catch:{ Exception -> 0x007f }
            r4 = 4
            android.content.pm.PackageInfo r1 = r1.getPackageInfo(r3, r4)     // Catch:{ Exception -> 0x007f }
            android.content.pm.ServiceInfo[] r3 = r1.services     // Catch:{ Exception -> 0x007f }
            r4 = 1
            if (r3 == 0) goto L_0x0094
            android.content.pm.ServiceInfo[] r1 = r1.services     // Catch:{ Exception -> 0x007f }
            int r3 = r1.length     // Catch:{ Exception -> 0x007f }
            r5 = 0
        L_0x0030:
            if (r2 >= r3) goto L_0x007d
            r6 = r1[r2]     // Catch:{ Exception -> 0x007a }
            java.lang.String r7 = r6.permission     // Catch:{ Exception -> 0x007a }
            boolean r7 = r0.equals(r7)     // Catch:{ Exception -> 0x007a }
            if (r7 == 0) goto L_0x0063
            java.lang.String r7 = f344a     // Catch:{ Exception -> 0x007a }
            java.lang.String r8 = r6.name     // Catch:{ Exception -> 0x007a }
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x007a }
            if (r7 == 0) goto L_0x0047
            goto L_0x005d
        L_0x0047:
            java.lang.String r7 = r6.name     // Catch:{ Exception -> 0x005f }
            java.lang.Class r7 = com.xiaomi.channel.commonutils.android.j.a(r9, r7)     // Catch:{ Exception -> 0x005f }
            java.lang.String r8 = f344a     // Catch:{ Exception -> 0x005f }
            java.lang.Class r7 = r7.getSuperclass()     // Catch:{ Exception -> 0x005f }
            java.lang.String r7 = r7.getCanonicalName()     // Catch:{ Exception -> 0x005f }
            boolean r7 = r8.equals(r7)     // Catch:{ Exception -> 0x005f }
            if (r7 == 0) goto L_0x0060
        L_0x005d:
            r5 = 1
            goto L_0x0060
        L_0x005f:
        L_0x0060:
            if (r5 != r4) goto L_0x0063
            goto L_0x007d
        L_0x0063:
            java.lang.String r7 = f344a     // Catch:{ Exception -> 0x007a }
            java.lang.String r8 = r6.name     // Catch:{ Exception -> 0x007a }
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x007a }
            if (r7 == 0) goto L_0x0077
            java.lang.String r6 = r6.permission     // Catch:{ Exception -> 0x007a }
            boolean r6 = r0.equals(r6)     // Catch:{ Exception -> 0x007a }
            if (r6 == 0) goto L_0x0077
            r2 = 1
            goto L_0x0094
        L_0x0077:
            int r2 = r2 + 1
            goto L_0x0030
        L_0x007a:
            r1 = move-exception
            r2 = r5
            goto L_0x0080
        L_0x007d:
            r2 = r5
            goto L_0x0094
        L_0x007f:
            r1 = move-exception
        L_0x0080:
            java.lang.String r3 = "check service err : "
            java.lang.StringBuilder r3 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r3)
            java.lang.String r1 = r1.getMessage()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            com.xiaomi.channel.commonutils.logger.b.a(r1)
        L_0x0094:
            if (r2 != 0) goto L_0x00bf
            boolean r1 = com.xiaomi.channel.commonutils.android.j.a(r9)
            if (r1 != 0) goto L_0x009d
            goto L_0x00bf
        L_0x009d:
            java.lang.RuntimeException r9 = new java.lang.RuntimeException
            java.lang.String r1 = "Should export service: "
            java.lang.StringBuilder r1 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r1)
            java.lang.String r2 = f344a
            r1.append(r2)
            java.lang.String r2 = " with permission "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = " in AndroidManifest.xml file"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r9.<init>(r0)
            throw r9
        L_0x00bf:
            com.xiaomi.push.bd r0 = new com.xiaomi.push.bd
            r0.<init>(r9)
        L_0x00c4:
            f343a = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.bc.a(android.content.Context):void");
    }

    public static synchronized void a(Context context, int i) {
        synchronized (bc.class) {
            int i2 = f4482a;
            if (!"com.xiaomi.xmsf".equals(context.getPackageName())) {
                if (i == 2) {
                    f4482a = 2;
                } else {
                    f4482a = 0;
                }
            }
            if (i2 != f4482a && f4482a == 2) {
                a();
                f343a = new bf(context);
            }
        }
    }

    public static synchronized void a(boolean z) {
        synchronized (bc.class) {
            if (f343a == null) {
                b.a((String) "timer is not initialized");
                return;
            }
            b.a("[Alarm] register alarm. (" + z + ")");
            f343a.a(z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static synchronized boolean m513a() {
        synchronized (bc.class) {
            if (f343a == null) {
                return false;
            }
            boolean a2 = f343a.a();
            return a2;
        }
    }
}
