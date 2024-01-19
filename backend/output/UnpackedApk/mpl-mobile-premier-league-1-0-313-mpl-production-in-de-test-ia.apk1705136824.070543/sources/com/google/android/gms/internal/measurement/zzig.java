package com.google.android.gms.internal.measurement;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Serializable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzig implements Serializable, zzif {
    public final zzif zza;
    public volatile transient boolean zzb;
    public transient Object zzc;

    public zzig(zzif zzif) {
        if (zzif != null) {
            this.zza = zzif;
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

    public final Object zza() {
        if (!this.zzb) {
            synchronized (this) {
                if (!this.zzb) {
                    Object zza2 = this.zza.zza();
                    this.zzc = zza2;
                    this.zzb = true;
                    return zza2;
                }
            }
        }
        return this.zzc;
    }
}
