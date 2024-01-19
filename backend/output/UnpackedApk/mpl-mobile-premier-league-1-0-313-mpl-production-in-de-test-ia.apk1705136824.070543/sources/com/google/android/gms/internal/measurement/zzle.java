package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map.Entry;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.1.2 */
public final class zzle {
    public static final int zza(int i, Object obj, Object obj2) {
        zzld zzld = (zzld) obj;
        zzlc zzlc = (zzlc) obj2;
        if (!zzld.isEmpty()) {
            Iterator it = zzld.entrySet().iterator();
            if (it.hasNext()) {
                Entry entry = (Entry) it.next();
                entry.getKey();
                entry.getValue();
                throw null;
            }
        }
        return 0;
    }

    public static final Object zzb(Object obj, Object obj2) {
        zzld zzld = (zzld) obj;
        zzld zzld2 = (zzld) obj2;
        if (!zzld2.isEmpty()) {
            if (!zzld.zze()) {
                zzld = zzld.zzb();
            }
            zzld.zzd(zzld2);
        }
        return zzld;
    }
}
