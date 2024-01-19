package com.google.android.gms.internal.measurement;

import com.android.tools.r8.GeneratedOutlineSupport;
import in.juspay.hypersdk.core.InflateView;
import java.util.Map.Entry;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.1.2 */
public final class zzmb implements Entry, Comparable {
    public final /* synthetic */ zzmh zza;
    public final Comparable zzb;
    public Object zzc;

    public zzmb(zzmh zzmh, Comparable comparable, Object obj) {
        this.zza = zzmh;
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
        return this.zzb.compareTo(((zzmb) obj).zzb);
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

    public final /* synthetic */ Object getKey() {
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
        return GeneratedOutlineSupport.outline52(String.valueOf(this.zzb), InflateView.SETTER_EQUALS, String.valueOf(this.zzc));
    }

    public final Comparable zza() {
        return this.zzb;
    }
}
