package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.1.2 */
public final class zzmn extends zzml {
    public final /* synthetic */ int zza(Object obj) {
        return ((zzmm) obj).zza();
    }

    public final /* synthetic */ int zzb(Object obj) {
        return ((zzmm) obj).zzb();
    }

    public final /* synthetic */ Object zzc(Object obj) {
        return ((zzkc) obj).zzc;
    }

    public final /* bridge */ /* synthetic */ Object zzd(Object obj, Object obj2) {
        zzmm zzmm = (zzmm) obj2;
        if (zzmm.equals(zzmm.zzc())) {
            return obj;
        }
        return zzmm.zzd((zzmm) obj, zzmm);
    }

    public final /* synthetic */ Object zze() {
        return zzmm.zze();
    }

    public final /* bridge */ /* synthetic */ void zzf(Object obj, int i, long j) {
        ((zzmm) obj).zzh(i << 3, Long.valueOf(j));
    }

    public final void zzg(Object obj) {
        ((zzkc) obj).zzc.zzf();
    }

    public final /* synthetic */ void zzh(Object obj, Object obj2) {
        ((zzkc) obj).zzc = (zzmm) obj2;
    }

    public final /* synthetic */ void zzi(Object obj, zznd zznd) throws IOException {
        ((zzmm) obj).zzi(zznd);
    }
}
