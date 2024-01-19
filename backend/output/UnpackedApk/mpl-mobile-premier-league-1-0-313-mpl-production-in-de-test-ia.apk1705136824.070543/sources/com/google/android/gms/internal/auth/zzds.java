package com.google.android.gms.internal.auth;

import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final class zzds extends zzdv {
    public final /* synthetic */ zzeb zza;
    public int zzb = 0;
    public final int zzc = this.zza.zzd();

    public zzds(zzeb zzeb) {
        this.zza = zzeb;
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
