package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzoz implements zzoy {
    public static final zzhy zza;
    public static final zzhy zzb;
    public static final zzhy zzc;
    public static final zzhy zzd;
    public static final zzhy zze;

    static {
        zzhv zza2 = new zzhv(zzho.zza("com.google.android.gms.measurement")).zza();
        zza = zza2.zzf("measurement.test.boolean_flag", false);
        zzb = zza2.zzc("measurement.test.double_flag", -3.0d);
        zzc = zza2.zzd("measurement.test.int_flag", -2);
        zzd = zza2.zzd("measurement.test.long_flag", -1);
        zze = zza2.zze("measurement.test.string_flag", "---");
    }

    public final double zza() {
        return ((Double) zzb.zzb()).doubleValue();
    }

    public final long zzb() {
        return ((Long) zzc.zzb()).longValue();
    }

    public final long zzc() {
        return ((Long) zzd.zzb()).longValue();
    }

    public final String zzd() {
        return (String) zze.zzb();
    }

    public final boolean zze() {
        return ((Boolean) zza.zzb()).booleanValue();
    }
}
