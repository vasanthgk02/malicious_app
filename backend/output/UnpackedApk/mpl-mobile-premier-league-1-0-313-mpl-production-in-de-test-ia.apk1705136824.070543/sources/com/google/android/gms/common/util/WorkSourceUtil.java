package com.google.android.gms.common.util;

import android.content.Context;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import java.lang.reflect.Method;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public class WorkSourceUtil {
    public static final Method zzb;
    public static final Method zzc;

    /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|5|6|7|8|10|11|12|13|(2:14|15)|17|(3:19|20|21)|23|(3:25|26|27)|29|(4:31|32|33|35)(1:37)) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0034 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0041 */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    static {
        /*
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            java.lang.String r1 = "add"
            android.os.Process.myUid()
            r2 = 0
            r3 = 1
            r4 = 0
            java.lang.Class[] r5 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x0017 }
            java.lang.Class r6 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x0017 }
            r5[r4] = r6     // Catch:{ Exception -> 0x0017 }
            java.lang.Class<android.os.WorkSource> r6 = android.os.WorkSource.class
            java.lang.reflect.Method r5 = r6.getMethod(r1, r5)     // Catch:{ Exception -> 0x0017 }
            goto L_0x0018
        L_0x0017:
            r5 = r2
        L_0x0018:
            zzb = r5
            r5 = 2
            java.lang.Class[] r6 = new java.lang.Class[r5]     // Catch:{ Exception -> 0x0029 }
            java.lang.Class r7 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x0029 }
            r6[r4] = r7     // Catch:{ Exception -> 0x0029 }
            r6[r3] = r0     // Catch:{ Exception -> 0x0029 }
            java.lang.Class<android.os.WorkSource> r7 = android.os.WorkSource.class
            java.lang.reflect.Method r2 = r7.getMethod(r1, r6)     // Catch:{ Exception -> 0x0029 }
        L_0x0029:
            zzc = r2
            java.lang.Class<android.os.WorkSource> r1 = android.os.WorkSource.class
            java.lang.String r2 = "size"
            java.lang.Class[] r6 = new java.lang.Class[r4]     // Catch:{ Exception -> 0x0034 }
            r1.getMethod(r2, r6)     // Catch:{ Exception -> 0x0034 }
        L_0x0034:
            java.lang.Class[] r1 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x0041 }
            java.lang.Class r2 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x0041 }
            r1[r4] = r2     // Catch:{ Exception -> 0x0041 }
            java.lang.Class<android.os.WorkSource> r2 = android.os.WorkSource.class
            java.lang.String r6 = "get"
            r2.getMethod(r6, r1)     // Catch:{ Exception -> 0x0041 }
        L_0x0041:
            java.lang.Class[] r1 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x004f }
            java.lang.Class r2 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x004f }
            r1[r4] = r2     // Catch:{ Exception -> 0x004f }
            java.lang.Class<android.os.WorkSource> r2 = android.os.WorkSource.class
            java.lang.String r6 = "getName"
            r2.getMethod(r6, r1)     // Catch:{ Exception -> 0x004f }
            goto L_0x0050
        L_0x004f:
        L_0x0050:
            boolean r1 = com.google.android.gms.common.util.PlatformVersion.isAtLeastP()
            if (r1 == 0) goto L_0x0061
            java.lang.Class<android.os.WorkSource> r1 = android.os.WorkSource.class
            java.lang.String r2 = "createWorkChain"
            java.lang.Class[] r6 = new java.lang.Class[r4]     // Catch:{ Exception -> 0x0060 }
            r1.getMethod(r2, r6)     // Catch:{ Exception -> 0x0060 }
            goto L_0x0061
        L_0x0060:
        L_0x0061:
            boolean r1 = com.google.android.gms.common.util.PlatformVersion.isAtLeastP()
            if (r1 == 0) goto L_0x007c
            java.lang.String r1 = "android.os.WorkSource$WorkChain"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ Exception -> 0x007b }
            java.lang.Class[] r2 = new java.lang.Class[r5]     // Catch:{ Exception -> 0x007b }
            java.lang.Class r5 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x007b }
            r2[r4] = r5     // Catch:{ Exception -> 0x007b }
            r2[r3] = r0     // Catch:{ Exception -> 0x007b }
            java.lang.String r0 = "addNode"
            r1.getMethod(r0, r2)     // Catch:{ Exception -> 0x007b }
            goto L_0x007c
        L_0x007b:
        L_0x007c:
            boolean r0 = com.google.android.gms.common.util.PlatformVersion.isAtLeastP()
            if (r0 == 0) goto L_0x008f
            java.lang.Class<android.os.WorkSource> r0 = android.os.WorkSource.class
            java.lang.String r1 = "isEmpty"
            java.lang.Class[] r2 = new java.lang.Class[r4]     // Catch:{ Exception -> 0x008f }
            java.lang.reflect.Method r0 = r0.getMethod(r1, r2)     // Catch:{ Exception -> 0x008f }
            r0.setAccessible(r3)     // Catch:{ Exception -> 0x008f }
        L_0x008f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.util.WorkSourceUtil.<clinit>():void");
    }

    @KeepForSdk
    public static boolean hasWorkSourcePermission(Context context) {
        if (context.getPackageManager() == null) {
            return false;
        }
        PackageManagerWrapper packageManager = Wrappers.packageManager(context);
        if (packageManager.zza.getPackageManager().checkPermission("android.permission.UPDATE_DEVICE_STATS", context.getPackageName()) == 0) {
            return true;
        }
        return false;
    }
}
