package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzot implements zzos {
    public static final zzhy zza;
    public static final zzhy zzb;
    public static final zzhy zzc;
    public static final zzhy zzd;

    static {
        zzhv zza2 = new zzhv(zzho.zza("com.google.android.gms.measurement")).zza();
        zza = zza2.zzd("measurement.id.lifecycle.app_in_background_parameter", 0);
        zzb = zza2.zzf("measurement.lifecycle.app_backgrounded_tracking", true);
        zzc = zza2.zzf("measurement.lifecycle.app_in_background_parameter", false);
        zzd = zza2.zzd("measurement.id.lifecycle.app_backgrounded_tracking", 0);
    }

    public final boolean zza() {
        return ((Boolean) zzc.zzb()).booleanValue();
    }
}
