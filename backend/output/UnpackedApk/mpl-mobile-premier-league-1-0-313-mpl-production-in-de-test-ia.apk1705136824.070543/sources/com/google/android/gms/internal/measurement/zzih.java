package com.google.android.gms.internal.measurement;

import com.android.tools.r8.GeneratedOutlineSupport;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzih implements zzif {
    public volatile zzif zza;
    public volatile boolean zzb;
    public Object zzc;

    public zzih(zzif zzif) {
        if (zzif != null) {
            this.zza = zzif;
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
        String obj2 = obj.toString();
        return GeneratedOutlineSupport.outline63(new StringBuilder(obj2.length() + 19), "Suppliers.memoize(", obj2, ")");
    }

    public final Object zza() {
        if (!this.zzb) {
            synchronized (this) {
                if (!this.zzb) {
                    zzif zzif = this.zza;
                    zzif.getClass();
                    Object zza2 = zzif.zza();
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
