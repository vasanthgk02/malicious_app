package com.google.android.gms.internal.measurement;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.1.2 */
public final class zzmp implements Iterator {
    public final Iterator zza = this.zzb.zza.iterator();
    public final /* synthetic */ zzmq zzb;

    public zzmp(zzmq zzmq) {
        this.zzb = zzmq;
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        return (String) this.zza.next();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
