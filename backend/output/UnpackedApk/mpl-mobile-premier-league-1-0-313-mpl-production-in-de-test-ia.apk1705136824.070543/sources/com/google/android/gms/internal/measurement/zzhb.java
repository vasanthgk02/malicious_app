package com.google.android.gms.internal.measurement;

import android.content.Context;
import com.android.tools.r8.GeneratedOutlineSupport;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzhb extends zzhw {
    public final Context zza;
    public final zzif zzb;

    public zzhb(Context context, zzif zzif) {
        if (context != null) {
            this.zza = context;
            this.zzb = zzif;
            return;
        }
        throw new NullPointerException("Null context");
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzhw) {
            zzhw zzhw = (zzhw) obj;
            if (this.zza.equals(zzhw.zza())) {
                zzif zzif = this.zzb;
                if (zzif != null ? zzif.equals(zzhw.zzb()) : zzhw.zzb() == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i;
        int hashCode = (this.zza.hashCode() ^ 1000003) * 1000003;
        zzif zzif = this.zzb;
        if (zzif == null) {
            i = 0;
        } else {
            i = zzif.hashCode();
        }
        return hashCode ^ i;
    }

    public final String toString() {
        return GeneratedOutlineSupport.outline54("FlagsContext{context=", this.zza.toString(), ", hermeticFileOverrides=", String.valueOf(this.zzb), "}");
    }

    public final Context zza() {
        return this.zza;
    }

    public final zzif zzb() {
        return this.zzb;
    }
}
