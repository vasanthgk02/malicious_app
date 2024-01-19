package com.google.android.gms.internal.measurement;

import com.android.tools.r8.GeneratedOutlineSupport;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzie extends zzid {
    public final Object zza;

    public zzie(Object obj) {
        this.zza = obj;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzie) {
            return this.zza.equals(((zzie) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode() + 1502476572;
    }

    public final String toString() {
        String obj = this.zza.toString();
        return GeneratedOutlineSupport.outline63(new StringBuilder(obj.length() + 13), "Optional.of(", obj, ")");
    }

    public final Object zza() {
        return this.zza;
    }

    public final boolean zzb() {
        return true;
    }
}
