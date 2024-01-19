package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzoh implements zzog {
    public static final zzhy zza;
    public static final zzhy zzb;

    static {
        zzhv zza2 = new zzhv(zzho.zza("com.google.android.gms.measurement")).zza();
        zza = zza2.zzf("measurement.client.consent.suppress_1p_in_ga4f_install", true);
        zzb = zza2.zzf("measurement.client.consent.gmpappid_worker_thread_fix", true);
    }

    public final boolean zza() {
        return true;
    }

    public final boolean zzb() {
        return ((Boolean) zzb.zzb()).booleanValue();
    }
}
