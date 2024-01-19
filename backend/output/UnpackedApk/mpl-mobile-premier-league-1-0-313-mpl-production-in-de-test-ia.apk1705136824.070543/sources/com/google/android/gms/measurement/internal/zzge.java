package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.BlockingQueue;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzge extends Thread {
    public final /* synthetic */ zzgf zza;
    public final Object zzb;
    public final BlockingQueue zzc;
    public boolean zzd = false;

    public zzge(zzgf zzgf, String str, BlockingQueue blockingQueue) {
        this.zza = zzgf;
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(blockingQueue);
        this.zzb = new Object();
        this.zzc = blockingQueue;
        setName(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x006f, code lost:
        zzb();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0072, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r6 = this;
            r0 = 1
            r1 = 0
        L_0x0002:
            if (r1 != 0) goto L_0x0012
            com.google.android.gms.measurement.internal.zzgf r2 = r6.zza     // Catch:{ InterruptedException -> 0x000d }
            java.util.concurrent.Semaphore r2 = r2.zzi     // Catch:{ InterruptedException -> 0x000d }
            r2.acquire()     // Catch:{ InterruptedException -> 0x000d }
            r1 = 1
            goto L_0x0002
        L_0x000d:
            r2 = move-exception
            r6.zzc(r2)
            goto L_0x0002
        L_0x0012:
            int r1 = android.os.Process.myTid()     // Catch:{ all -> 0x007b }
            int r1 = android.os.Process.getThreadPriority(r1)     // Catch:{ all -> 0x007b }
        L_0x001a:
            java.util.concurrent.BlockingQueue r2 = r6.zzc     // Catch:{ all -> 0x007b }
            java.lang.Object r2 = r2.poll()     // Catch:{ all -> 0x007b }
            com.google.android.gms.measurement.internal.zzgd r2 = (com.google.android.gms.measurement.internal.zzgd) r2     // Catch:{ all -> 0x007b }
            if (r2 == 0) goto L_0x0033
            boolean r3 = r2.zza     // Catch:{ all -> 0x007b }
            if (r0 == r3) goto L_0x002b
            r3 = 10
            goto L_0x002c
        L_0x002b:
            r3 = r1
        L_0x002c:
            android.os.Process.setThreadPriority(r3)     // Catch:{ all -> 0x007b }
            r2.run()     // Catch:{ all -> 0x007b }
            goto L_0x001a
        L_0x0033:
            java.lang.Object r2 = r6.zzb     // Catch:{ all -> 0x007b }
            monitor-enter(r2)     // Catch:{ all -> 0x007b }
            java.util.concurrent.BlockingQueue r3 = r6.zzc     // Catch:{ all -> 0x0078 }
            java.lang.Object r3 = r3.peek()     // Catch:{ all -> 0x0078 }
            if (r3 != 0) goto L_0x004e
            com.google.android.gms.measurement.internal.zzgf r3 = r6.zza     // Catch:{ all -> 0x0078 }
            boolean r3 = r3.zzj     // Catch:{ all -> 0x0078 }
            java.lang.Object r3 = r6.zzb     // Catch:{ InterruptedException -> 0x004a }
            r4 = 30000(0x7530, double:1.4822E-319)
            r3.wait(r4)     // Catch:{ InterruptedException -> 0x004a }
            goto L_0x004e
        L_0x004a:
            r3 = move-exception
            r6.zzc(r3)     // Catch:{ all -> 0x0078 }
        L_0x004e:
            monitor-exit(r2)     // Catch:{ all -> 0x0078 }
            com.google.android.gms.measurement.internal.zzgf r2 = r6.zza     // Catch:{ all -> 0x007b }
            java.lang.Object r2 = r2.zzh     // Catch:{ all -> 0x007b }
            monitor-enter(r2)     // Catch:{ all -> 0x007b }
            java.util.concurrent.BlockingQueue r3 = r6.zzc     // Catch:{ all -> 0x0075 }
            java.lang.Object r3 = r3.peek()     // Catch:{ all -> 0x0075 }
            if (r3 != 0) goto L_0x0073
            com.google.android.gms.measurement.internal.zzgf r0 = r6.zza     // Catch:{ all -> 0x0075 }
            com.google.android.gms.measurement.internal.zzgi r0 = r0.zzs     // Catch:{ all -> 0x0075 }
            com.google.android.gms.measurement.internal.zzaf r0 = r0.zzk     // Catch:{ all -> 0x0075 }
            com.google.android.gms.measurement.internal.zzek r1 = com.google.android.gms.measurement.internal.zzel.zzaf     // Catch:{ all -> 0x0075 }
            r3 = 0
            boolean r0 = r0.zzs(r3, r1)     // Catch:{ all -> 0x0075 }
            if (r0 == 0) goto L_0x006e
            r6.zzb()     // Catch:{ all -> 0x0075 }
        L_0x006e:
            monitor-exit(r2)     // Catch:{ all -> 0x0075 }
            r6.zzb()
            return
        L_0x0073:
            monitor-exit(r2)     // Catch:{ all -> 0x0075 }
            goto L_0x001a
        L_0x0075:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0075 }
            throw r0     // Catch:{ all -> 0x007b }
        L_0x0078:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0078 }
            throw r0     // Catch:{ all -> 0x007b }
        L_0x007b:
            r0 = move-exception
            r6.zzb()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzge.run():void");
    }

    public final void zzb() {
        synchronized (this.zza.zzh) {
            if (!this.zzd) {
                this.zza.zzi.release();
                this.zza.zzh.notifyAll();
                zzgf zzgf = this.zza;
                if (this == zzgf.zzb) {
                    zzgf.zzb = null;
                } else if (this == zzgf.zzc) {
                    zzgf.zzc = null;
                } else {
                    zzgf.zzs.zzaz().zzd.zza("Current scheduler thread is neither worker nor network");
                }
                this.zzd = true;
            }
        }
    }

    public final void zzc(InterruptedException interruptedException) {
        this.zza.zzs.zzaz().zzg.zzb(String.valueOf(getName()).concat(" was interrupted"), interruptedException);
    }
}
