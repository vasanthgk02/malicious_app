package com.google.android.gms.internal.auth;

import com.android.tools.r8.GeneratedOutlineSupport;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final class zzdf<T> extends zzde<T> {
    public final T zza;

    public zzdf(T t) {
        this.zza = t;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzdf) {
            return this.zza.equals(((zzdf) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode() + 1502476572;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zza);
        return GeneratedOutlineSupport.outline63(new StringBuilder(valueOf.length() + 13), "Optional.of(", valueOf, ")");
    }

    public final T zza() {
        return this.zza;
    }

    public final boolean zzb() {
        return true;
    }
}
