package com.google.android.gms.internal.auth;

import com.android.tools.r8.GeneratedOutlineSupport;
import in.juspay.hypersdk.core.InflateView;
import java.util.Map.Entry;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final class zzgi implements Entry, Comparable<zzgi> {
    public final /* synthetic */ zzgl zza;
    public final Comparable zzb;
    public Object zzc;

    public zzgi(zzgl zzgl, Comparable comparable, Object obj) {
        this.zza = zzgl;
        this.zzb = comparable;
        this.zzc = obj;
    }

    public static final boolean zzb(Object obj, Object obj2) {
        boolean z;
        if (obj != null) {
            z = obj.equals(obj2);
        } else if (obj2 == null) {
            return true;
        } else {
            z = false;
        }
        return z;
    }

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return this.zzb.compareTo(((zzgi) obj).zzb);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        return zzb(this.zzb, entry.getKey()) && zzb(this.zzc, entry.getValue());
    }

    public final /* bridge */ /* synthetic */ Object getKey() {
        return this.zzb;
    }

    public final Object getValue() {
        return this.zzc;
    }

    public final int hashCode() {
        Comparable comparable = this.zzb;
        int i = 0;
        int hashCode = comparable == null ? 0 : comparable.hashCode();
        Object obj = this.zzc;
        if (obj != null) {
            i = obj.hashCode();
        }
        return hashCode ^ i;
    }

    public final Object setValue(Object obj) {
        this.zza.zzn();
        Object obj2 = this.zzc;
        this.zzc = obj;
        return obj2;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzb);
        String valueOf2 = String.valueOf(this.zzc);
        return GeneratedOutlineSupport.outline63(new StringBuilder(valueOf.length() + 1 + valueOf2.length()), valueOf, InflateView.SETTER_EQUALS, valueOf2);
    }

    public final Comparable zza() {
        return this.zzb;
    }
}
