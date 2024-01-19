package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzgf extends zzhc {
    public static final AtomicLong zza = new AtomicLong(Long.MIN_VALUE);
    public zzge zzb;
    public zzge zzc;
    public final PriorityBlockingQueue zzd = new PriorityBlockingQueue();
    public final BlockingQueue zze = new LinkedBlockingQueue();
    public final UncaughtExceptionHandler zzf = new zzgc(this, "Thread death: Uncaught exception on worker thread");
    public final UncaughtExceptionHandler zzg = new zzgc(this, "Thread death: Uncaught exception on network thread");
    public final Object zzh = new Object();
    public final Semaphore zzi = new Semaphore(2);
    public volatile boolean zzj;

    public zzgf(zzgi zzgi) {
        super(zzgi);
    }

    public final void zzay() {
        if (Thread.currentThread() != this.zzc) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:11|12|13|14|15) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0025, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r3 = r1.zzs.zzaz().zzg;
        r3.zza("Interrupted waiting for " + r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0044, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000e, code lost:
        r2 = r2.get();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0012, code lost:
        if (r2 != null) goto L_0x0025;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0014, code lost:
        r1.zzs.zzaz().zzg.zza("Timed out waiting for ".concat(r5));
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0026 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object zzd(java.util.concurrent.atomic.AtomicReference r2, long r3, java.lang.String r5, java.lang.Runnable r6) {
        /*
            r1 = this;
            monitor-enter(r2)
            com.google.android.gms.measurement.internal.zzgi r0 = r1.zzs     // Catch:{ all -> 0x0045 }
            com.google.android.gms.measurement.internal.zzgf r0 = r0.zzaA()     // Catch:{ all -> 0x0045 }
            r0.zzp(r6)     // Catch:{ all -> 0x0045 }
            r2.wait(r3)     // Catch:{ InterruptedException -> 0x0026 }
            monitor-exit(r2)     // Catch:{ all -> 0x0045 }
            java.lang.Object r2 = r2.get()
            if (r2 != 0) goto L_0x0025
            com.google.android.gms.measurement.internal.zzgi r3 = r1.zzs
            com.google.android.gms.measurement.internal.zzey r3 = r3.zzaz()
            com.google.android.gms.measurement.internal.zzew r3 = r3.zzg
            java.lang.String r4 = "Timed out waiting for "
            java.lang.String r4 = r4.concat(r5)
            r3.zza(r4)
        L_0x0025:
            return r2
        L_0x0026:
            com.google.android.gms.measurement.internal.zzgi r3 = r1.zzs     // Catch:{ all -> 0x0045 }
            com.google.android.gms.measurement.internal.zzey r3 = r3.zzaz()     // Catch:{ all -> 0x0045 }
            com.google.android.gms.measurement.internal.zzew r3 = r3.zzg     // Catch:{ all -> 0x0045 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0045 }
            r4.<init>()     // Catch:{ all -> 0x0045 }
            java.lang.String r6 = "Interrupted waiting for "
            r4.append(r6)     // Catch:{ all -> 0x0045 }
            r4.append(r5)     // Catch:{ all -> 0x0045 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0045 }
            r3.zza(r4)     // Catch:{ all -> 0x0045 }
            monitor-exit(r2)     // Catch:{ all -> 0x0045 }
            r2 = 0
            return r2
        L_0x0045:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0045 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzgf.zzd(java.util.concurrent.atomic.AtomicReference, long, java.lang.String, java.lang.Runnable):java.lang.Object");
    }

    public final boolean zzf() {
        return false;
    }

    public final void zzg() {
        if (Thread.currentThread() != this.zzb) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    public final Future zzh(Callable callable) throws IllegalStateException {
        zzu();
        Preconditions.checkNotNull(callable);
        zzgd zzgd = new zzgd(this, callable, false);
        if (Thread.currentThread() == this.zzb) {
            if (!this.zzd.isEmpty()) {
                this.zzs.zzaz().zzg.zza("Callable skipped the worker queue.");
            }
            zzgd.run();
        } else {
            zzt(zzgd);
        }
        return zzgd;
    }

    public final void zzo(Runnable runnable) throws IllegalStateException {
        zzu();
        Preconditions.checkNotNull(runnable);
        zzgd zzgd = new zzgd(this, runnable, false, "Task exception on network thread");
        synchronized (this.zzh) {
            this.zze.add(zzgd);
            zzge zzge = this.zzc;
            if (zzge == null) {
                zzge zzge2 = new zzge(this, "Measurement Network", this.zze);
                this.zzc = zzge2;
                zzge2.setUncaughtExceptionHandler(this.zzg);
                this.zzc.start();
            } else {
                synchronized (zzge.zzb) {
                    zzge.zzb.notifyAll();
                }
            }
        }
    }

    public final void zzp(Runnable runnable) throws IllegalStateException {
        zzu();
        Preconditions.checkNotNull(runnable);
        zzt(new zzgd(this, runnable, false, "Task exception on worker thread"));
    }

    public final void zzq(Runnable runnable) throws IllegalStateException {
        zzu();
        Preconditions.checkNotNull(runnable);
        zzt(new zzgd(this, runnable, true, "Task exception on worker thread"));
    }

    public final boolean zzs() {
        return Thread.currentThread() == this.zzb;
    }

    public final void zzt(zzgd zzgd) {
        synchronized (this.zzh) {
            this.zzd.add(zzgd);
            zzge zzge = this.zzb;
            if (zzge == null) {
                zzge zzge2 = new zzge(this, "Measurement Worker", this.zzd);
                this.zzb = zzge2;
                zzge2.setUncaughtExceptionHandler(this.zzf);
                this.zzb.start();
            } else {
                synchronized (zzge.zzb) {
                    zzge.zzb.notifyAll();
                }
            }
        }
    }
}
