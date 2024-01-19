package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map.Entry;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.1.2 */
public final class zzmd implements Iterator {
    public final /* synthetic */ zzmh zza;
    public int zzb = -1;
    public boolean zzc;
    public Iterator zzd;

    public /* synthetic */ zzmd(zzmh zzmh, zzmc zzmc) {
        this.zza = zzmh;
    }

    private final Iterator zza() {
        if (this.zzd == null) {
            this.zzd = this.zza.zzc.entrySet().iterator();
        }
        return this.zzd;
    }

    public final boolean hasNext() {
        boolean z = true;
        if (this.zzb + 1 >= this.zza.zzb.size()) {
            if (this.zza.zzc.isEmpty()) {
                z = false;
            } else if (zza().hasNext()) {
                return z;
            } else {
                return false;
            }
        }
        return z;
    }

    public final /* bridge */ /* synthetic */ Object next() {
        this.zzc = true;
        int i = this.zzb + 1;
        this.zzb = i;
        if (i < this.zza.zzb.size()) {
            return (Entry) this.zza.zzb.get(this.zzb);
        }
        return (Entry) zza().next();
    }

    public final void remove() {
        if (this.zzc) {
            this.zzc = false;
            this.zza.zzn();
            if (this.zzb < this.zza.zzb.size()) {
                zzmh zzmh = this.zza;
                int i = this.zzb;
                this.zzb = i - 1;
                zzmh.zzl(i);
                return;
            }
            zza().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }
}
