package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzas implements Iterator {
    public final /* synthetic */ zzat zza;
    public int zzb = 0;

    public zzas(zzat zzat) {
        this.zza = zzat;
    }

    public final boolean hasNext() {
        return this.zzb < this.zza.zza.length();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        int i = this.zzb;
        zzat zzat = this.zza;
        if (i < zzat.zza.length()) {
            String zzb2 = zzat.zza;
            this.zzb = i + 1;
            return new zzat(String.valueOf(zzb2.charAt(i)));
        }
        throw new NoSuchElementException();
    }
}
