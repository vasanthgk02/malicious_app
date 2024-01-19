package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzgd extends FutureTask implements Comparable {
    public final boolean zza;
    public final /* synthetic */ zzgf zzb;
    public final long zzc;
    public final String zzd;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public zzgd(zzgf zzgf, Runnable runnable, boolean z, String str) {
        // this.zzb = zzgf;
        super(runnable, null);
        Preconditions.checkNotNull(str);
        long andIncrement = zzgf.zza.getAndIncrement();
        this.zzc = andIncrement;
        this.zzd = str;
        this.zza = z;
        if (andIncrement == Long.MAX_VALUE) {
            zzgf.zzs.zzaz().zzd.zza("Tasks index overflow");
        }
    }

    public final int compareTo(Object obj) {
        zzgd zzgd = (zzgd) obj;
        boolean z = this.zza;
        int i = 1;
        if (z == zzgd.zza) {
            int i2 = (this.zzc > zzgd.zzc ? 1 : (this.zzc == zzgd.zzc ? 0 : -1));
            if (i2 < 0) {
                i = -1;
            } else if (i2 <= 0) {
                this.zzb.zzs.zzaz().zze.zzb("Two tasks share the same index. index", Long.valueOf(this.zzc));
                return 0;
            }
        } else if (!z) {
            return i;
        } else {
            return -1;
        }
        return i;
    }

    public final void setException(Throwable th) {
        this.zzb.zzs.zzaz().zzd.zzb(this.zzd, th);
        super.setException(th);
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public zzgd(zzgf zzgf, Callable callable, boolean z) {
        // this.zzb = zzgf;
        super(callable);
        Preconditions.checkNotNull("Task exception on worker thread");
        long andIncrement = zzgf.zza.getAndIncrement();
        this.zzc = andIncrement;
        this.zzd = "Task exception on worker thread";
        this.zza = z;
        if (andIncrement == Long.MAX_VALUE) {
            zzgf.zzs.zzaz().zzd.zza("Tasks index overflow");
        }
    }
}
