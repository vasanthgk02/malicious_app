package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public abstract class zzkw extends zzkv {
    public boolean zza;

    public zzkw(zzli zzli) {
        super(zzli);
        this.zzf.zzr++;
    }

    public final void zzW() {
        if (!this.zza) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzX() {
        if (!this.zza) {
            zzb();
            this.zzf.zzs++;
            this.zza = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    public abstract boolean zzb();
}
