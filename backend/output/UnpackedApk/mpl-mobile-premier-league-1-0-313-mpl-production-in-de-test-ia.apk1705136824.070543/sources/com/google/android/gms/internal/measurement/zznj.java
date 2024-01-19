package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zznj implements zzni {
    public static final zzhy zza;
    public static final zzhy zzb;

    static {
        zzhv zza2 = new zzhv(zzho.zza("com.google.android.gms.measurement")).zza();
        zza = zza2.zzf("measurement.androidId.delete_feature", true);
        zzb = zza2.zzf("measurement.log_androidId_enabled", false);
    }

    public final boolean zza() {
        return ((Boolean) zza.zzb()).booleanValue();
    }
}
