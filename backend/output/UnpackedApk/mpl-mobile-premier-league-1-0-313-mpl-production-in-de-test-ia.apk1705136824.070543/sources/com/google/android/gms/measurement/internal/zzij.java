package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzij implements Runnable {
    public final /* synthetic */ boolean zza;
    public final /* synthetic */ zzin zzb;

    public zzij(zzin zzin, boolean z) {
        this.zzb = zzin;
        this.zza = z;
    }

    public final void run() {
        boolean zzJ = this.zzb.zzs.zzJ();
        boolean zzI = this.zzb.zzs.zzI();
        this.zzb.zzs.zzE = Boolean.valueOf(this.zza);
        if (zzI == this.zza) {
            this.zzb.zzs.zzaz().zzl.zzb("Default data collection state already set to", Boolean.valueOf(this.zza));
        }
        if (this.zzb.zzs.zzJ() == zzJ || this.zzb.zzs.zzJ() != this.zzb.zzs.zzI()) {
            this.zzb.zzs.zzaz().zzi.zzc("Default data collection is different than actual status", Boolean.valueOf(this.zza), Boolean.valueOf(zzJ));
        }
        this.zzb.zzae();
    }
}
