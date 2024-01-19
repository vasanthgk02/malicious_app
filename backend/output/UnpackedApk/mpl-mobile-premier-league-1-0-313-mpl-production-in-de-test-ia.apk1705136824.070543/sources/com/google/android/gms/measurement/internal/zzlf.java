package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzfs;
import com.google.android.gms.internal.measurement.zzgc;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzlf {
    public zzgc zza;
    public List zzb;
    public List zzc;
    public long zzd;
    public final /* synthetic */ zzli zze;

    public /* synthetic */ zzlf(zzli zzli) {
        this.zze = zzli;
    }

    public final boolean zza(long j, zzfs zzfs) {
        Preconditions.checkNotNull(zzfs);
        if (this.zzc == null) {
            this.zzc = new ArrayList();
        }
        if (this.zzb == null) {
            this.zzb = new ArrayList();
        }
        if (this.zzc.size() > 0 && ((((zzfs) this.zzc.get(0)).zzd() / 1000) / 60) / 60 != ((zzfs.zzd() / 1000) / 60) / 60) {
            return false;
        }
        long zzbz = this.zzd + ((long) zzfs.zzbz());
        this.zze.zzg();
        if (zzbz >= ((long) Math.max(0, ((Integer) zzel.zzh.zza(null)).intValue()))) {
            return false;
        }
        this.zzd = zzbz;
        this.zzc.add(zzfs);
        this.zzb.add(Long.valueOf(j));
        int size = this.zzc.size();
        this.zze.zzg();
        if (size >= Math.max(1, ((Integer) zzel.zzi.zza(null)).intValue())) {
            return false;
        }
        return true;
    }
}
