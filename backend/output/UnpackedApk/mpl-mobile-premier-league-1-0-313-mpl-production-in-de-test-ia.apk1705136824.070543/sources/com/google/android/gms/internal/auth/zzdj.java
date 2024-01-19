package com.google.android.gms.internal.auth;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Serializable;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final class zzdj<T> implements Serializable, zzdg {
    public final T zza;

    public zzdj(T t) {
        this.zza = t;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzdj)) {
            return false;
        }
        T t = this.zza;
        T t2 = ((zzdj) obj).zza;
        if (t == t2 || t.equals(t2)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza});
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zza);
        return GeneratedOutlineSupport.outline63(new StringBuilder(valueOf.length() + 22), "Suppliers.ofInstance(", valueOf, ")");
    }

    public final T zza() {
        return this.zza;
    }
}
