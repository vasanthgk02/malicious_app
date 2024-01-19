package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzny implements zznx {
    public static final zzhy zza;
    public static final zzhy zzb;
    public static final zzhy zzc;
    public static final zzhy zzd;

    static {
        zzhv zza2 = new zzhv(zzho.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zza2.zzf("measurement.enhanced_campaign.client", true);
        zzb = zza2.zzf("measurement.enhanced_campaign.service", true);
        zzc = zza2.zzf("measurement.enhanced_campaign.srsltid.client", false);
        zzd = zza2.zzf("measurement.enhanced_campaign.srsltid.service", false);
    }

    public final boolean zza() {
        return true;
    }

    public final boolean zzb() {
        return ((Boolean) zza.zzb()).booleanValue();
    }

    public final boolean zzc() {
        return ((Boolean) zzb.zzb()).booleanValue();
    }

    public final boolean zzd() {
        return ((Boolean) zzc.zzb()).booleanValue();
    }

    public final boolean zze() {
        return ((Boolean) zzd.zzb()).booleanValue();
    }
}
