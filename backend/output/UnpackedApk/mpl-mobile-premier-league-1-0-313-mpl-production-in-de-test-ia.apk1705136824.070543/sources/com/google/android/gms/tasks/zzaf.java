package com.google.android.gms.tasks;

import java.util.concurrent.ExecutionException;

/* compiled from: com.google.android.gms:play-services-tasks@@18.0.2 */
public final class zzaf<T> implements zzae<T> {
    public final Object zza = new Object();
    public final int zzb;
    public final zzw zzc;
    public int zzd;
    public int zze;
    public int zzf;
    public Exception zzg;
    public boolean zzh;

    public zzaf(int i, zzw zzw) {
        this.zzb = i;
        this.zzc = zzw;
    }

    public final void onCanceled() {
        synchronized (this.zza) {
            this.zzf++;
            this.zzh = true;
            zza();
        }
    }

    public final void onFailure(Exception exc) {
        synchronized (this.zza) {
            this.zze++;
            this.zzg = exc;
            zza();
        }
    }

    public final void onSuccess(T t) {
        synchronized (this.zza) {
            this.zzd++;
            zza();
        }
    }

    public final void zza() {
        if (this.zzd + this.zze + this.zzf == this.zzb) {
            if (this.zzg != null) {
                zzw zzw = this.zzc;
                int i = this.zze;
                int i2 = this.zzb;
                zzw.zza(new ExecutionException(i + " out of " + i2 + " underlying tasks failed", this.zzg));
            } else if (this.zzh) {
                this.zzc.zzc();
            } else {
                this.zzc.zzb(null);
            }
        }
    }
}
