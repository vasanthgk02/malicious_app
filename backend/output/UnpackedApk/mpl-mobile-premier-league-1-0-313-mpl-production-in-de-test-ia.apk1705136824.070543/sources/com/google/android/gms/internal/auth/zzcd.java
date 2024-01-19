package com.google.android.gms.internal.auth;

import android.content.Context;
import com.android.tools.r8.GeneratedOutlineSupport;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final class zzcd extends zzcy {
    public final Context zza;
    public final zzdg<zzde<zzco>> zzb;

    public zzcd(Context context, zzdg<zzde<zzco>> zzdg) {
        if (context != null) {
            this.zza = context;
            this.zzb = zzdg;
            return;
        }
        throw new NullPointerException("Null context");
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzcy) {
            zzcy zzcy = (zzcy) obj;
            if (this.zza.equals(zzcy.zza())) {
                zzdg<zzde<zzco>> zzdg = this.zzb;
                if (zzdg != null ? zzdg.equals(zzcy.zzb()) : zzcy.zzb() == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i;
        int hashCode = (this.zza.hashCode() ^ 1000003) * 1000003;
        zzdg<zzde<zzco>> zzdg = this.zzb;
        if (zzdg == null) {
            i = 0;
        } else {
            i = zzdg.hashCode();
        }
        return hashCode ^ i;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zza);
        String valueOf2 = String.valueOf(this.zzb);
        StringBuilder sb = new StringBuilder(valueOf.length() + 46 + valueOf2.length());
        GeneratedOutlineSupport.outline103(sb, "FlagsContext{context=", valueOf, ", hermeticFileOverrides=", valueOf2);
        sb.append("}");
        return sb.toString();
    }

    public final Context zza() {
        return this.zza;
    }

    public final zzdg<zzde<zzco>> zzb() {
        return this.zzb;
    }
}
