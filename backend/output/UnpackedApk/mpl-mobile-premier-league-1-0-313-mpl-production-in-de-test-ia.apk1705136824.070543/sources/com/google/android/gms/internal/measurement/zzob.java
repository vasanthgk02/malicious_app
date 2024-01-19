package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzob implements zzoa {
    public static final zzhy zza;
    public static final zzhy zzb;
    public static final zzhy zzc;

    static {
        zzhv zza2 = new zzhv(zzho.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zza2.zzf("measurement.collection.event_safelist", true);
        zzb = zza2.zzf("measurement.service.store_null_safelist", true);
        zzc = zza2.zzf("measurement.service.store_safelist", true);
    }

    public final boolean zza() {
        return true;
    }

    public final boolean zzb() {
        return ((Boolean) zzb.zzb()).booleanValue();
    }

    public final boolean zzc() {
        return ((Boolean) zzc.zzb()).booleanValue();
    }
}
