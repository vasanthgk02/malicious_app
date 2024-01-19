package com.google.firebase.messaging;

import com.google.android.gms.stats.WakeLock;
import java.util.concurrent.TimeUnit;

public final class WakeLockHolder {
    public static final long WAKE_LOCK_ACQUIRE_TIMEOUT_MILLIS = TimeUnit.MINUTES.toMillis(1);
    public static final Object syncObject = new Object();
    public static WakeLock wakeLock;

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003a, code lost:
        return r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.content.ComponentName startWakefulService(android.content.Context r4, android.content.Intent r5) {
        /*
            java.lang.Object r0 = syncObject
            monitor-enter(r0)
            com.google.android.gms.stats.WakeLock r1 = wakeLock     // Catch:{ all -> 0x003b }
            r2 = 1
            if (r1 != 0) goto L_0x001b
            com.google.android.gms.stats.WakeLock r1 = new com.google.android.gms.stats.WakeLock     // Catch:{ all -> 0x003b }
            java.lang.String r3 = "wake:com.google.firebase.iid.WakeLockHolder"
            r1.<init>(r4, r2, r3)     // Catch:{ all -> 0x003b }
            wakeLock = r1     // Catch:{ all -> 0x003b }
            java.lang.Object r3 = r1.zzf     // Catch:{ all -> 0x003b }
            monitor-enter(r3)     // Catch:{ all -> 0x003b }
            r1.zzl = r2     // Catch:{ all -> 0x0018 }
            monitor-exit(r3)     // Catch:{ all -> 0x0018 }
            goto L_0x001b
        L_0x0018:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0018 }
            throw r4     // Catch:{ all -> 0x003b }
        L_0x001b:
            java.lang.String r1 = "com.google.firebase.iid.WakeLockHolder.wakefulintent"
            r3 = 0
            boolean r1 = r5.getBooleanExtra(r1, r3)     // Catch:{ all -> 0x003b }
            java.lang.String r3 = "com.google.firebase.iid.WakeLockHolder.wakefulintent"
            r5.putExtra(r3, r2)     // Catch:{ all -> 0x003b }
            android.content.ComponentName r4 = r4.startService(r5)     // Catch:{ all -> 0x003b }
            if (r4 != 0) goto L_0x0030
            r4 = 0
            monitor-exit(r0)     // Catch:{ all -> 0x003b }
            return r4
        L_0x0030:
            if (r1 != 0) goto L_0x0039
            com.google.android.gms.stats.WakeLock r5 = wakeLock     // Catch:{ all -> 0x003b }
            long r1 = WAKE_LOCK_ACQUIRE_TIMEOUT_MILLIS     // Catch:{ all -> 0x003b }
            r5.acquire(r1)     // Catch:{ all -> 0x003b }
        L_0x0039:
            monitor-exit(r0)     // Catch:{ all -> 0x003b }
            return r4
        L_0x003b:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x003b }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.WakeLockHolder.startWakefulService(android.content.Context, android.content.Intent):android.content.ComponentName");
    }
}
