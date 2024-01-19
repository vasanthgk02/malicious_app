package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzok implements zzoj {
    public static final zzhy zza;
    public static final zzhy zzb;
    public static final zzhy zzc;
    public static final zzhy zzd;

    static {
        zzhv zza2 = new zzhv(zzho.zza("com.google.android.gms.measurement")).zza();
        zza = zza2.zzf("measurement.service.audience.fix_skip_audience_with_failed_filters", true);
        zzb = zza2.zzf("measurement.audience.refresh_event_count_filters_timestamp", false);
        zzc = zza2.zzf("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", false);
        zzd = zza2.zzf("measurement.audience.use_bundle_timestamp_for_event_count_filters", false);
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

    public final boolean zzd() {
        return ((Boolean) zzd.zzb()).booleanValue();
    }
}
