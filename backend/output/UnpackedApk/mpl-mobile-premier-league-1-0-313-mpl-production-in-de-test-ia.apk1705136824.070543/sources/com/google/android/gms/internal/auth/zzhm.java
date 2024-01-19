package com.google.android.gms.internal.auth;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final class zzhm implements zzhk {
    public static final zzcz<Double> zza;
    public static final zzcz<Boolean> zzb;
    public static final zzcz<Long> zzc;
    public static final zzcz<Long> zzd;
    public static final zzcz<Boolean> zze;
    public static final zzcz<zzhi> zzf;
    public static final zzcz<Boolean> zzg;
    public static final zzcz<Long> zzh;
    public static final zzcz<Long> zzi;
    public static final zzcz<Boolean> zzj;
    public static final zzcz<Boolean> zzk;
    public static final zzcz<Long> zzl;
    public static final zzcz<Boolean> zzm;
    public static final zzcz<Double> zzn;

    static {
        zzcx zza2 = new zzcx(zzcq.zza("com.google.android.gms.auth_account")).zza();
        zza = zza2.zzb("getTokenRefactor__account_data_service_sample_percentage", 0.0d);
        zzb = zza2.zzd("getTokenRefactor__account_data_service_tokenAPI_usable", true);
        zzc = zza2.zzc("getTokenRefactor__account_manager_timeout_seconds", 20);
        zzd = zza2.zzc("getTokenRefactor__android_id_shift", 0);
        zze = zza2.zzd("getTokenRefactor__authenticator_logic_improved", false);
        try {
            zzf = zza2.zze("getTokenRefactor__blocked_packages", zzhi.zzl(new byte[]{10, 19, 99, 111, 109, 46, 97, 110, 100, 114, 111, 105, 100, 46, 118, 101, 110, 100, 105, 110, 103, 10, 32, 99, 111, 109, 46, 103, 111, 111, 103, 108, 101, 46, 97, 110, 100, 114, 111, 105, 100, 46, 97, 112, 112, 115, 46, 109, 101, 101, 116, 105, 110, 103, 115, 10, 33, 99, 111, 109, 46, 103, 111, 111, 103, 108, 101, 46, 97, 110, 100, 114, 111, 105, 100, 46, 97, 112, 112, 115, 46, 109, 101, 115, 115, 97, 103, 105, 110, 103}), zzhl.zza);
            zzg = zza2.zzd("getTokenRefactor__chimera_get_token_evolved", true);
            zzh = zza2.zzc("getTokenRefactor__clear_token_timeout_seconds", 20);
            zzi = zza2.zzc("getTokenRefactor__default_task_timeout_seconds", 20);
            zzj = zza2.zzd("getTokenRefactor__gaul_accounts_api_evolved", false);
            zzk = zza2.zzd("getTokenRefactor__gaul_token_api_evolved", false);
            zzl = zza2.zzc("getTokenRefactor__get_token_timeout_seconds", 120);
            zzm = zza2.zzd("getTokenRefactor__gms_account_authenticator_evolved", true);
            zzn = zza2.zzb("getTokenRefactor__gms_account_authenticator_sample_percentage", 0.0d);
        } catch (zzew e2) {
            throw new AssertionError("Could not parse proto flag \"getTokenRefactor__blocked_packages\"", e2);
        }
    }

    public final zzhi zza() {
        return (zzhi) zzf.zzb();
    }

    public final boolean zzb() {
        return ((Boolean) zzj.zzb()).booleanValue();
    }

    public final boolean zzc() {
        return ((Boolean) zzk.zzb()).booleanValue();
    }
}
