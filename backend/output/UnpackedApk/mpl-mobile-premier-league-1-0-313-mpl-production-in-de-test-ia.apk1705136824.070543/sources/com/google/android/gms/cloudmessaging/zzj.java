package com.google.android.gms.cloudmessaging;

import android.os.IBinder;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@17.0.0 */
public final /* synthetic */ class zzj implements Runnable {
    public final /* synthetic */ zzm zza;
    public final /* synthetic */ IBinder zzb;

    public /* synthetic */ zzj(zzm zzm, IBinder iBinder) {
        this.zza = zzm;
        this.zzb = iBinder;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0027, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0029, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002a, code lost:
        r0.zza(0, r1.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0032, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0034, code lost:
        throw r1;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:5:0x000a, B:9:0x000f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r4 = this;
            com.google.android.gms.cloudmessaging.zzm r0 = r4.zza
            android.os.IBinder r1 = r4.zzb
            monitor-enter(r0)
            r2 = 0
            if (r1 != 0) goto L_0x000f
            java.lang.String r1 = "Null service connection"
            r0.zza(r2, r1)     // Catch:{ all -> 0x0027 }
            monitor-exit(r0)     // Catch:{ all -> 0x0027 }
            return
        L_0x000f:
            com.google.android.gms.cloudmessaging.zzn r3 = new com.google.android.gms.cloudmessaging.zzn     // Catch:{ RemoteException -> 0x0029 }
            r3.<init>(r1)     // Catch:{ RemoteException -> 0x0029 }
            r0.zzc = r3     // Catch:{ RemoteException -> 0x0029 }
            r1 = 2
            r0.zza = r1     // Catch:{ all -> 0x0027 }
            com.google.android.gms.cloudmessaging.zzs r1 = r0.zzf     // Catch:{ all -> 0x0027 }
            java.util.concurrent.ScheduledExecutorService r1 = r1.zzc     // Catch:{ all -> 0x0027 }
            com.google.android.gms.cloudmessaging.zzh r2 = new com.google.android.gms.cloudmessaging.zzh     // Catch:{ all -> 0x0027 }
            r2.<init>(r0)     // Catch:{ all -> 0x0027 }
            r1.execute(r2)     // Catch:{ all -> 0x0027 }
            monitor-exit(r0)     // Catch:{ all -> 0x0027 }
            return
        L_0x0027:
            r1 = move-exception
            goto L_0x0033
        L_0x0029:
            r1 = move-exception
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x0027 }
            r0.zza(r2, r1)     // Catch:{ all -> 0x0027 }
            monitor-exit(r0)     // Catch:{ all -> 0x0027 }
            return
        L_0x0033:
            monitor-exit(r0)     // Catch:{ all -> 0x0027 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cloudmessaging.zzj.run():void");
    }
}