package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzko extends zzao {
    public final /* synthetic */ zzkp zza;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public zzko(zzkp zzkp, zzhd zzhd) {
        // this.zza = zzkp;
        super(zzhd);
    }

    public final void zzc() {
        zzkp zzkp = this.zza;
        zzkp.zzc.zzg();
        zzkp.zzd(false, false, zzkp.zzc.zzs.zzr.elapsedRealtime());
        zzkp.zzc.zzs.zzd().zzf(zzkp.zzc.zzs.zzr.elapsedRealtime());
    }
}
