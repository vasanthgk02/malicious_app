package com.google.android.gms.internal.auth;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final class zzcv extends zzcz<Double> {
    public zzcv(zzcx zzcx, String str, Double d2, boolean z) {
        super(zzcx, str, d2, true, null);
    }

    public final /* bridge */ /* synthetic */ Object zza(Object obj) {
        try {
            return Double.valueOf(Double.parseDouble((String) obj));
        } catch (NumberFormatException unused) {
            String.valueOf(super.zzc()).length();
            ((String) obj).length();
            return null;
        }
    }
}
