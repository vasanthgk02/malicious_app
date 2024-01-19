package com.google.android.gms.auth;

import com.google.android.gms.common.Feature;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final class zze {
    public static final Feature zza = new Feature("account_capability_api", 1);
    public static final Feature zzb = new Feature("account_data_service", 6);
    public static final Feature zzc = new Feature("account_data_service_legacy", 1);
    public static final Feature zzd = new Feature("account_data_service_token", 4);
    public static final Feature zze = new Feature("account_data_service_visibility", 1);
    public static final Feature zzf = new Feature("google_auth_service_token", 3);
    public static final Feature zzg = new Feature("google_auth_service_accounts", 2);
    public static final Feature zzh = new Feature("work_account_client_is_whitelisted", 1);
    public static final Feature zzi;
    public static final Feature[] zzj;

    static {
        Feature feature = new Feature("config_sync", 1);
        zzi = feature;
        zzj = new Feature[]{zza, zzb, zzc, zzd, zze, zzf, zzg, zzh, feature};
    }
}
