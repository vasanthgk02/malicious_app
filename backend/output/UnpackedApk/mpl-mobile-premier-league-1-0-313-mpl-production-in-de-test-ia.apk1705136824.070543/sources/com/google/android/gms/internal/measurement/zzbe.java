package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzbe implements zzbf {
    public final zzg zza;
    public final String zzb;

    public zzbe(zzg zzg, String str) {
        this.zza = zzg;
        this.zzb = str;
    }

    public final zzg zza(zzap zzap) {
        zzg zza2 = this.zza.zza();
        zza2.zze(this.zzb, zzap);
        return zza2;
    }
}
