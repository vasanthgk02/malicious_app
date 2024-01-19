package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zznv implements zznu {
    public static final zzhy zza;
    public static final zzhy zzb;
    public static final zzhy zzc;
    public static final zzhy zzd;

    static {
        zzhv zza2 = new zzhv(zzho.zza("com.google.android.gms.measurement")).zza();
        zza = zza2.zzf("measurement.client.consent_state_v1", true);
        zzb = zza2.zzf("measurement.client.3p_consent_state_v1", true);
        zzc = zza2.zzf("measurement.service.consent_state_v1_W36", true);
        zzd = zza2.zzd("measurement.service.storage_consent_support_version", 203600);
    }

    public final long zza() {
        return ((Long) zzd.zzb()).longValue();
    }
}
