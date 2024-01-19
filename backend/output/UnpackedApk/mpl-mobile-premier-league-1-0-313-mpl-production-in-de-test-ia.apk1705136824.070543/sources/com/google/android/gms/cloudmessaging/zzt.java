package com.google.android.gms.cloudmessaging;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@17.0.0 */
public final class zzt {
    public final Context zza;
    public int zzb;
    public int zzc = 0;

    public zzt(Context context) {
        this.zza = context;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0076, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized int zzb() {
        /*
            r5 = this;
            monitor-enter(r5)
            int r0 = r5.zzc     // Catch:{ all -> 0x0077 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r5)
            return r0
        L_0x0007:
            android.content.Context r0 = r5.zza     // Catch:{ all -> 0x0077 }
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch:{ all -> 0x0077 }
            android.content.Context r1 = r5.zza     // Catch:{ all -> 0x0077 }
            com.google.android.gms.common.wrappers.PackageManagerWrapper r1 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r1)     // Catch:{ all -> 0x0077 }
            java.lang.String r2 = "com.google.android.c2dm.permission.SEND"
            java.lang.String r3 = "com.google.android.gms"
            android.content.Context r1 = r1.zza     // Catch:{ all -> 0x0077 }
            android.content.pm.PackageManager r1 = r1.getPackageManager()     // Catch:{ all -> 0x0077 }
            int r1 = r1.checkPermission(r2, r3)     // Catch:{ all -> 0x0077 }
            r2 = -1
            r3 = 0
            if (r1 != r2) goto L_0x0027
            monitor-exit(r5)
            return r3
        L_0x0027:
            boolean r1 = com.google.android.gms.common.util.PlatformVersion.isAtLeastO()     // Catch:{ all -> 0x0077 }
            r2 = 1
            if (r1 != 0) goto L_0x004b
            android.content.Intent r1 = new android.content.Intent     // Catch:{ all -> 0x0077 }
            java.lang.String r4 = "com.google.android.c2dm.intent.REGISTER"
            r1.<init>(r4)     // Catch:{ all -> 0x0077 }
            java.lang.String r4 = "com.google.android.gms"
            r1.setPackage(r4)     // Catch:{ all -> 0x0077 }
            java.util.List r1 = r0.queryIntentServices(r1, r3)     // Catch:{ all -> 0x0077 }
            if (r1 == 0) goto L_0x004b
            int r1 = r1.size()     // Catch:{ all -> 0x0077 }
            if (r1 > 0) goto L_0x0047
            goto L_0x004b
        L_0x0047:
            r5.zzc = r2     // Catch:{ all -> 0x0077 }
            monitor-exit(r5)
            return r2
        L_0x004b:
            android.content.Intent r1 = new android.content.Intent     // Catch:{ all -> 0x0077 }
            java.lang.String r4 = "com.google.iid.TOKEN_REQUEST"
            r1.<init>(r4)     // Catch:{ all -> 0x0077 }
            java.lang.String r4 = "com.google.android.gms"
            r1.setPackage(r4)     // Catch:{ all -> 0x0077 }
            java.util.List r0 = r0.queryBroadcastReceivers(r1, r3)     // Catch:{ all -> 0x0077 }
            r1 = 2
            if (r0 == 0) goto L_0x0069
            int r0 = r0.size()     // Catch:{ all -> 0x0077 }
            if (r0 > 0) goto L_0x0065
            goto L_0x0069
        L_0x0065:
            r5.zzc = r1     // Catch:{ all -> 0x0077 }
            monitor-exit(r5)
            return r1
        L_0x0069:
            boolean r0 = com.google.android.gms.common.util.PlatformVersion.isAtLeastO()     // Catch:{ all -> 0x0077 }
            if (r0 == 0) goto L_0x0073
            r5.zzc = r1     // Catch:{ all -> 0x0077 }
            r2 = 2
            goto L_0x0075
        L_0x0073:
            r5.zzc = r2     // Catch:{ all -> 0x0077 }
        L_0x0075:
            monitor-exit(r5)
            return r2
        L_0x0077:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cloudmessaging.zzt.zzb():int");
    }
}
