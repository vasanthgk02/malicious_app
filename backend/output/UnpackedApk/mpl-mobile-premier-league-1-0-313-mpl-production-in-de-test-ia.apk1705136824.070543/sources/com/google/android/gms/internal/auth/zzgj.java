package com.google.android.gms.internal.auth;

import java.util.Iterator;
import java.util.Map.Entry;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final class zzgj implements Iterator<Entry> {
    public final /* synthetic */ zzgl zza;
    public int zzb = -1;
    public boolean zzc;
    public Iterator<Entry> zzd;

    public /* synthetic */ zzgj(zzgl zzgl, zzge zzge) {
        this.zza = zzgl;
    }

    private final Iterator<Entry> zza() {
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
        return zza().next();
    }

    public final void remove() {
        if (this.zzc) {
            this.zzc = false;
            this.zza.zzn();
            if (this.zzb < this.zza.zzb.size()) {
                zzgl zzgl = this.zza;
                int i = this.zzb;
                this.zzb = i - 1;
                zzgl.zzl(i);
                return;
            }
            zza().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }
}
