package com.google.android.gms.internal.measurement;

import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.1.2 */
public final class zzis extends zziu {
    public final /* synthetic */ zzjb zza;
    public int zzb = 0;
    public final int zzc = this.zza.zzd();

    public zzis(zzjb zzjb) {
        this.zza = zzjb;
    }

    public final boolean hasNext() {
        return this.zzb < this.zzc;
    }

    public final byte zza() {
        int i = this.zzb;
        if (i < this.zzc) {
            this.zzb = i + 1;
            return this.zza.zzb(i);
        }
        throw new NoSuchElementException();
    }
}
