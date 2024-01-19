package com.google.android.gms.internal.auth;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Serializable;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final class zzdh<T> implements Serializable, zzdg {
    public final zzdg<T> zza;
    public volatile transient boolean zzb;
    public transient T zzc;

    public zzdh(zzdg<T> zzdg) {
        if (zzdg != null) {
            this.zza = zzdg;
            return;
        }
        throw null;
    }

    public final String toString() {
        Object obj;
        if (this.zzb) {
            String valueOf = String.valueOf(this.zzc);
            obj = GeneratedOutlineSupport.outline63(new StringBuilder(valueOf.length() + 25), "<supplier that returned ", valueOf, ">");
        } else {
            obj = this.zza;
        }
        String valueOf2 = String.valueOf(obj);
        return GeneratedOutlineSupport.outline63(new StringBuilder(valueOf2.length() + 19), "Suppliers.memoize(", valueOf2, ")");
    }

    public final T zza() {
        if (!this.zzb) {
            synchronized (this) {
                if (!this.zzb) {
                    T zza2 = this.zza.zza();
                    this.zzc = zza2;
                    this.zzb = true;
                    return zza2;
                }
            }
        }
        return this.zzc;
    }
}
