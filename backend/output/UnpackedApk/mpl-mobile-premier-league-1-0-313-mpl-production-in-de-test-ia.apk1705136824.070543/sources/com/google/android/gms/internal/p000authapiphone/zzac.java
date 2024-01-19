package com.google.android.gms.internal.p000authapiphone;

import com.google.android.gms.common.Feature;

/* renamed from: com.google.android.gms.internal.auth-api-phone.zzac  reason: invalid package */
/* compiled from: com.google.android.gms:play-services-auth-api-phone@@17.5.1 */
public final class zzac {
    public static final Feature zza = new Feature("sms_code_autofill", 2);
    public static final Feature zzb = new Feature("sms_code_browser", 2);
    public static final Feature zzc = new Feature("sms_retrieve", 1);
    public static final Feature zzd;
    public static final Feature[] zze;

    static {
        Feature feature = new Feature("user_consent", 3);
        zzd = feature;
        zze = new Feature[]{zza, zzb, zzc, feature};
    }
}
