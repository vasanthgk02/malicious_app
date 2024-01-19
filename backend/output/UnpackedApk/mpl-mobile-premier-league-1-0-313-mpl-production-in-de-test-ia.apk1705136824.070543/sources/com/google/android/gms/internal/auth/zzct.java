package com.google.android.gms.internal.auth;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final class zzct extends zzcz<Long> {
    public zzct(zzcx zzcx, String str, Long l, boolean z) {
        super(zzcx, str, l, true, null);
    }

    public final /* bridge */ /* synthetic */ Object zza(Object obj) {
        try {
            return Long.valueOf(Long.parseLong((String) obj));
        } catch (NumberFormatException unused) {
            String.valueOf(super.zzc()).length();
            ((String) obj).length();
            return null;
        }
    }
}
