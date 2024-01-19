package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzpi implements zzph {
    public static final zzhy zza;
    public static final zzhy zzb;
    public static final zzhy zzc;
    public static final zzhy zzd;
    public static final zzhy zze;
    public static final zzhy zzf;
    public static final zzhy zzg;
    public static final zzhy zzh;
    public static final zzhy zzi;
    public static final zzhy zzj;
    public static final zzhy zzk;
    public static final zzhy zzl;
    public static final zzhy zzm;

    static {
        zzhv zza2 = new zzhv(zzho.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zza2.zzf("measurement.redaction.app_instance_id", true);
        zzb = zza2.zzf("measurement.redaction.client_ephemeral_aiid_generation", true);
        zzc = zza2.zzf("measurement.redaction.config_redacted_fields", true);
        zzd = zza2.zzf("measurement.redaction.device_info", true);
        zze = zza2.zzf("measurement.redaction.e_tag", true);
        zzf = zza2.zzf("measurement.redaction.enhanced_uid", true);
        zzg = zza2.zzf("measurement.redaction.populate_ephemeral_app_instance_id", true);
        zzh = zza2.zzf("measurement.redaction.google_signals", true);
        zzi = zza2.zzf("measurement.redaction.no_aiid_in_config_request", true);
        zzj = zza2.zzf("measurement.redaction.upload_redacted_fields", true);
        zzk = zza2.zzf("measurement.redaction.upload_subdomain_override", true);
        zzl = zza2.zzf("measurement.redaction.user_id", true);
        zzm = zza2.zzd("measurement.id.redaction", 0);
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

    public final boolean zzf() {
        return ((Boolean) zze.zzb()).booleanValue();
    }

    public final boolean zzg() {
        return ((Boolean) zzf.zzb()).booleanValue();
    }

    public final boolean zzh() {
        return ((Boolean) zzg.zzb()).booleanValue();
    }

    public final boolean zzi() {
        return ((Boolean) zzh.zzb()).booleanValue();
    }

    public final boolean zzj() {
        return ((Boolean) zzi.zzb()).booleanValue();
    }

    public final boolean zzk() {
        return ((Boolean) zzj.zzb()).booleanValue();
    }

    public final boolean zzl() {
        return ((Boolean) zzk.zzb()).booleanValue();
    }

    public final boolean zzm() {
        return ((Boolean) zzl.zzb()).booleanValue();
    }
}
