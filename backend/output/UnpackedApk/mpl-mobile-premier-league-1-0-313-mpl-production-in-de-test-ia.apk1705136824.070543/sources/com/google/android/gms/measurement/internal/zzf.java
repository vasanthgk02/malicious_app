package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public abstract class zzf extends zze {
    public boolean zza;

    public zzf(zzgi zzgi) {
        super(zzgi);
        this.zzs.zzG++;
    }

    public final void zza() {
        if (!this.zza) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzb() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        } else if (!zzf()) {
            this.zzs.zzH.incrementAndGet();
            this.zza = true;
        }
    }

    public void zzd() {
    }

    public abstract boolean zzf();
}
