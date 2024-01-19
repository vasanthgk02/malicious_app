package com.google.android.gms.internal.measurement;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Serializable;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzii implements Serializable, zzif {
    public final Object zza;

    public zzii(Object obj) {
        this.zza = obj;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzii)) {
            return false;
        }
        Object obj2 = this.zza;
        Object obj3 = ((zzii) obj).zza;
        if (obj2 == obj3 || obj2.equals(obj3)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza});
    }

    public final String toString() {
        String obj = this.zza.toString();
        return GeneratedOutlineSupport.outline63(new StringBuilder(obj.length() + 22), "Suppliers.ofInstance(", obj, ")");
    }

    public final Object zza() {
        return this.zza;
    }
}
