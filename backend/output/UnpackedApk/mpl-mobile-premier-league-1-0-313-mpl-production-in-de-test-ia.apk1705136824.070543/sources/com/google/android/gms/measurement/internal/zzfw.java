package com.google.android.gms.measurement.internal;

import androidx.collection.LruCache;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzc;
import com.google.android.gms.internal.measurement.zzfe;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzfw extends LruCache {
    public final /* synthetic */ zzfz zza;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public zzfw(zzfz zzfz) {
        // this.zza = zzfz;
        super(20);
    }

    public final /* bridge */ /* synthetic */ Object create(Object obj) {
        String str = (String) obj;
        Preconditions.checkNotEmpty(str);
        zzfz zzfz = this.zza;
        zzfz.zzW();
        Preconditions.checkNotEmpty(str);
        if (!zzfz.zzo(str)) {
            return null;
        }
        if (!zzfz.zzh.containsKey(str) || zzfz.zzh.get(str) == null) {
            zzfz.zzC(str);
        } else {
            zzfz.zzD(str, (zzfe) zzfz.zzh.get(str));
        }
        return (zzc) zzfz.zzd.snapshot().get(str);
    }
}
