package com.google.android.gms.internal.auth;

import com.android.tools.r8.GeneratedOutlineSupport;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final class zzdi<T> implements zzdg<T> {
    public volatile zzdg<T> zza;
    public volatile boolean zzb;
    public T zzc;

    public zzdi(zzdg<T> zzdg) {
        if (zzdg != null) {
            this.zza = zzdg;
            return;
        }
        throw null;
    }

    public final String toString() {
        Object obj = this.zza;
        if (obj == null) {
            String valueOf = String.valueOf(this.zzc);
            obj = GeneratedOutlineSupport.outline63(new StringBuilder(valueOf.length() + 25), "<supplier that returned ", valueOf, ">");
        }
        String valueOf2 = String.valueOf(obj);
        return GeneratedOutlineSupport.outline63(new StringBuilder(valueOf2.length() + 19), "Suppliers.memoize(", valueOf2, ")");
    }

    public final T zza() {
        if (!this.zzb) {
            synchronized (this) {
                if (!this.zzb) {
                    zzdg<T> zzdg = this.zza;
                    zzdg.getClass();
                    T zza2 = zzdg.zza();
                    this.zzc = zza2;
                    this.zzb = true;
                    this.zza = null;
                    return zza2;
                }
            }
        }
        return this.zzc;
    }
}
