package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzjl extends zzao {
    public final /* synthetic */ zzkb zza;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public zzjl(zzkb zzkb, zzhd zzhd) {
        // this.zza = zzkb;
        super(zzhd);
    }

    public final void zzc() {
        zzkb zzkb = this.zza;
        zzkb.zzg();
        if (zzkb.zzL()) {
            zzkb.zzs.zzaz().zzl.zza("Inactivity, disconnecting from the service");
            zzkb.zzs();
        }
    }
}
