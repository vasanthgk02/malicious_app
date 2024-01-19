package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public abstract class zzhc extends zzhb {
    public boolean zza;

    public zzhc(zzgi zzgi) {
        super(zzgi);
        this.zzs.zzG++;
    }

    public void zzaB() {
    }

    public abstract boolean zzf();

    public final void zzu() {
        if (!zzx()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzv() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        } else if (!zzf()) {
            this.zzs.zzH.incrementAndGet();
            this.zza = true;
        }
    }

    public final void zzw() {
        if (!this.zza) {
            zzaB();
            this.zzs.zzH.incrementAndGet();
            this.zza = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    public final boolean zzx() {
        return this.zza;
    }
}
