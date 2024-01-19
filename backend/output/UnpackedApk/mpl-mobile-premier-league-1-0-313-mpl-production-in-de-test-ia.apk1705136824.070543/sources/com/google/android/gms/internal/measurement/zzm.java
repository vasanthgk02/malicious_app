package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzm extends zzai {
    public final /* synthetic */ zzo zza;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public zzm(zzn zzn, String str, zzo zzo) {
        // this.zza = zzo;
        super("getValue");
    }

    public final zzap zza(zzg zzg, List list) {
        zzh.zzh("getValue", 2, list);
        zzap zzb = zzg.zzb((zzap) list.get(0));
        zzap zzb2 = zzg.zzb((zzap) list.get(1));
        String zza2 = this.zza.zza(zzb.zzi());
        return zza2 != null ? new zzat(zza2) : zzb2;
    }
}
