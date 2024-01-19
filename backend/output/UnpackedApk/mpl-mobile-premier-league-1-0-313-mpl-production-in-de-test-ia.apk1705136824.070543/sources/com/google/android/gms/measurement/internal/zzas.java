package com.google.android.gms.measurement.internal;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzas implements Iterator {
    public final Iterator zza = this.zzb.zza.keySet().iterator();
    public final /* synthetic */ zzat zzb;

    public zzas(zzat zzat) {
        this.zzb = zzat;
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }

    /* renamed from: zza */
    public final String next() {
        return (String) this.zza.next();
    }
}
