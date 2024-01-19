package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzow implements zzov {
    public static final zzhy zza;
    public static final zzhy zzb;

    static {
        zzhv zza2 = new zzhv(zzho.zza("com.google.android.gms.measurement")).zza();
        zza = zza2.zzf("measurement.validation.internal_limits_internal_event_params", true);
        zzb = zza2.zzd("measurement.id.validation.internal_limits_internal_event_params", 0);
    }

    public final boolean zza() {
        return ((Boolean) zza.zzb()).booleanValue();
    }
}
